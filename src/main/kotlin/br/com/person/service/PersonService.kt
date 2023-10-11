package br.com.person.service

import br.com.person.convert.ConvertDate
import br.com.person.data.vo.v1.PersonVO
import br.com.person.dto.PersonDto
import br.com.person.data.vo.v2.PersonVO as PersonV02
import br.com.person.exceptions.handler.ResourceNotFoundException
import br.com.person.mapper.DozerMapper
import br.com.person.model.Person
import br.com.person.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    private var dozerMapper: DozerMapper = DozerMapper
    private var convertDate: ConvertDate = ConvertDate()

//    private val counter: AtomicLong = AtomicLong()

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun create(dataPerson: PersonDto): PersonVO {
        val person = Person()

        person.gender = dataPerson.gender
        person.address = dataPerson.address
        person.firstName = dataPerson.firstName
        person.lastName = dataPerson.lastName
        val entity: Person = repository.save(person)
        return dozerMapper.parseObject(entity, PersonVO::class.java)
    }

    fun createV2(dataPerson: PersonV02): PersonV02 {
        val person = Person()

        person.gender = dataPerson.gender
        person.address = dataPerson.address
        person.firstName = dataPerson.firstName
        person.lastName = dataPerson.lastName
        person.birthDay = convertDate.stringToDate(dataPerson.birthDay)
        val entity: Person = repository.save(person)
        return dozerMapper.parseObject(entity, PersonV02::class.java)
    }

    fun findOne(id: Long) : PersonVO {
        logger.info("find one person")
        val entity: Person = repository.findById(id).orElseThrow { ResourceNotFoundException("Person Not Found!") }
        return dozerMapper.parseObject(entity, PersonVO::class.java)
    }

    fun findAll(): List<PersonVO> {
        logger.info("find all person")
        val entity: List<Person> = repository.findAll()
        return dozerMapper.parseListObjects(entity, PersonVO::class.java)
    }

    fun update(id: Long, personDto: PersonDto): PersonVO {
        logger.info("Update person")
        val p = repository.findById(id).orElseThrow { ResourceNotFoundException("Person Not Found!") }

        p.address = personDto.address
        p.gender = personDto.gender
        p.firstName = personDto.firstName
        p.lastName = personDto.lastName
        val entity: Person = repository.save(p)
        return dozerMapper.parseObject(entity, PersonVO::class.java)
    }

    fun delete(id: Long) {
        logger.info("delete person")
        val p = repository.findById(id).orElseThrow { ResourceNotFoundException("Person Not Found!") }
        return repository.delete(p)
    }
}