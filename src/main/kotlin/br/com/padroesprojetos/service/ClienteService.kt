package br.com.padroesprojetos.service

import br.com.padroesprojetos.model.Cliente

interface ClienteService {
    fun buscarTodos(): Iterable<Cliente>;

    fun buscarPorId(id: Long): Cliente;

    fun inserir(cliente: Cliente): Unit;

    fun atualizar(id: Long, cliente: Cliente): Unit;

    fun deletar(id: Long): Unit;
}