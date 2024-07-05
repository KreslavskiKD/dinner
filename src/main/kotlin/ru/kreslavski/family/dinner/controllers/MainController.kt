package ru.kreslavski.family.dinner.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController {

    @GetMapping("/")
    fun home(model: Model): String {
        model.addAttribute("title", "Family Dinner")
        return "home"
    }
}