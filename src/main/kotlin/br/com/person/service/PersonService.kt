package br.com.person.service

import br.com.person.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {
    private val counter: AtomicLong = AtomicLong()

    private val logger = Logger.getLogger(PersonService::class.java.name)
    fun findOne(id: Long) : Person {
        logger.info("find one person")
        val person = Person()

        person.id = counter.incrementAndGet()
        person.address = "Belo Horizonte - Minas Gerais - Brasil"
        person.firstName = "Julio"
        person.lastName = "Filizzola"
        person.gender = "M"

        return person
    }
}