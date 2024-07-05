package ru.kreslavski.family.dinner.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/users")
class UsersController {

    @GetMapping("/")
    fun getUser(model: Model): String {
        model.addAttribute("title", "Family Dinner")
        return "user"
    }

}