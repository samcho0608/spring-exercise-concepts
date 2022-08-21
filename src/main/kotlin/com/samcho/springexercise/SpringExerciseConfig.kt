package com.samcho.springexercise

import com.samcho.springexercise.repositories.MemberRepository
import com.samcho.springexercise.repositories.MemoryMemberRepository
import com.samcho.springexercise.services.MemberService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringExerciseConfig {

    // Register Bean using configuration if its implementation needs to change in certain circumstances

    @Bean
    fun memberRepository() : MemberRepository = MemoryMemberRepository()

//    @Bean
//    fun memberService() : MemberService = MemberService(memberRepository())

}