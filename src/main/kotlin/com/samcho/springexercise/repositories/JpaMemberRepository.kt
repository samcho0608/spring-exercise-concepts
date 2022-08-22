package com.samcho.springexercise.repositories

import com.samcho.springexercise.domain.Member
import javax.persistence.EntityManager

class JpaMemberRepository(
    private var em : EntityManager
) : MemberRepository {

    override fun save(member: Member): Member {
        em.persist(member)
        return member
    }

    override fun findById(id: Long): Member? {
        return em.find(Member::class.java, id)
    }

    override fun findByName(name: String): Member? {
        val result = em.createQuery("select m from Member m where m.name = :name", Member::class.java)
            .setParameter("name", name)
            .resultList
        result.stream().findAny().run {
            if (isPresent) return get()
            else return null
        }
    }

    override fun findAll(): List<Member> {
        return em.createQuery("select m from Member m", Member::class.java).resultList
    }
}