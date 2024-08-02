package ru.kreslavski.family.dinner.web.api

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.kreslavski.family.dinner.web.Constants

@RestController
@RequestMapping("/api/${Constants.API_VERSION}/users")
class UsersController {

}