package br.com.padroesprojetos.service

import br.com.padroesprojetos.model.Endereco
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "viacep", url = "http://viacep.com.br/ws")
interface ViaCepService {

    @GetMapping("/{cep}/json/")
    fun consultarCep(@PathVariable("cep") cep: String): Endereco
}