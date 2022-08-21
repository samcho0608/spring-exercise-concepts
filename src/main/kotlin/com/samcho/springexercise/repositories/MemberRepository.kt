package com.samcho.springexercise.repositories

import com.samcho.springexercise.domain.Member

interface MemberRepository {
    fun save(member: Member) : Member
    fun findById(id: Long) : Member?
    fun findByName(name: String) : Member?
    fun findAll() : List<Member>
}