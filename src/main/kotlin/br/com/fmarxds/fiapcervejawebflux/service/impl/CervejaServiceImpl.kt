package br.com.fmarxds.fiapcervejawebflux.service.impl

import br.com.fmarxds.fiapcervejawebflux.dto.CervejaCreateDTO
import br.com.fmarxds.fiapcervejawebflux.dto.CervejaDTO
import br.com.fmarxds.fiapcervejawebflux.entity.Cerveja
import br.com.fmarxds.fiapcervejawebflux.repository.CervejaRepository
import br.com.fmarxds.fiapcervejawebflux.service.CervejaService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration

@Service
class CervejaServiceImpl(

    private val cervejaRepository: CervejaRepository,

) : CervejaService {

    override fun findAll() = cervejaRepository
        .findAll()
        .map { CervejaDTO(id = it.id!!, nome = it.nome, tipo = it.tipo) }
        .delayElements(Duration.ofMillis(100))

    override fun create(cervejaCreateDTO: CervejaCreateDTO): Mono<CervejaDTO> = Mono.just(cervejaCreateDTO)
        .map { Cerveja(nome = it.nome, tipo = it.tipo) }
        .flatMap { cervejaRepository.save(it) }
        .map { CervejaDTO(id = it.id!!, nome = it.nome, tipo = it.tipo) }

}