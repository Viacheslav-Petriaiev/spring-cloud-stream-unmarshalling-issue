package com.example.demo.cloud.channel

import org.springframework.cloud.stream.annotation.Input
import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.SubscribableChannel

interface CloudOperationsChannels {

    companion object {
        const val INPUT = "operationsInput"
        const val OUTPUT = "operationsOutput"
    }

    @Input(INPUT)
    fun input(): SubscribableChannel

    @Output(OUTPUT)
    fun output(): MessageChannel

}
