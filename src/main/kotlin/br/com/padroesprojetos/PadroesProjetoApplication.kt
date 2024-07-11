package br.com.padroesprojetos

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class PadroesProjetoApplication

fun main(args: Array<String>) {
    runApplication<PadroesProjetoApplication>(*args)
}
