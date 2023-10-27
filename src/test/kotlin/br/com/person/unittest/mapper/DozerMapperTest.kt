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
        Assertions.assertEquals("Julio 0", output.firstName)
        Assertions.assertEquals("Filizzola 0", output.lastName)
        Assertions.assertEquals("Belo Horizonte - Minas Gerais - Brasil 0", output.address)
        Assertions.assertEquals("M", output.gender)
    }

    @Test
    fun parseEntityListToVOListTest() {
        val outputList: ArrayList<PersonVO> =
            dozerMapper.parseListObjects(inputObject!!.mockEntityList(), PersonVO::class.java)

        val outputZero: PersonVO = outputList[0]


        Assertions.assertEquals("Julio 0", outputZero.firstName)
        Assertions.assertEquals("Filizzola 0", outputZero.lastName)
        Assertions.assertEquals("Belo Horizonte - Minas Gerais - Brasil 0", outputZero.address)
        Assertions.assertEquals("M", outputZero.gender)

        val outputSeven: PersonVO = outputList[7]
        Assertions.assertEquals("Julio 7", outputSeven.firstName)
        Assertions.assertEquals("Filizzola 7", outputSeven.lastName)
        Assertions.assertEquals("Belo Horizonte - Minas Gerais - Brasil 7", outputSeven.address)
        Assertions.assertEquals("F", outputSeven.gender)

        val outputTwelve: PersonVO = outputList[12]
        Assertions.assertEquals("Julio 12", outputTwelve.firstName)
        Assertions.assertEquals("Filizzola 12", outputTwelve.lastName)
        Assertions.assertEquals("Belo Horizonte - Minas Gerais - Brasil 12", outputTwelve.address)
        Assertions.assertEquals("M", outputTwelve.gender)
    }

    @Test
    fun parseVOToEntityTest() {

        val output: Person = dozerMapper.parseObject(inputObject!!.mockVO(), Person::class.java)

        Assertions.assertEquals(0, output.id)
        Assertions.assertEquals("Julio 0", output.firstName)
        Assertions.assertEquals("Filizzola 0", output.lastName)
        Assertions.assertEquals("Belo Horizonte - Minas Gerais - Brasil 0", output.address)
        Assertions.assertEquals("M", output.gender)
    }

    @Test
    fun parserVOListToEntityListTest() {

        val outputList: ArrayList<Person> =
            dozerMapper.parseListObjects(inputObject!!.mockVOList(13), Person::class.java)


        val outputZero: Person = outputList[0]
        Assertions.assertEquals("Julio 0", outputZero.firstName)
        Assertions.assertEquals("Filizzola 0", outputZero.lastName)
        Assertions.assertEquals("Belo Horizonte - Minas Gerais - Brasil 0", outputZero.address)
        Assertions.assertEquals("M", outputZero.gender)

        val outputSeven: Person = outputList[7]
        Assertions.assertEquals("Julio 7", outputSeven.firstName)
        Assertions.assertEquals("Filizzola 7", outputSeven.lastName)
        Assertions.assertEquals("Belo Horizonte - Minas Gerais - Brasil 7", outputSeven.address)
        Assertions.assertEquals("F", outputSeven.gender)

        val outputTwelve: Person = outputList[12]
        Assertions.assertEquals("Julio 12", outputTwelve.firstName)
        Assertions.assertEquals("Filizzola 12", outputTwelve.lastName)
        Assertions.assertEquals("Belo Horizonte - Minas Gerais - Brasil 12", outputTwelve.address)
        Assertions.assertEquals("M", outputTwelve.gender)
    }
}