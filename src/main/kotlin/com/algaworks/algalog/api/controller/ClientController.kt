package com.algaworks.algalog.api.controller

import com.algaworks.algalog.domain.model.Client
import com.algaworks.algalog.domain.repository.ClientRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/clients")
@RestController
class ClientController(val clientRepository: ClientRepository) {

    @GetMapping
    fun getClients(): List<Client> {
        return clientRepository.findAll()
    }

}