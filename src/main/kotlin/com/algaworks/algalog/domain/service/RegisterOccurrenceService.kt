package com.algaworks.algalog.domain.service

import com.algaworks.algalog.domain.model.Occurrence
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RegisterOccurrenceService(
    private val findDeliveryService: FindDeliveryService
) {

    @Transactional
    fun register(deliveryId: Long, description: String): Occurrence {
        val delivery = findDeliveryService.findById(deliveryId)
        return delivery.addOccurrence(description)
    }
}