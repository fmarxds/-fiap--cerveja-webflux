package br.com.fmarxds.fiapcervejawebflux.service

import br.com.fmarxds.fiapcervejawebflux.dto.CervejaCreateDTO
import br.com.fmarxds.fiapcervejawebflux.dto.CervejaDTO
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface CervejaService {

    fun findAll(): Flux<CervejaDTO>

    fun create(cervejaCreateDTO: CervejaCreateDTO): Mono<CervejaDTO>

}