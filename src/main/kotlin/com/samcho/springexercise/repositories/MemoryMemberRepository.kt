package com.samcho.springexercise.repositories

import com.samcho.springexercise.domain.Member
import org.springframework.stereotype.Repository

@Repository
class MemoryMemberRepository : MemberRepository {

    companion object {
        var store : MutableMap<Long, Member> = mutableMapOf()
        var seq : Long = 0L
    }


    override fun save(member: Member): Member =
        member.apply {
            id = ++seq
            store[id!!] = this
        }

    override fun findById(id: Long): Member? = store[id]

    override fun findByName(name: String): Member? {
        val result = store.values.stream().filter { it.name == name }.findAny()
        return if(result.isPresent) result.get() else null
    }

    override fun findAll(): List<Member> = store.values.toList()

    fun clearStore() = store.clear()
}