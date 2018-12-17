package com.example.messageconsumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    public void receiveMessage(String message) {
        System.out.println("Received (String) " + message);
        processMessage(message);
    }

    public void receiveMessage(byte[] message) {
        String strMessage = new String(message);
        System.out.println("Received (Bytes) " + strMessage);
        processMessage(strMessage);
    }

    @SneakyThrows
    private void processMessage(String message) {
        MessageDTO messageDTO = new ObjectMapper().readValue(message, MessageDTO.class);
        System.out.println("NessageDTO: " + messageDTO.toString());
    }

}
