package br.com.person.controller

import br.com.person.data.vo.v1.PersonVO
import br.com.person.dto.PersonDto
import br.com.person.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import br.com.person.utils.format.MediaType

@RestController
@RequestMapping("/person/v1")
class PersonController {
    @Autowired
    private lateinit var personService: PersonService

    @GetMapping(value = ["/{id}"], produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    fun findOne(@PathVariable("id") id: Long): PersonVO {
        return personService.findOne(id)
    }

    @GetMapping(produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    fun findAll(): List<PersonVO> {
        return personService.findAll()
    }

    @PostMapping(produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody personDto: PersonDto): PersonVO {
        return personService.create(personDto)
    }

    @PutMapping(value = ["/{id}"], produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    fun update(
        @RequestBody personDto: PersonDto,
        @PathVariable("id") id: Long,
    ): PersonVO {
        return personService.update(id, personDto)
    }

    @DeleteMapping(value = ["/{id}"], produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable("id") id: Long) {
        return personService.delete(id)
    }
}