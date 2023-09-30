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
        return mockPerson(1)
    }

    fun  findAll(): List<Person> {
        logger.info("find all person")
        val persons: MutableList<Person> = ArrayList<Person>()

        for(i in 0 .. 7) {
            val p = mockPerson(i)
            persons.add(p)
        }

        return persons
    }

    private fun mockPerson(i: Int) : Person {
        val person = Person()

        person.id = counter.incrementAndGet()
        person.address = "Belo Horizonte - Minas Gerais - Brasil"
        person.firstName = "Julio $i"
        person.lastName = "Filizzola $i"
        person.gender = "M $i"

        return person
    }
}