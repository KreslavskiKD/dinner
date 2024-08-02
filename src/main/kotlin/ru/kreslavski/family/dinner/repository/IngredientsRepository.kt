package ru.kreslavski.family.dinner.repository

import org.springframework.data.repository.CrudRepository
import ru.kreslavski.family.dinner.data.domain.Ingredient
import java.util.*

interface IngredientsRepository: CrudRepository<Ingredient, Int> {

    fun existsByName(name: String): Boolean

    fun findByName(name: String): Optional<Ingredient>
}
