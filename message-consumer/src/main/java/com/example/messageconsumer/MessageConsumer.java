package com.example.messageconsumer;

import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    public void receiveMessage(String message) {
        System.out.println("Received (String) " + message);
        processMessage(message);
    }

    public void receiveMessage(byte[] message) {
        String strMessage = new String(message);
        System.out.println("Received (No String) " + strMessage);
        processMessage(strMessage);
    }

    private void processMessage(String message) {
//        String object = new ObjectMapper().readValue(message, String.class);
        System.out.println(message);
    }

}
