package br.com.person.controller

import br.com.person.convert.ConvertNumber
import br.com.person.data.vo.v2.PersonVO as PersonV02
import br.com.person.service.PersonService
import br.com.person.utils.format.MediaType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/person/v2")
class PersonV2Controller {
    @Autowired
    private lateinit var personService: PersonService

    @GetMapping(value = ["/{id}"], produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    fun findOne(@PathVariable("id") id: Long): PersonV02 {
        return personService.findOneV2(id)
    }

    @GetMapping(produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    fun findAll(): List<PersonV02> {
        return personService.findAllV2()
    }

    @PostMapping(produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody personDto: PersonV02): PersonV02 {
        return personService.createV2(personDto)
    }

    @PutMapping(value = ["/{id}"], produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    fun update(
        @RequestBody personDto: PersonV02,
        @PathVariable("id") id: Long,
    ): PersonV02 {
        return personService.updateV2(id, personDto)
    }

    @DeleteMapping(value = ["/{id}"], produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable("id") id: Long) {
        return personService.delete(id)
    }
}