package com.algaworks.algalog.domain.model

import com.algaworks.algalog.domain.ValidationGroups
import com.algaworks.algalog.domain.exception.DomainException
import java.math.BigDecimal
import java.time.OffsetDateTime
import javax.persistence.*
import javax.validation.Valid
import javax.validation.constraints.NotNull
import javax.validation.groups.ConvertGroup
import javax.validation.groups.Default

@Entity
data class Delivery(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Valid
    @ConvertGroup(from = Default::class, to = ValidationGroups.ClientId::class)
    @NotNull
    @ManyToOne
    val client: Client,

    @Valid
    @Embedded
    val addressee: Addressee,

    @NotNull
    val fee: BigDecimal,

    @OneToMany(mappedBy = "delivery", cascade = [CascadeType.ALL])
    val occurrences: MutableList<Occurrence> = arrayListOf(),

    @Enumerated(EnumType.STRING)
    var status: DeliveryStatus?,

    val requestDate: OffsetDateTime?,

    var finishDate: OffsetDateTime?
) {
    fun addOccurrence(description: String): Occurrence {
        val occurrence = Occurrence(
            description = description,
            delivery = this,
            registerDate = OffsetDateTime.now(),
        )
        this.occurrences.add(occurrence)
        return occurrence
    }

    fun finish(): Delivery {
        if (!canBeFinished()) {
            throw DomainException("Delivery cannot be finished")
        }
        status = DeliveryStatus.FINISHED
        finishDate = OffsetDateTime.now()
        return this
    }

    private fun canBeFinished() = DeliveryStatus.PENDING == status
}