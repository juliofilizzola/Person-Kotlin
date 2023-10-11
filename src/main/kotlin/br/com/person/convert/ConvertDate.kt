package br.com.person.convert

import java.time.Instant
import java.util.Date

class ConvertDate {
    fun stringToDate(date: String): Date {
        return Date.from(Instant.parse(date))
    }
}