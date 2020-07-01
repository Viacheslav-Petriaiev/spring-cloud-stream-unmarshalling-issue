package com.example.demo.cloud.listener

import com.example.demo.cloud.channel.CloudOperationsChannels
import com.example.demo.domain.Person
import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.stream.test.binder.MessageCollector
import org.springframework.messaging.support.GenericMessage
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
internal class OperationsListenerTest {

    @Autowired
    private lateinit var messageCollector: MessageCollector

    @Autowired
    private lateinit var cloudOperationsChannels: CloudOperationsChannels

    @Test
    fun operationsListener() {

        cloudOperationsChannels.input().send(
                GenericMessage(
                        ObjectMapper().writeValueAsBytes(
                                Person(firstName = "testFirstName", lastName = "testLastName")
                        )
                )
        )
        assertThat(messageCollector.forChannel(cloudOperationsChannels.output())).isNotEmpty
    }
}