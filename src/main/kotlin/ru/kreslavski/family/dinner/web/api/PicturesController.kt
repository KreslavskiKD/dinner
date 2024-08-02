package ru.kreslavski.family.dinner.web.api

import org.springframework.http.*
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.server.ResponseStatusException
import ru.kreslavski.family.dinner.web.Constants
import ru.kreslavski.family.dinner.data.domain.Picture
import ru.kreslavski.family.dinner.services.PicturesService
import ru.kreslavski.family.dinner.utils.Generators

@RestController
@RequestMapping("/api/${Constants.API_VERSION}/pictures")
class PicturesController(
    private val picturesService: PicturesService,
) {

    @PostMapping("/")
    fun postPicture(
        @RequestPart(value = "data")
        picture: MultipartFile,
    ): Picture {

        return picturesService.save(
            data = picture.bytes,
            filename = picture.originalFilename ?: Generators.getRandomString(10),
            contentType = picture.contentType ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST)
        )
    }

    @GetMapping("/{id}")
    fun download(@PathVariable id: Int): ResponseEntity<ByteArray> {
        val picture: Picture = picturesService.get(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
        val headers = HttpHeaders()
        headers.contentType = MediaType.valueOf(picture.contentType)
        val build = ContentDisposition
            .builder("attachment")
            .filename(picture.fileName)
            .build()
        headers.contentDisposition = build

        return ResponseEntity(picture.data, headers, HttpStatus.OK)
    }
}