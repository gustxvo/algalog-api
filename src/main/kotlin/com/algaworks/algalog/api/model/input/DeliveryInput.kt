package com.algaworks.algalog.api.model.input

import java.math.BigDecimal
import javax.validation.Valid
import javax.validation.constraints.NotNull

data class DeliveryInput(
    @Valid
    @field:NotNull
    val client: ClientIdInput,

    @Valid
    @field:NotNull
    val addressee: AddresseeInput,

    @field:NotNull
    val fee: BigDecimal
)

class ClientIdInput(
    @field:NotNull val id: Long
)
