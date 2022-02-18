package br.com.fmarxds.fiapcervejawebflux.controller

import br.com.fmarxds.fiapcervejawebflux.dto.CervejaCreateDTO
import br.com.fmarxds.fiapcervejawebflux.dto.CervejaDTO
import br.com.fmarxds.fiapcervejawebflux.service.CervejaService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/cervejas")
class CervejaController(

    private val cervejaService: CervejaService,

) {

    @GetMapping(produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    fun findAll(): ResponseEntity<Flux<CervejaDTO>> {
        return ResponseEntity.ok(cervejaService.findAll())
    }

    @PostMapping
    fun create(@RequestBody cervejaCreateDTO: CervejaCreateDTO): ResponseEntity<Mono<CervejaDTO>> {
        return ResponseEntity(cervejaService.create(cervejaCreateDTO), HttpStatus.CREATED)
    }

}