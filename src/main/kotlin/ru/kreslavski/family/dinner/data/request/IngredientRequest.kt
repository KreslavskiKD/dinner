package ru.kreslavski.family.dinner.data.request

import jakarta.validation.constraints.NotEmpty

data class IngredientRequest(

    @NotEmpty
    val name: String,
    val description: String,
)
