package br.com.person.data.vo.v2

import br.com.person.data.vo.v1.PersonVO
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.hateoas.RepresentationModel
import java.util.Date

data class PersonVO(
    var key: Long = 0,
    @field:JsonProperty("first-name")
    var firstName: String=  "",

    @field:JsonProperty("last-name")
    var lastName: String = "",
    var address: String = "",
    var gender: String = "",
    var birthDay: Date? = null
): RepresentationModel<PersonVO>()
