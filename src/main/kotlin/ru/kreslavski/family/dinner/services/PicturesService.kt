package ru.kreslavski.family.dinner.services

import org.springframework.stereotype.Service
import ru.kreslavski.family.dinner.data.domain.Picture
import ru.kreslavski.family.dinner.repository.PicturesRepository
import java.util.*

@Service
class PicturesService(
    private val picturesRepository: PicturesRepository,
) {

    fun get(id: Int): Picture? {
        return picturesRepository.findById(id).orElse(null)
    }

    fun remove(id: Int) {
        return picturesRepository.deleteById(id)
    }

    fun save(filename: String, contentType: String, data: ByteArray): Picture {
        val picture = Picture(
            data = data,
            fileName = filename,
            contentType = contentType,
        )
        return picturesRepository.save(picture)
    }

}