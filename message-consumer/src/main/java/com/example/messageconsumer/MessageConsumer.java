package com.example.messageconsumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @SneakyThrows
    @RabbitListener(queues = "${queue.name}")
    public void receiveMessage(String message) {
        MessageDTO messageDTO = new ObjectMapper().readValue(message, MessageDTO.class);
        if(messageDTO.getNumber() % 2 == 0){
            throw new AmqpRejectAndDontRequeueException("Something went wrong during processing of: " + messageDTO);
        }
        else {
            System.out.println("MessageDTO: " + messageDTO.toString());
        }

    }

}
