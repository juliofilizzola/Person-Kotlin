package br.com.person.controller

import br.com.person.convert.ConvertNumber
import br.com.person.data.vo.v2.PersonVO as PersonV02
import br.com.person.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/person/v2")
class PersonV2Controller {
    @Autowired
    private lateinit var personService: PersonService

    @GetMapping(value = ["/{id}"])
    fun findOne(@PathVariable("id") id: String): PersonV02 {
        if (!ConvertNumber.isNumeric(id)) {
            throw UnsupportedOperationException("Please set a number")
        }
        return personService.findOneV2(ConvertNumber.convertToLong(id))
    }

    @GetMapping
    fun findAll(): List<PersonV02> {
        return personService.findAllV2()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody personDto: PersonV02): PersonV02 {
        return personService.createV2(personDto)
    }

    @PostMapping("/v2")
    @ResponseStatus(HttpStatus.CREATED)
    fun createV2(@RequestBody personDto: PersonV02): PersonV02 {
        return personService.createV2(personDto)
    }

    @PutMapping(value = ["/{id}"])
    fun update(
        @RequestBody personDto: PersonV02,
        @PathVariable("id") id: Long,
    ): PersonV02 {
        return personService.updateV2(id, personDto)
    }

    @DeleteMapping(value = ["/{id}"])
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable("id") id: Long) {
        return personService.delete(id)
    }
}