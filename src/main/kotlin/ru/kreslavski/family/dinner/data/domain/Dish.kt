package ru.kreslavski.family.dinner.data.domain

data class Dish(
    val name: String,
    val slug: String,
    val description: String,
    val picture: String, // ?
    val ingredients: List<Ingredient>,
)