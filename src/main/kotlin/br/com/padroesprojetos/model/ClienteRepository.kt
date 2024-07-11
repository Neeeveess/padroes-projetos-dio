package br.com.padroesprojetos.model

import org.springframework.data.repository.CrudRepository

interface ClienteRepository: CrudRepository<Cliente, Long> {
}