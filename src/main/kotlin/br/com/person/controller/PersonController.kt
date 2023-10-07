package br.com.person.controller

import br.com.person.convert.ConvertNumber
import br.com.person.dto.PersonDto
import br.com.person.model.Person
import br.com.person.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/person")
class PersonController {
    @Autowired
    private lateinit var personService: PersonService

    @GetMapping(value = ["/{id}"])
    fun findOne(@PathVariable("id") id: String): Person {
        if (!ConvertNumber.isNumeric(id)) {
            throw UnsupportedOperationException("Please set a number")
        }
        return personService.findOne(ConvertNumber.convertToLong(id))
    }

    @GetMapping
    fun findAll(): List<Person> {
        return personService.findAll()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody personDto: PersonDto): Person {
        return personService.create(personDto)
    }

    @PutMapping(value = ["/{id}"])
    fun update(
        @RequestBody personDto: PersonDto,
        @PathVariable("id") id: Long,
    ): Person {
        return personService.update(id, personDto)
    }

    @DeleteMapping(value = ["/{id}"])
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable("id") id: Long) {
        return personService.delete(id)
    }
}