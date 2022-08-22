package com.samcho.springexercise

import com.samcho.springexercise.aop.TimeTraceAop
import com.samcho.springexercise.repositories.JpaMemberRepository
import com.samcho.springexercise.repositories.MemberRepository
import com.samcho.springexercise.repositories.MemoryMemberRepository
import com.samcho.springexercise.services.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManager
import javax.sql.DataSource

@Configuration
class SpringExerciseConfig @Autowired constructor(
    private val memberRepository: MemberRepository,
){

    @Bean
    fun timeTraceAop() : TimeTraceAop = TimeTraceAop()
    // usually AOPs are DIed in config because they are not standardized



    // Register Bean using configuration if its implementation needs to change in certain circumstances

//    @Bean
//    fun memberRepository() : MemberRepository =
//        JpaMemberRepository(em)
//        MemoryMemberRepository()

//    @Bean
//    fun memberService() : MemberService = MemberService(memberRepository())

}