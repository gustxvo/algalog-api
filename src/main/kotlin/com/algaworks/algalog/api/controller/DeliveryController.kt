package com.algaworks.algalog.api.controller

import com.algaworks.algalog.api.model.DeliveryModel
import com.algaworks.algalog.api.model.input.DeliveryInput
import com.algaworks.algalog.domain.repository.DeliveryRepository
import com.algaworks.algalog.domain.service.DeliveryRequestService
import com.algaworks.algalog.mapper.toDeliveryModel
import com.algaworks.algalog.mapper.toEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/deliveries")
@RestController
class DeliveryController(
    private val deliveryRequestService: DeliveryRequestService,
    private val deliveryRepository: DeliveryRepository
) {

    @GetMapping
    fun list(): List<DeliveryModel> {
        return deliveryRepository.findAll().map {
            it.toDeliveryModel()
        }
    }

    @GetMapping("/{deliveryId}")
    fun getDelivery(@PathVariable deliveryId: Long): ResponseEntity<DeliveryModel> {
        return deliveryRepository.findById(deliveryId)
            .map {
                 ResponseEntity.ok(it.toDeliveryModel())

            }
            .orElse(ResponseEntity.notFound().build())
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun request(@RequestBody deliveryInput: DeliveryInput): DeliveryModel {
        val delivery = deliveryInput.toEntity()
        return deliveryRequestService.request(delivery).toDeliveryModel()
    }
}