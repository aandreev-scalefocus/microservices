package com.example.messageconsumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @RabbitListener(queues = "${queue.name}")
    public void receiveMessage(String message) {
        processMessage(message);
    }

    @SneakyThrows
    private void processMessage(String message) {
        MessageDTO messageDTO = new ObjectMapper().readValue(message, MessageDTO.class);
        System.out.println("NessageDTO: " + messageDTO.toString());
    }

}
