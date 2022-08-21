package com.samcho.springexercise.services

import com.samcho.springexercise.domain.Member
import com.samcho.springexercise.repositories.MemberRepository

class MemberService(
    private var memberRepository: MemberRepository
) {

    fun join(member: Member) : Long {
        validateDuplicateMember(member)
        memberRepository.save(member)
        return member.id!!
    }

    private fun validateDuplicateMember(member : Member){
        if(memberRepository.findByName(member.name) != null)
            throw IllegalStateException("Member already joined")
    }

//    @Transactional
//    fun signUp(member : Member) : String {
//        validateDuplicateMember(member)
//        MemberRepo.save(member)
//        return member.id!!
//    }

    fun findMembers() : List<Member> =
        memberRepository.findAll()

    fun findOne(id: Long) : Member? =
        memberRepository.findById(id)
}