package com.algaworks.algalog.domain.exception

class EntityNotFoundException(override val message: String) : DomainException(message) {

    companion object {
        private const val serialVersionUID: Long = 1L
    }
}