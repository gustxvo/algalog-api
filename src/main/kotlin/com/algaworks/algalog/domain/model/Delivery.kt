package com.algaworks.algalog.domain.model

import com.algaworks.algalog.domain.ValidationGroups
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

    @Enumerated(EnumType.STRING)
    val status: DeliveryStatus?,

    val requestDate: OffsetDateTime?,

    val finishDate: OffsetDateTime?
)