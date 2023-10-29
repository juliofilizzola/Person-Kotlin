package br.com.person.service

import br.com.person.controller.PersonController
import br.com.person.data.vo.v1.PersonVO
import br.com.person.dto.PersonDto
import br.com.person.data.vo.v2.PersonVO as PersonV02
import br.com.person.exceptions.handler.ResourceNotFoundException
import br.com.person.mapper.DozerMapper
import br.com.person.model.Person
import br.com.person.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    private var dozerMapper: DozerMapper = DozerMapper

//    private val counter: AtomicLong = AtomicLong()

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun create(dataPerson: PersonVO): PersonVO {
        val person = Person()

        person.gender = dataPerson.gender
        person.address = dataPerson.address
        person.firstName = dataPerson.firstName
        person.lastName = dataPerson.lastName
        val entity: Person = repository.save(person)
        val personVO: PersonVO = dozerMapper.parseObject(entity, PersonVO::class.java)
        val withSelfRel = linkTo(PersonController::class.java).slash(personVO.id).withSelfRel()
        personVO.add(withSelfRel)
        return personVO
    }

    fun createV2(dataPerson: PersonV02): PersonV02 {
        val person = Person()

        person.gender = dataPerson.gender
        person.address = dataPerson.address
        person.firstName = dataPerson.firstName
        person.lastName = dataPerson.lastName
        person.birthDay = dataPerson.birthDay

        val entity: Person = repository.save(person)
        val personVO: PersonV02 = dozerMapper.parseObject(entity, PersonV02::class.java)
        val withSelfRel = linkTo(PersonController::class.java).slash(personVO.id).withSelfRel()
        personVO.add(withSelfRel)
        return personVO
    }

    fun findOne(id: Long) : PersonVO {
        logger.info("find one person")
        val entity: Person = repository.findById(id).orElseThrow { ResourceNotFoundException("Person Not Found!") }

        val personVO: PersonVO = dozerMapper.parseObject(entity, PersonVO::class.java)
        val withSelfRel = linkTo(PersonController::class.java).slash(personVO.id).withSelfRel()
        personVO.add(withSelfRel)
        return personVO
    }

    fun findOneV2(id: Long) : PersonV02 {
        logger.info("find one person v2")
        val entity: Person = repository.findById(id).orElseThrow { ResourceNotFoundException("Person Not Found!") }
        val personVO: PersonV02 = dozerMapper.parseObject(entity, PersonV02::class.java)
        val withSelfRel = linkTo(PersonController::class.java).slash(personVO.id).withSelfRel()
        personVO.add(withSelfRel)
        return personVO
    }

    fun findAll(): List<PersonVO> {
        logger.info("find all person")
        val entity: List<Person> = repository.findAll()
        val vos = dozerMapper.parseListObjects(entity, PersonVO::class.java)
        for (person in vos) {
            val withSelfRel = linkTo(PersonController::class.java).slash(person.id).withSelfRel()
            person.add(withSelfRel)
        }
        return vos
    }

    fun findAllV2(): List<PersonV02> {
        logger.info("find all person V2")
        val entity: List<Person> = repository.findAll()
        val vos = dozerMapper.parseListObjects(entity, PersonV02::class.java)
        for (person in vos) {
            val withSelfRel = linkTo(PersonController::class.java).slash(person.id).withSelfRel()
            person.add(withSelfRel)
        }
        return vos
    }

    fun update(id: Long, personDto: PersonVO): PersonVO {
        logger.info("Update person")
        val p = repository.findById(id).orElseThrow { ResourceNotFoundException("Person Not Found!") }

        if (personDto.address.isNotEmpty()) {
            p.address = personDto.address
        }

        if (personDto.gender.isNotEmpty()) {
            p.gender = personDto.gender
        }

        if (personDto.firstName.isNotEmpty()) {
            p.firstName = personDto.firstName
        }

        if (personDto.lastName.isNotEmpty()) {
            p.lastName = personDto.lastName
        }

        val entity: Person = repository.save(p)

        val personVO: PersonVO = dozerMapper.parseObject(entity, PersonVO::class.java)

        val withSelfRel = linkTo(PersonController::class.java).slash(personVO.id).withSelfRel()
        personVO.add(withSelfRel)
        return personVO
    }

    fun updateV2(id: Long, personDto: PersonV02): PersonV02 {
        logger.info("Update person v2")
        val p = repository.findById(id).orElseThrow { ResourceNotFoundException("Person Not Found!") }

        if (personDto.address.isNotEmpty()) {
            p.address = personDto.address
        }

        if (personDto.gender.isNotEmpty()) {
            p.gender = personDto.gender
        }

        if (personDto.firstName.isNotEmpty()) {
            p.firstName = personDto.firstName
        }

        if (personDto.lastName.isNotEmpty()) {
            p.lastName = personDto.lastName
        }

        val entity: Person = repository.save(p)
        val personVO: PersonV02 = dozerMapper.parseObject(entity, PersonV02::class.java)
        val withSelfRel = linkTo(PersonController::class.java).slash(personVO.id).withSelfRel()
        personVO.add(withSelfRel)
        return personVO
    }

    fun delete(id: Long) {
        logger.info("delete person")
        val p = repository.findById(id).orElseThrow { ResourceNotFoundException("Person Not Found!") }
        return repository.delete(p)
    }
}