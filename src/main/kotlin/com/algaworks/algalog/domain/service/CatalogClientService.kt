package com.algaworks.algalog.domain.service

import com.algaworks.algalog.domain.exception.DomainException
import com.algaworks.algalog.domain.model.Client
import com.algaworks.algalog.domain.repository.ClientRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CatalogClientService(private val clientRepository: ClientRepository) {

    @Transactional
    fun save(client: Client): Client {
        val isEmailInUse: Boolean = clientRepository.findByEmail(client.email!!)
            .stream().anyMatch { existingClient ->
                existingClient.id != client.id
            }


        if (isEmailInUse) {
            throw DomainException("Email already in use.")
        }
        return clientRepository.save(client)
    }

    @Transactional
    fun delete(clientId: Long) {
        clientRepository.deleteById(clientId)
    }

    fun findById(clientId: Long): Client {
        return clientRepository.findById(clientId)
            .orElseThrow { DomainException("Client not found") }
    }
}