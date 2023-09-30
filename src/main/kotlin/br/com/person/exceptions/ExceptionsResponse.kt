package br.com.person.exceptions

import java.util.Date

class ExceptionsResponse (
    val timestamp: Date,
    val message: String?,
    val details: String
)