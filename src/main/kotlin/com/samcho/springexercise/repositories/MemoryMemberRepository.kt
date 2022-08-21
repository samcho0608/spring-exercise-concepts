package com.samcho.springexercise.repositories

import com.samcho.springexercise.domain.Member
import kotlin.jvm.optionals.getOrNull

class MemoryMemberRepository : MemberRepository {

    companion object {
        var store : MutableMap<Long, Member> = mutableMapOf()
        var seq : Long = 0L
    }


    override fun save(member: Member): Member =
        member.apply {
            id = ++seq
            store[id] = this
        }

    override fun findById(id: Long): Member? = store[id]

    override fun findByName(name: String): Member? =
        store.values.stream().filter { it.name == name }.findAny().orElseGet(null)

    override fun findAll(): List<Member> = store.values.toList()
}