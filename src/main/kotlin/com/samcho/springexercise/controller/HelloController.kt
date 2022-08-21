package com.samcho.springexercise.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller // when using a controller, the returned value is used by `viewResolver` to find the screen to respond with
class HelloController {

    @GetMapping("hello")
    fun hello(model: Model) : String {
        model.addAttribute("data", "hello!!")
        return "hello" // name of the template html file the model will be passed to
        // find `resources:templates/{VIEW_NAME}.html
    }
}