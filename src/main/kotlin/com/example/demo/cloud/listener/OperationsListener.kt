package com.example.demo.cloud.listener

import com.example.demo.cloud.channel.CloudOperationsChannels
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.messaging.Message
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class OperationsListener {

    @StreamListener(CloudOperationsChannels.INPUT)
    @SendTo(CloudOperationsChannels.OUTPUT)
    fun operationsListener(input: Flux<Message<ByteArray>>): Flux<Message<ByteArray>> =
            input
                    .doOnNext {
                        println("Message received")
                    }
}