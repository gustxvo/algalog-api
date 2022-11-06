package com.algaworks.algalog.api.controller

import com.algaworks.algalog.domain.model.Delivery
import com.algaworks.algalog.domain.repository.DeliveryRepository
import com.algaworks.algalog.domain.service.DeliveryRequestService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("/deliveries")
@RestController
class DeliveryController(private val deliveryRequestService: DeliveryRequestService, private val deliveryRepository: DeliveryRepository) {

    @GetMapping
    fun list(): List<Delivery> {
        return deliveryRepository.findAll()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun request(@RequestBody delivery: Delivery): Delivery {
        return deliveryRequestService.request(delivery)
    }
}