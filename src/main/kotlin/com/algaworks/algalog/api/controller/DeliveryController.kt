package com.algaworks.algalog.api.controller

import com.algaworks.algalog.api.model.AddresseeModel
import com.algaworks.algalog.api.model.DeliveryModel
import com.algaworks.algalog.domain.model.Delivery
import com.algaworks.algalog.domain.repository.DeliveryRepository
import com.algaworks.algalog.domain.service.DeliveryRequestService
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
    fun list(): List<Delivery> {
        return deliveryRepository.findAll()
    }

    @GetMapping("/{deliveryId}")
    fun getDelivery(@PathVariable deliveryId: Long): ResponseEntity<DeliveryModel> {
        return deliveryRepository.findById(deliveryId)
            .map { delivery ->
                val deliveryModel = DeliveryModel(
                    id = delivery.id,
                    clientName = delivery.client.name ?: "",
                    addressee = AddresseeModel(
                        name = delivery.addressee.name,
                        street = delivery.addressee.street,
                        number = delivery.addressee.number,
                        complement = delivery.addressee.complement,
                        district = delivery.addressee.district
                    ),
                    fee = delivery.fee,
                    deliveryStatus = delivery.status,
                    requestDate = delivery.requestDate,
                    finishDate = delivery.finishDate
                )
                 ResponseEntity.ok(deliveryModel)

            }
            .orElse(ResponseEntity.notFound().build())
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun request(@RequestBody delivery: Delivery): Delivery {
        return deliveryRequestService.request(delivery)
    }
}