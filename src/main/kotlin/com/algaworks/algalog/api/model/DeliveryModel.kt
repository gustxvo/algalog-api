package com.algaworks.algalog.api.model

import com.algaworks.algalog.domain.model.Delivery
import com.algaworks.algalog.domain.model.DeliveryStatus
import java.math.BigDecimal
import java.time.OffsetDateTime

data class DeliveryModel(
    val id: Long,
    val clientName: String,
    val addressee: AddresseeModel,
    val fee: BigDecimal,
    val deliveryStatus: DeliveryStatus?,
    val requestDate: OffsetDateTime?,
    val finishDate: OffsetDateTime?
)

fun Delivery.toDeliveryModel() = DeliveryModel(
    id = id,
    clientName = client.name ?: "",
    addressee = AddresseeModel(
        name = addressee.name,
        street = addressee.street,
        number = addressee.number,
        complement = addressee.complement,
        district = addressee.district
    ),
    fee = fee,
    deliveryStatus = status,
    requestDate = requestDate,
    finishDate = finishDate
)
