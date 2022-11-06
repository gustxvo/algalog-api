package com.algaworks.algalog.api.exceptionhandler

import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
class ExceptionMessage(
    val status: Int,
    val dateTime: LocalDateTime,
    val title: String,
    val fields: List<Field>? = null
) {
    class Field(
        val name: String,
        val message: String
    )
}
