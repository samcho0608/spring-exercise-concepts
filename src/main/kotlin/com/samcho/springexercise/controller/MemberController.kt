package com.samcho.springexercise.controller

import com.samcho.springexercise.domain.Member
import com.samcho.springexercise.services.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/members")
class MemberController @Autowired constructor(
    private val memberService: MemberService
) {
    @GetMapping("/new")
    fun createForm() = "members/createMemberForm"


    @PostMapping("/new")
    fun create(form : MemberForm) : String {
        memberService.join(Member().apply { form.getName()?.let { name = it } })

        return "redirect:/"
    }

    @GetMapping("")
    fun list(model: Model) : String {
        model.addAttribute("members", memberService.findMembers())
        return "members/memberList"
    }



}