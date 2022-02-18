package br.com.fmarxds.fiapcervejawebflux.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document
data class Cerveja(

    @Id
    val id: String? = null,

    @Field("nome")
    val nome: String,

    @Field("tipo")
    val tipo: String,

)
