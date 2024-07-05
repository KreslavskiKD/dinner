package ru.kreslavski.family.dinner

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DinnerApplication

fun main(args: Array<String>) {
	runApplication<DinnerApplication>(*args)
}
