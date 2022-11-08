package com.algaworks.algalog.api.model.input

import javax.validation.constraints.NotBlank

class AddresseeInput(
    @field:NotBlank
    val name: String,

    @field:NotBlank
    val street: String,

    @field:NotBlank
    val number: String,

    val complement: String?,

    @field:NotBlank
    val district: String
)
