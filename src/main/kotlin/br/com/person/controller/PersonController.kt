package br.com.person.controller

import br.com.person.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class PersonController {
    @Autowired
    private lateinit var personService: PersonService

    @RequestMapping(value = ["/person/{id}"])
    fun findOne(@PathVariable("id") id: String) {
//        return personService.findOne()
    }


}