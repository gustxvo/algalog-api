package com.algaworks.algalog.domain.service

import com.algaworks.algalog.domain.model.Delivery
import com.algaworks.algalog.domain.model.StatusDelivery
import com.algaworks.algalog.domain.repository.ClientRepository
import com.algaworks.algalog.domain.repository.DeliveryRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.OffsetDateTime

@Service
class DeliveryRequestService(private val deliveryRepository: DeliveryRepository, private val clientRepository: ClientRepository) {

    @Transactional
    fun request(deliveryInput: Delivery): Delivery {
        val client = deliveryInput.client.id.let { clientRepository.findById(it).orElseThrow() }
        val delivery = deliveryInput.copy(
            client = client,
            status = StatusDelivery.PENDING,
            requestDate = OffsetDateTime.now()
        )
        return deliveryRepository.save(delivery)
    }
}