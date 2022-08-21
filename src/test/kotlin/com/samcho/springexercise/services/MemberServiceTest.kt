package com.samcho.springexercise.services

import com.samcho.springexercise.domain.Member
import com.samcho.springexercise.repositories.MemberRepository
import com.samcho.springexercise.repositories.MemoryMemberRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

internal class MemberServiceTest {

    lateinit var memberService : MemberService
    lateinit var memberRepository: MemoryMemberRepository

    @BeforeEach
    fun beforeEach() {
        memberRepository = MemoryMemberRepository()
        memberService = MemberService(memberRepository)
    }

    @AfterEach
    fun afterEach() {
        memberRepository.clearStore()
    }

    @Test
    fun join() {
        // given
        var member : Member = Member().apply {
            name = "hello"
        }

        // when
        val savedId = memberService.join(member)

        // then
        val foundMember = memberService.findOne(savedId)
        assertEquals(member.name, foundMember?.name)

    }

    @Test
    fun duplicateNamedMemberException() {
        // given
        var member1 : Member = Member().apply {
            name = "hello"
        }

        // given
        var member2 : Member = Member().apply {
            name = "hello"
        }
        // when

        memberService.run {
            join(member1)
            val e = assertThrows(IllegalStateException::class.java) { join(member2) }

            // then
            assertEquals(e.message, "Member already joined")
        }
    }

    @Test
    fun findMembers() {
    }

    @Test
    fun findOne() {
    }
}