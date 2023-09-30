package br.com.person.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import java.util.Date

@ControllerAdvice
@RestController
class CustomizedResponseEntityExceptionHandler {
    @ExceptionHandler(Exception::class)
    fun handlerAllExceptions(ex: Exception, request: WebRequest):
            ResponseEntity<ExceptionsResponse> {
        val exceptionsResponse = ExceptionsResponse(
            Date(),
            ex.message,
            request.getDescription(false)
        )
        return ResponseEntity<ExceptionsResponse>(exceptionsResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(UnsupportedMathOperationException::class)
    fun handlerBadRequestExceptions(ex: Exception, request: WebRequest):
            ResponseEntity<ExceptionsResponse> {
        val exceptionsResponse = ExceptionsResponse(
            Date(),
            ex.message,
            request.getDescription(false)
        )
        return ResponseEntity<ExceptionsResponse>(exceptionsResponse, HttpStatus.BAD_REQUEST)
    }
}