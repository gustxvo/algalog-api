package com.algaworks.algalog.domain.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
data class Client(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @field:NotBlank
    @Size(max = 60)
    val name: String?,

    @field:Email
    @field:NotBlank
    val email: String?,

    @field:NotBlank
    @field:Size(max = 20)
    val phone: String?
)