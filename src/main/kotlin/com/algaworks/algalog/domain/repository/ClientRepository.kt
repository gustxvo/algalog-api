package com.algaworks.algalog.domain.repository

import com.algaworks.algalog.domain.model.Client
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository : JpaRepository<Client, Long> {
}