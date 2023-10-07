package br.com.person.exceptions.handler

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException

@ResponseStatus(HttpStatus.BAD_REQUEST)
class ResourceBadRequestException(exception: String?): RuntimeException(exception)
