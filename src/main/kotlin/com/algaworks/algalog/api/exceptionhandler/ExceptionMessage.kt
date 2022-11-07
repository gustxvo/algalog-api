package com.algaworks.algalog.api.exceptionhandler

import com.fasterxml.jackson.annotation.JsonInclude
import java.time.OffsetDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
class ExceptionMessage(
    val status: Int,
    val dateTime: OffsetDateTime,
    val title: String,
    val fields: List<Field>? = null
) {
    class Field(
        val name: String,
        val message: String
    )
}
