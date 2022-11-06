package com.algaworks.algalog.api.controller

import com.algaworks.algalog.domain.model.Client
import com.algaworks.algalog.domain.repository.ClientRepository
import com.algaworks.algalog.domain.service.CatalogClientService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RequestMapping("/clients")
@RestController
class ClientController(private val clientRepository: ClientRepository, private val catalogClientService: CatalogClientService) {

    @GetMapping
    fun list(): List<Client> {
        return clientRepository.findAll()
    }

    @GetMapping("/{clientId}")
    fun getClient(@PathVariable clientId: Long): ResponseEntity<Client> {
        return clientRepository.findById(clientId)
            .map { ResponseEntity.ok(it) }
            .orElse(ResponseEntity.notFound().build())
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun add(@Valid @RequestBody client: Client): Client {
        return catalogClientService.save(client)
    }

    @PutMapping("/{clientId}")
    fun update(
        @PathVariable clientId: Long,
        @Valid @RequestBody client: Client
    ): ResponseEntity<Client> {
        if (!clientRepository.existsById(clientId)) {
            return ResponseEntity.notFound().build()
        }
        val updatedClient = client.copy(id = clientId)
        return ResponseEntity.ok(catalogClientService.save(updatedClient))
    }

    @DeleteMapping("/{clientId}")
    fun delete(@PathVariable clientId: Long): ResponseEntity<Unit> {
        if (!clientRepository.existsById(clientId)) {
            return ResponseEntity.notFound().build()
        }
        catalogClientService.delete(clientId)
        return ResponseEntity.noContent().build()
    }
}