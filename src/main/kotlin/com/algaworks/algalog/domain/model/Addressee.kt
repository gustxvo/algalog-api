package com.algaworks.algalog.domain.model

import com.fasterxml.jackson.annotation.JsonInclude
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@JsonInclude(JsonInclude.Include.NON_NULL)
@Embeddable
data class Addressee(
    @NotBlank
    @Column(name = "addressee_name")
    @Size(max = 60)
    val name: String,

    @NotBlank
    @Column(name = "addressee_street")
    val street: String,

    @NotBlank
    @Column(name = "addressee_number")
    @Size(max = 30)
    val number: String,

    @Column(name = "addressee_complement")
    @Size(max = 60)
    val complement: String?,

    @NotBlank
    @Column(name = "addressee_district")
    @Size(max = 30)
    val district: String
)
