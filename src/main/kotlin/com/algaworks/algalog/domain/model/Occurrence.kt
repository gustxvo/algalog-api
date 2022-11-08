package com.algaworks.algalog.domain.model

import java.time.OffsetDateTime
import javax.persistence.*

@Entity
data class Occurrence(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    val delivery: Delivery,

    val description: String,

    val registerDate: OffsetDateTime
)