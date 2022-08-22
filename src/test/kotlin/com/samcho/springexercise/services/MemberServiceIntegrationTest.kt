package com.samcho.springexercise.services

import com.samcho.springexercise.domain.Member
import com.samcho.springexercise.repositories.MemberRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Commit
import javax.transaction.Transactional

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest @Autowired constructor(
    private val memberService: MemberService,
    private val memberRepository: MemberRepository,
){
    @Test
//    @Commit // to commit the query execution in DB
    fun join() {
        // given
        val member = Member().apply {
            name = "sam"
        }

        // when
        val savedId = memberService.join(member)

        // then
        val foundMember = memberRepository.findById(savedId)
        assertEquals(foundMember?.name, member.name)
    }

    @Test
    fun duplicateMemberException() {
        // given
        val member1 = Member().apply {
            name = "sam"
        }

        val member2 = Member().apply {
            name = "sam"
        }

        // when
        memberService.join(member1)
        val e = assertThrows(IllegalStateException::class.java) { memberService.join(member2) }
        assertEquals(e.message, "Member already joined")

        // then
    }
}