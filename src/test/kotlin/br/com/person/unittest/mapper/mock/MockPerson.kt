package br.com.person.unittest.mapper.mock

import br.com.person.model.Person
import br.com.person.utils.mock.PersonUtils

class MockPerson {
    private val personUtils: PersonUtils = PersonUtils()
    fun mockEntity(): Person {
        return personUtils.mockPerson(0)
    }
}