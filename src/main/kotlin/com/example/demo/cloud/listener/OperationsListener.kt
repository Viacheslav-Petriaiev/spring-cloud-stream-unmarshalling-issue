package com.example.demo.cloud.listener

import com.example.demo.domain.Person
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import java.util.function.Function

@Component
class OperationsListener {

    @Bean
    fun operationsProcessor(): Function<Flux<Person>, Flux<Person>> =
            Function<Flux<Person>, Flux<Person>> { input ->
                input
                        .doOnNext {
                            println("operationsProcessor: Message received")
                        }
            }
}