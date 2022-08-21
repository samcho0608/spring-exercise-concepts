package com.samcho.springexercise.repositories

import com.samcho.springexercise.domain.Member
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MemoryMemberRepositoryTest {
    var repo : MemoryMemberRepository = MemoryMemberRepository()

    @AfterEach
    fun afterEach() {
        repo.clearStore()
    }

    @Test
    fun save() {
        var member = Member().apply {
            name = "sam"
        }
        repo.save(member)
        var result = repo.findById(member.id!!)
        assertEquals(member, result)
    }

    @Test
    fun findByName() {
        var member = Member().apply {
            name = "sam"
        }
        repo.save(member)
        var result = repo.findByName("sam")
        assertEquals(member, result)
    }

    @Test
    fun findAll() {
        var member1 = Member().apply {
            name = "sam1"
        }
        var member2 = Member().apply {
            name = "sam2"
        }
        repo.save(member1)
        repo.save(member2)

        val result : List<Member> = repo.findAll()
        assertEquals(result.size, 2)

    }

}