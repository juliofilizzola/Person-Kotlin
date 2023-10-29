package br.com.person.utils.mock

import br.com.person.data.vo.v1.PersonVO
import br.com.person.model.Person
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

class PersonUtils {
    private val counter: AtomicLong = AtomicLong()
    private val logger = Logger.getLogger(PersonUtils::class.java.name)
    fun mockPerson(i: Int) : Person {
        val person = Person()
        logger.info("Mock person")

        person.id = i.toLong()
        person.address = "address $i"
        person.firstName = "First Name $i"
        person.lastName = "Last Name $i"
        person.gender = if (i % 2 == 0) "M" else "F"

        return person
    }

    fun mockVO(number: Int): PersonVO {
        val person = PersonVO()
        person.address = "address $number"
        person.firstName = "First Name $number"
        person.gender = if (number % 2 == 0) "M" else "F"
        person.lastName = "Last Name $number"
        return person
    }
}