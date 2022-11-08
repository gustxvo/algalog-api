package com.algaworks.algalog.domain.service

import com.algaworks.algalog.domain.repository.DeliveryRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class FinishDeliveryService(
    private val findDeliveryService: FindDeliveryService,
    private val deliveryRepository: DeliveryRepository
) {
    @Transactional
    fun finish(deliveryId: Long) {
        val finishedDelivery = findDeliveryService.findById(deliveryId).finish()
        deliveryRepository.save(finishedDelivery)
    }
}