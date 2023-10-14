package br.com.person.data.vo.v1

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import org.springframework.hateoas.RepresentationModel

@JsonPropertyOrder("firstName", "lastName", "gender", "address")
data class PersonVO(

    var id: Long = 0,

    @field:JsonProperty("first-name")
    var firstName: String=  "",

    @field:JsonProperty("last-name")
    var lastName: String = "",

    var address: String = "",
    var gender: String = "",
): RepresentationModel<PersonVO>()
