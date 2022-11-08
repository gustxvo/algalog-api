package com.algaworks.algalog.mapper

import com.algaworks.algalog.api.model.AddresseeModel
import com.algaworks.algalog.api.model.ClientSummaryModel
import com.algaworks.algalog.api.model.DeliveryModel
import com.algaworks.algalog.api.model.input.DeliveryInput
import com.algaworks.algalog.domain.model.Addressee
import com.algaworks.algalog.domain.model.Client
import com.algaworks.algalog.domain.model.Delivery


fun Delivery.toDeliveryModel() = DeliveryModel(
    id = id,
    client = ClientSummaryModel(
        id = client.id,
        name = client.name
    ),
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

fun DeliveryInput.toEntity() = Delivery(
    id = -1,
    client = Client(
        id = client.id,
        null, null, null
    ),
    addressee = Addressee(
        addressee.name,
        addressee.street,
        addressee.number,
        addressee.complement,
        addressee.district
    ),
    fee = fee,
    status = null,
    requestDate = null,
    finishDate = null
)