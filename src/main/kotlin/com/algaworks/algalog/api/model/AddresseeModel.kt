package com.algaworks.algalog.api.model

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
class AddresseeModel(
    val name: String,
    val street: String,
    val number: String,
    val complement: String?,
    val district: String
)
