package br.com.padroesprojetos.controller

import br.com.padroesprojetos.model.Cliente
import br.com.padroesprojetos.service.ClienteService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("clientes")
class ClientRestController(private val clienteService: ClienteService) {

    @GetMapping
    fun buscarTodos(): ResponseEntity<Iterable<Cliente>>{
        return ResponseEntity.ok(clienteService.buscarTodos())
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ResponseEntity<Cliente>{
        return ResponseEntity.ok(clienteService.buscarPorId(id))
    }

    @PostMapping
    fun inserir(@RequestBody cliente: Cliente): ResponseEntity<Cliente>{
        clienteService.inserir(cliente)
        return ResponseEntity.ok(cliente)
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody cliente: Cliente): ResponseEntity<Cliente>{
        clienteService.atualizar(id,cliente)
        return ResponseEntity.ok(cliente)
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long): ResponseEntity<Unit>{
        clienteService.deletar(id)
        return ResponseEntity.ok().build()
    }

}