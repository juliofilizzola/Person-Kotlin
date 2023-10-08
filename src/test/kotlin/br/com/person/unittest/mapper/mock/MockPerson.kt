package br.com.person.unittest.mapper.mock

import br.com.person.data.vo.v1.PersonVO
import br.com.person.model.Person
import br.com.person.utils.mock.PersonUtils
import java.util.ArrayList

class MockPerson {
    private val personUtils: PersonUtils = PersonUtils()
    fun mockEntity(): Person {
        return personUtils.mockPerson(0)
    }

   fun mockVO(): PersonVO {
        return personUtils.mockVO(0)
    }

    fun mockEntityList(): ArrayList<Person> {
        val persons: ArrayList<Person> = ArrayList<Person>()
        for (i in 0..13) {
            persons.add(personUtils.mockPerson(i))
        }
        return persons
    }

    fun mockVOList(): ArrayList<PersonVO> {
        val persons: ArrayList<PersonVO> = ArrayList()
        for (i in 0..13) {
            persons.add(personUtils.mockVO(i))
        }
        return persons
    }

}