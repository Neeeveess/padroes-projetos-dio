package br.com.padroesprojetos.model

import org.springframework.data.repository.CrudRepository

interface EnderecoRepository: CrudRepository<Endereco, String> {
}