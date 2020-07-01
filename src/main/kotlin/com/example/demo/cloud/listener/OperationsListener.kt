package com.example.demo.cloud.listener

import com.example.demo.cloud.channel.CloudOperationsChannels
import com.example.demo.domain.Person
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.context.annotation.Bean
import org.springframework.messaging.Message
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import java.util.function.Function

@Component
class OperationsListener {

//    @StreamListener(CloudOperationsChannels.INPUT)
//    @SendTo(CloudOperationsChannels.OUTPUT)
//    fun operationsListener(input: Flux<Message<ByteArray>>): Flux<Message<ByteArray>> =
//            input
//                    .doOnNext {
//                        println("operationsListener: Message received")
//                    }

    @Bean
    fun operationsProcessor(): Function<Flux<Person>, Flux<Person>> =
            Function<Flux<Person>, Flux<Person>> { input ->
                input
                        .doOnNext {
                            println("operationsProcessor: Message received")
                        }
            }
}