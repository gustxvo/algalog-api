package com.algaworks.algalog.mapper

import com.algaworks.algalog.api.model.OccurrenceModel
import com.algaworks.algalog.domain.model.Occurrence

fun Occurrence.toModel(): OccurrenceModel {
    return OccurrenceModel(
        id = id!!,
        description = description,
        registerDate = registerDate
    )
}