package br.com.person.model

import jakarta.persistence.*
import java.util.Date

@Entity
@Table
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "first_name", nullable = false, length = 80)
    var firstName: String=  "",

    @Column(name = "last_name", nullable = false, length = 80)
    var lastName: String = "",

    @Column(nullable = false, length = 100)
    var address: String = "",

    @Column(length = 100)
    var birthDay: Date? = null,

    @Column(nullable = false, length = 1)
    var gender: String = "",
)
