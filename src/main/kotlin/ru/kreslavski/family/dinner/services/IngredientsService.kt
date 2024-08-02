package ru.kreslavski.family.dinner.services

import org.springframework.stereotype.Service
import ru.kreslavski.family.dinner.data.domain.Ingredient
import ru.kreslavski.family.dinner.repository.IngredientsRepository

@Service
class IngredientsService(
    private val ingredientsRepository: IngredientsRepository
) {

    fun get(id: Int): Ingredient? {
        return ingredientsRepository.findById(id).orElse(null)
    }

    fun save(name: String, description: String, photoId: Int?): Ingredient {
        val ingredient = Ingredient(
            name = name,
            description = description,
            photoId = photoId,
        )

        return ingredientsRepository.save(ingredient)
    }

    fun remove(id: Int) {
        ingredientsRepository.deleteById(id)
    }

    fun getAll() : MutableIterable<Ingredient> {
        return ingredientsRepository.findAll()
    }

    fun containsByName(name: String): Boolean {
        return ingredientsRepository.existsByName(name)
    }
}
