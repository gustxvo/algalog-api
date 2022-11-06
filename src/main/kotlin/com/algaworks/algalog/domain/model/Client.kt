package com.algaworks.algalog.domain.model

import com.algaworks.algalog.domain.ValidationGroups
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
data class Client(

    @NotNull(groups = [ValidationGroups.ClientId::class])
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @field:NotBlank
    @Size(max = 60)
    @NotNull
    val name: String?,

    @field:Email
    @field:NotBlank
    @NotNull
    val email: String?,

    @field:NotBlank
    @NotNull
    @field:Size(max = 20)
    val phone: String?
)