package com.algaworks.algalog.api.model

import java.time.OffsetDateTime

data class OccurrenceModel(
    val id: Long,
    val description: String,
    val registerDate: OffsetDateTime
)
