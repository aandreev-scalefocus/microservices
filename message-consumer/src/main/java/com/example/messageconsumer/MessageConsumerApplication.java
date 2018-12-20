package com.example.messageconsumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
@EnableBinding(Sink.class)
public class MessageConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageConsumerApplication.class, args);
	}

	@StreamListener(Sink.INPUT)
	public void receiveMessage(MessageDTO messageDTO){
		if(messageDTO.getNumber() % 3 == 0){
			throw new AmqpRejectAndDontRequeueException("Rejected message: " + messageDTO);
		}
		log.warn("Received message: " + messageDTO);
	}

}

