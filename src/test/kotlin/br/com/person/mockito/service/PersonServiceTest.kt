package br.com.person.mockito.service

import br.com.person.model.Person
import br.com.person.repository.PersonRepository
import br.com.person.service.PersonService
import br.com.person.unittest.mapper.mock.MockPerson
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class PersonServiceTest {
    private lateinit var inputObj: MockPerson

    @InjectMocks
    private lateinit var service: PersonService

    @Mock
    private lateinit var repo: PersonRepository
    @BeforeEach
    fun setUp() {
        inputObj = MockPerson()
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun create() {
    }

    @Test
    fun createV2() {
    }

    @Test
    fun findOne() {
        val person: Person = inputObj.mockEntity()
        person.id = 1L
        `when`(repo.findById(1)).thenReturn(Optional.of(person))

        val res = service.findOne(1L)
        assertNotNull(res)
        assertNotNull(res.id)
        assertNotNull(res.address)
        assertNotNull(res.gender)
        assertEquals(res.gender, "M")
        assertNotNull(res.address)
    }

    @Test
    fun findOneV2() {
        val person = inputObj.mockEntity()
        person.id = 1L
        `when`(repo.findById(1)).thenReturn(Optional.of(person))

        val res = service.findOneV2(1L)
        assertNotNull(res)
        assertNotNull(res.id)
        assertNotNull(res.address)
        assertNotNull(res.gender)
        assertEquals(res.gender, "M")
        assertNotNull(res.address)
        assertNotNull(res.links)
        assertTrue(res.links.toString().contains("</person/v1/1>"))
    }

    @Test
    fun findAll() {
        val persons = inputObj.mockEntityList(13)

       `when`(repo.findAll()).thenReturn(persons)


        val res = service.findAll()
        assertNotNull(res)

        assertEquals(14, res.size)
        val outputZero = res[0]
        assertNotNull(outputZero)
        assertNotNull(outputZero.id)
        assertNotNull(outputZero.address)
        assertNotNull(outputZero.gender)
        assertEquals(outputZero.gender, "M")
        assertNotNull(outputZero.address)

        val outputSeven = res[7]

        assertNotNull(outputSeven)
        assertNotNull(outputSeven.id)
        assertNotNull(outputSeven.address)
        assertNotNull(outputSeven.gender)
        assertEquals(outputSeven.gender, "F")
        assertNotNull(outputSeven.address)


        val outputNine = res[9]

        assertNotNull(outputNine)
        assertNotNull(outputNine.id)
        assertNotNull(outputNine.address)
        assertNotNull(outputNine.gender)
        assertEquals(outputNine.gender, "F")
        assertNotNull(outputNine.address)

    }

    @Test
    fun update() {
    }

    @Test
    fun updateV2() {
    }

    @Test
    fun delete() {
    }
}