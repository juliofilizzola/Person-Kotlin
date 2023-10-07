package br.com.person.service

import br.com.person.dto.PersonDto
import br.com.person.exceptions.handler.ResourceNotFoundException
import br.com.person.model.Person
import br.com.person.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

//    private val counter: AtomicLong = AtomicLong()

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun create(dataPerson: PersonDto): Person {
        val person = Person()

        person.address = dataPerson.address
        person.gender = dataPerson.gender
        person.firstName = dataPerson.firstName
        person.lastName = dataPerson.lastName
        return repository.save(person)
    }

    fun findOne(id: Long) : Person {
        logger.info("find one person")
        return repository.findById(id).orElseThrow { ResourceNotFoundException("Person Not Found!") }
    }

    fun findAll(): List<Person> {
        logger.info("find all person")
        return repository.findAll()
    }

    fun update(id: Long, personDto: PersonDto): Person {
        logger.info("Update person")
        val p = repository.findById(id).orElseThrow { ResourceNotFoundException("Person Not Found!") }

        p.address = personDto.address
        p.gender = personDto.gender
        p.firstName = personDto.firstName
        p.lastName = personDto.lastName

        return repository.save(p)
    }

    fun delete(id: Long) {
        logger.info("delete person")
        val p = repository.findById(id).orElseThrow { ResourceNotFoundException("Person Not Found!") }
        return repository.delete(p)
    }
}