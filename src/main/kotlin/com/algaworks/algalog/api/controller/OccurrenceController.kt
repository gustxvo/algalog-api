package com.algaworks.algalog.api.controller

import com.algaworks.algalog.api.model.OccurrenceModel
import com.algaworks.algalog.api.model.input.OccurrenceInput
import com.algaworks.algalog.domain.service.FindDeliveryService
import com.algaworks.algalog.domain.service.RegisterOccurrenceService
import com.algaworks.algalog.mapper.toModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/deliveries/{deliveryId}/occurrences")
class OccurrenceController(
    private val registerOccurrenceService: RegisterOccurrenceService,
    private val findDeliveryService: FindDeliveryService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun register(
        @PathVariable deliveryId: Long,
        @Valid @RequestBody occurrenceInput: OccurrenceInput
    ): OccurrenceModel {
        val registeredOccurrence =
        registerOccurrenceService.register(deliveryId, occurrenceInput.description)
        return registeredOccurrence.toModel()
    }

    @GetMapping
    fun list(@PathVariable deliveryId: Long): List<OccurrenceModel> {
        val delivery = findDeliveryService.findById(deliveryId)

        return delivery.occurrences.map { it.toModel() }
    }
}
