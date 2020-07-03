package com.example.demo.cloud.listener

import com.example.demo.domain.Person
import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.stream.binder.test.InputDestination
import org.springframework.cloud.stream.binder.test.OutputDestination
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration
import org.springframework.context.annotation.Import
import org.springframework.messaging.support.GenericMessage
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
@Import(TestChannelBinderConfiguration::class)
internal class OperationsListenerTest {

    @Autowired
    private lateinit var input: InputDestination

    @Autowired
    private lateinit var output: OutputDestination

    @Test
    fun operationsListener() {

        input.send(
                GenericMessage(
                        ObjectMapper().writeValueAsBytes(
                                Person(firstName = "testFirstName", lastName = "testLastName")
                        )
                ),
                "operationsInputQueue"
        )
        val person = output.receive(5000, "operationsOutputQueue")
        assertThat(person).isNotNull
    }
}