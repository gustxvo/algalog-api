package com.algaworks.algalog.domain.service

import com.algaworks.algalog.domain.model.Delivery
import com.algaworks.algalog.domain.model.DeliveryStatus
import com.algaworks.algalog.domain.repository.DeliveryRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.OffsetDateTime

@Service
class DeliveryRequestService(
    private val deliveryRepository: DeliveryRepository,
    private val clientService: CatalogClientService
) {

    @Transactional
    fun request(deliveryInput: Delivery): Delivery {
        val client = clientService.findById(deliveryInput.client.id)
        val delivery = deliveryInput.copy(
            client = client,
            status = DeliveryStatus.PENDING,
            requestDate = OffsetDateTime.now()
        )
        return deliveryRepository.save(delivery)
    }
}