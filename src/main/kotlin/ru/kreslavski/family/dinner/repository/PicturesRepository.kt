package ru.kreslavski.family.dinner.repository

import org.springframework.data.repository.CrudRepository
import ru.kreslavski.family.dinner.data.domain.Picture

interface PicturesRepository: CrudRepository<Picture, Int> {
}