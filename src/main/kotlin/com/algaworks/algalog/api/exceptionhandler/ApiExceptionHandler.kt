package com.algaworks.algalog.api.exceptionhandler

import com.algaworks.algalog.domain.exception.DomainException
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.OffsetDateTime

@ControllerAdvice
class ApiExceptionHandler(private val messageSource: MessageSource) : ResponseEntityExceptionHandler() {

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        val invalidFields = mutableListOf<ExceptionMessage.Field>()
        for (error: ObjectError in ex.bindingResult.allErrors) {
            val name = (error as FieldError).field
            val message = messageSource.getMessage(error, LocaleContextHolder.getLocale())

            invalidFields.add(ExceptionMessage.Field(name, message))
        }

        val exceptionMessage =
            ExceptionMessage(
                status.value(),
                OffsetDateTime.now(),
                "One or more invalid fields. Fill in correctly and try again",
                invalidFields
            )

        return handleExceptionInternal(ex, exceptionMessage, headers, status, request)
    }

    @ExceptionHandler(DomainException::class)
    fun handleDomainException(exception: DomainException, request: WebRequest): ResponseEntity<Any> {

        val status = HttpStatus.BAD_REQUEST
        val exceptionMessage =
            ExceptionMessage(
                status.value(),
                OffsetDateTime.now(),
                exception.message,
            )

        return handleExceptionInternal(exception, exceptionMessage, HttpHeaders(), status, request)
    }
}