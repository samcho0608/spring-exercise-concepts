package com.samcho.springexercise.repositories

import com.samcho.springexercise.domain.Member
import org.springframework.data.jpa.repository.JpaRepository

interface SpringDataJpaRepository : JpaRepository<Member, Long>, MemberRepository {
    override fun findByName(name: String): Member?
}