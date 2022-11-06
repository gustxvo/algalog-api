package com.algaworks.algalog.domain.model

import com.algaworks.algalog.domain.ValidationGroups
import com.fasterxml.jackson.annotation.JsonProperty
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

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    val status: StatusDelivery?,

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    val requestDate: OffsetDateTime?,

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    val finishDate: OffsetDateTime?
)