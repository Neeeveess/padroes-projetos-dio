package br.com.padroesprojetos.model

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Endereco (

    @Id
    val cep: String,
    var logradouro: String?,
    var complemento: String?,
    var unidade: String?,
    var bairro: String?,
    var localidade: String?,
    var uf: String?,
    var ibge: String?,
    var gia: String?,
    var ddd: String?,
    var siafi: String?
)