package ru.kreslavski.family.dinner.web.api

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.server.ResponseStatusException
import ru.kreslavski.family.dinner.web.Constants
import ru.kreslavski.family.dinner.data.domain.Ingredient
import ru.kreslavski.family.dinner.services.IngredientsService
import ru.kreslavski.family.dinner.services.PicturesService
import ru.kreslavski.family.dinner.utils.Generators.getRandomString

@RestController
@RequestMapping("/api/${Constants.API_VERSION}/ingredients")
class IngredientsController(
    private val ingredientsService: IngredientsService,
    private val picturesService: PicturesService,
) {

    @GetMapping("/")
    fun allIngredients() : MutableIterable<Ingredient> {
        return ingredientsService.getAll()
    }

    @GetMapping("/{id}")
    fun getIngredient(
        @PathVariable
        id: Int
    ) : Ingredient {
        return ingredientsService.get(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    @DeleteMapping("/{id}")
    fun deleteIngredient(
        @PathVariable
        id: Int
    ) {
        ingredientsService.remove(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    @PostMapping("/")
    fun postIngredient(
        @RequestParam(value = "name")
        name: String,
        @RequestParam(value = "description")
        description: String,
        @RequestPart(value = "data")
        picture: MultipartFile,
    ): Ingredient {
        if (!ingredientsService.containsByName(name)) {

            val pictureDb = picturesService.save(
                data = picture.bytes,
                filename = picture.originalFilename ?: getRandomString(10),
                contentType = picture.contentType ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST),
            )

            return ingredientsService.save(
                name = name,
                description = description,
                photoId = pictureDb.id,
            )
        } else {
            throw ResponseStatusException(HttpStatus.CONFLICT)
        }
    }
}