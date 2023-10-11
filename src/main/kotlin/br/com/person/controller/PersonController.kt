package br.com.person.controller

import br.com.person.convert.ConvertNumber
import br.com.person.data.vo.v1.PersonVO
import br.com.person.data.vo.v2.PersonVO as PersonV02
import br.com.person.dto.PersonDto
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
    fun findOne(@PathVariable("id") id: String): PersonVO {
        if (!ConvertNumber.isNumeric(id)) {
            throw UnsupportedOperationException("Please set a number")
        }
        return personService.findOne(ConvertNumber.convertToLong(id))
    }

    @GetMapping
    fun findAll(): List<PersonVO> {
        return personService.findAll()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody personDto: PersonDto): PersonVO {
        return personService.create(personDto)
    }

    @PostMapping("/v2")
    @ResponseStatus(HttpStatus.CREATED)
    fun createV2(@RequestBody personDto: PersonV02): PersonV02 {
        return personService.createV2(personDto)
    }


    @PutMapping(value = ["/{id}"])
    fun update(
        @RequestBody personDto: PersonDto,
        @PathVariable("id") id: Long,
    ): PersonVO {
        return personService.update(id, personDto)
    }

    @DeleteMapping(value = ["/{id}"])
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable("id") id: Long) {
        return personService.delete(id)
    }
}