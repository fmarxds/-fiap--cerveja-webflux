package br.com.fmarxds.fiapcervejawebflux.repository

import br.com.fmarxds.fiapcervejawebflux.entity.Cerveja
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface CervejaRepository : ReactiveMongoRepository<Cerveja, String>
