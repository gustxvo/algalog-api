package com.algaworks.algalog.api.model

import com.algaworks.algalog.domain.model.DeliveryStatus
import java.math.BigDecimal
import java.time.OffsetDateTime

data class DeliveryModel(
    val id: Long,
    val client: ClientSummaryModel,
    val addressee: AddresseeModel,
    val fee: BigDecimal,
    val deliveryStatus: DeliveryStatus?,
    val requestDate: OffsetDateTime?,
    val finishDate: OffsetDateTime?
)
