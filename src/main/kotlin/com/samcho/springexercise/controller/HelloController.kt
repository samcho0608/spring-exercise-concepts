package com.samcho.springexercise.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller // when using a controller, the returned value is used by `viewResolver` to find the screen to respond with
class HelloController {

    @GetMapping("hello")
    fun hello(model: Model) : String {
        model.addAttribute("data", "hello!!")
        return "hello" // name of the template html file the model will be passed to
        // find `resources:templates/{VIEW_NAME}.html
    }

    @GetMapping("hello-mvc")
    fun helloMvc(@RequestParam("name") name: String, model: Model) : String {
        model.addAttribute("name", name)
        return "hello-template"
    }

    @GetMapping("hello-string")
    @ResponseBody // inserts the returned value to the response body
    fun helloString(@RequestParam("name") name: String,) : String {
        return "hello $name"
    }

    companion object {
        class Hello {
            var name: String? = null
        }
    }

    @GetMapping("hello-api")
    @ResponseBody
    fun helloApi(@RequestParam("name") name: String) : Hello {
        return Hello().apply {
            this.name = name
        }
    }
}