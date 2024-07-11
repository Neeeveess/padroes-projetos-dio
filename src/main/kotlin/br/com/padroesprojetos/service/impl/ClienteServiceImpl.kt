package br.com.padroesprojetos.service.impl

import br.com.padroesprojetos.model.Cliente
import br.com.padroesprojetos.model.ClienteRepository
import br.com.padroesprojetos.model.EnderecoRepository
import br.com.padroesprojetos.service.ClienteService
import br.com.padroesprojetos.service.ViaCepService
import org.springframework.stereotype.Service

@Service
class ClienteServiceImpl(
    val clienteRepository: ClienteRepository,
    val enderecoRepository: EnderecoRepository,
    val viaCepService: ViaCepService
): ClienteService {
    
    
    override fun buscarTodos(): Iterable<Cliente> {
        return clienteRepository.findAll()
    }

    override fun buscarPorId(id: Long): Cliente {
        val cliente = clienteRepository.findById(id)
        return cliente.get()
    }

    override fun inserir(cliente: Cliente) {
        salvarClienteComCep(cliente)
    }



    override fun atualizar(id: Long, cliente: Cliente) {
        val clienteBd = clienteRepository.findById(id)

        if(clienteBd.isPresent){
            salvarClienteComCep(cliente)
        }
    }

    override fun deletar(id: Long) {
        clienteRepository.deleteById(id)
    }

    private fun salvarClienteComCep(cliente: Cliente) {
        val cep = cliente.endereco.cep
        val endereco = enderecoRepository.findById(cep).orElseGet {
            val novoEndereco = viaCepService.consultarCep(cep)
            enderecoRepository.save(novoEndereco)
        }

        cliente.apply {
            this.endereco = endereco
        }

        clienteRepository.save(cliente)
    }
}