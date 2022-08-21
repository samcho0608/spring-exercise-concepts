package com.samcho.springexercise.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

    // if "/" path is specified in a Get method of a Controller, it is prioritized before index.html(index.html is ignored)
    @GetMapping("/")
    fun home() = "home"
}