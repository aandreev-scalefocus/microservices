package com.example.messageprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@SpringBootApplication
@EnableDiscoveryClient
@Controller
@EnableBinding(Source.class)
public class MessageProviderApplication {

    @Autowired
    Source source;

    public static void main(String[] args) {
        SpringApplication.run(MessageProviderApplication.class, args);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/send/{message}")
//    @SendTo(Source.OUTPUT)
    public @ResponseBody MessageDTO sendMessage(@PathVariable("message") String text) {
        MessageDTO messageDTO = new MessageDTO(text, new Random().nextInt(100));
        System.out.println("Sending message: " + messageDTO);

        source.output().send(MessageBuilder.withPayload(messageDTO).build());

        return messageDTO;
    }
}

