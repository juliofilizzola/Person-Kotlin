package br.com.person.unittest.mapper

import br.com.person.data.vo.v1.PersonVO
import br.com.person.mapper.DozerMapper
import br.com.person.model.Person
import br.com.person.unittest.mapper.mock.MockPerson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DozerMapperTest {
    private var inputObject: MockPerson? = null

    private var dozerMapper: DozerMapper = DozerMapper


    @BeforeEach
    fun setUp() {
        inputObject = MockPerson()
    }

    @Test
    fun parseEntityToVOTest() {
        val output: PersonVO = dozerMapper.parseObject(inputObject!!.mockEntity(), PersonVO::class.java)
        Assertions.assertEquals("First Name 0", output.firstName)
        Assertions.assertEquals("Last Name 0", output.lastName)
        Assertions.assertEquals("address 0", output.address)
        Assertions.assertEquals("M", output.gender)
    }

    @Test
    fun parseEntityListToVOListTest() {
        val outputList: ArrayList<PersonVO> =
            dozerMapper.parseListObjects(inputObject!!.mockEntityList(13), PersonVO::class.java)

        val outputZero: PersonVO = outputList[0]


        Assertions.assertEquals("First Name 0", outputZero.firstName)
        Assertions.assertEquals("Last Name 0", outputZero.lastName)
        Assertions.assertEquals("address 0", outputZero.address)
        Assertions.assertEquals("M", outputZero.gender)

        val outputSeven: PersonVO = outputList[7]
        Assertions.assertEquals("First Name 7", outputSeven.firstName)
        Assertions.assertEquals("Last Name 7", outputSeven.lastName)
        Assertions.assertEquals("address 7", outputSeven.address)
        Assertions.assertEquals("F", outputSeven.gender)

        val outputTwelve: PersonVO = outputList[12]
        Assertions.assertEquals("First Name 12", outputTwelve.firstName)
        Assertions.assertEquals("Last Name 12", outputTwelve.lastName)
        Assertions.assertEquals("address 12", outputTwelve.address)
        Assertions.assertEquals("M", outputTwelve.gender)
    }

    @Test
    fun parseVOToEntityTest() {

        val output: Person = dozerMapper.parseObject(inputObject!!.mockVO(), Person::class.java)

        Assertions.assertEquals(0, output.id)
        Assertions.assertEquals("First Name 0", output.firstName)
        Assertions.assertEquals("Last Name 0", output.lastName)
        Assertions.assertEquals("address 0", output.address)
        Assertions.assertEquals("M", output.gender)
    }

    @Test
    fun parserVOListToEntityListTest() {

        val outputList: ArrayList<Person> =
            dozerMapper.parseListObjects(inputObject!!.mockVOList(13), Person::class.java)


        val outputZero: Person = outputList[0]
        Assertions.assertEquals("First Name 0", outputZero.firstName)
        Assertions.assertEquals("Last Name 0", outputZero.lastName)
        Assertions.assertEquals("address 0", outputZero.address)
        Assertions.assertEquals("M", outputZero.gender)

        val outputSeven: Person = outputList[7]
        Assertions.assertEquals("First Name 7", outputSeven.firstName)
        Assertions.assertEquals("Last Name 7", outputSeven.lastName)
        Assertions.assertEquals("address 7", outputSeven.address)
        Assertions.assertEquals("F", outputSeven.gender)

        val outputTwelve: Person = outputList[12]
        Assertions.assertEquals("First Name 12", outputTwelve.firstName)
        Assertions.assertEquals("Last Name 12", outputTwelve.lastName)
        Assertions.assertEquals("address 12", outputTwelve.address)
        Assertions.assertEquals("M", outputTwelve.gender)
    }
}