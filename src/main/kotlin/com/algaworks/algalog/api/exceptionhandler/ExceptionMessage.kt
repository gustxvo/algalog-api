package com.algaworks.algalog.api.exceptionhandler

import java.time.LocalDateTime

class ExceptionMessage(
    val status: Int,
    val dateTime: LocalDateTime,
    val title: String,
    val fields: List<Field>
) {
    class Field(
        val name: String,
        val message: String
    )
}
