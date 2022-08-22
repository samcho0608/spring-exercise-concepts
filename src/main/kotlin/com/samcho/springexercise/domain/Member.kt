package com.samcho.springexercise.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Member(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY when DB is in charge of generating ID value
    var id: Long? = null,
    var name: String = "",
)