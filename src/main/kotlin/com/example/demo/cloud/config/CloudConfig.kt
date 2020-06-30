package com.example.demo.cloud.config

import com.example.demo.cloud.channel.CloudOperationsChannels
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.context.annotation.Configuration

@Configuration
@EnableBinding(CloudOperationsChannels::class)
class CloudConfig