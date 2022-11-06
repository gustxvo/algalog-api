package com.algaworks.algalog.domain.model

import javax.persistence.Column
import javax.persistence.Embeddable
import javax.validation.constraints.Size

@Embeddable
data class Addressee(
    @Column(name = "addressee_name")
    @Size(max = 60)
    val name: String,

    @Column(name = "addressee_street")
    val street: String,

    @Column(name = "addressee_number")
    @Size(max = 30)
    val number: String,

    @Column(name = "addressee_complement")
    @Size(max = 60)
    val complement: String?,

    @Column(name = "addressee_district")
    @Size(max = 30)
    val district: String
)
