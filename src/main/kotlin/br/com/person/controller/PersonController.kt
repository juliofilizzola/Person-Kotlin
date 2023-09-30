package br.com.person.controller

import br.com.person.convert.ConvertNumber
import br.com.person.exceptions.UnsupportedMathOperationException
import br.com.person.model.Person
import br.com.person.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/person")
class PersonController {
    @Autowired
    private lateinit var personService: PersonService

    @GetMapping(value = ["/{id}"])
    fun findOne(@PathVariable("id") id: String): Person {
        if (!ConvertNumber.isNumeric(id)) {
            throw UnsupportedMathOperationException("Please set a number")
        }
        return personService.findOne(ConvertNumber.convertToLong(id))
    }

}