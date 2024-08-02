package ru.kreslavski.family.dinner.data.domain

sealed class Currency(
    val emote: String,
) {

    class Kisses: Currency("😘")
    class Hugs: Currency("🤗")
}
