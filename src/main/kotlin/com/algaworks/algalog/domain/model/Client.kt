package com.algaworks.algalog.domain.model

import javax.persistence.*

@Entity
data class Client(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column
    val name: String,

    val phone: String
)