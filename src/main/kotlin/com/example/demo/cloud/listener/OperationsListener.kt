package com.example.demo.cloud.listener

import com.example.demo.domain.Person
import org.springframework.context.annotation.Bean
import org.springframework.messaging.Message
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import java.util.function.Function

@Component
class OperationsListener {

    @Bean
    fun operationsProcessor(): Function<Flux<Message<ByteArray>>, Flux<Message<ByteArray>>> =
            Function<Flux<Message<ByteArray>>, Flux<Message<ByteArray>>> { input ->
                input
                        .doOnNext {
                            println("operationsProcessor: Message received: $it")
                        }
            }
}