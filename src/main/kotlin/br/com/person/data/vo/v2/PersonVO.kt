package br.com.person.data.vo.v2

import java.util.Date

data class PersonVO(
    var firstName: String = "",
    var lastName: String = "",
    var address: String = "",
    var gender: String = "",
    var birthDay: Date? = null
)
