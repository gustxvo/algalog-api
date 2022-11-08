package com.algaworks.algalog.domain.service

import com.algaworks.algalog.domain.exception.EntityNotFoundException
import com.algaworks.algalog.domain.model.Delivery
import com.algaworks.algalog.domain.repository.DeliveryRepository
import org.springframework.stereotype.Service

@Service
class FindDeliveryService(
    private val deliveryRepository: DeliveryRepository
) {
    fun findById(deliveryId: Long): Delivery {
        return deliveryRepository.findById(deliveryId)
            .orElseThrow { EntityNotFoundException("Delivery not found") }
    }
}