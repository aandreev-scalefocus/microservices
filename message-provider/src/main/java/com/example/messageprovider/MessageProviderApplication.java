package com.example.messageprovider;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@SpringBootApplication
@EnableDiscoveryClient
@Controller
@Log4j
public class MessageProviderApplication {

    @Autowired
    MessageProducer messageProducer;

    public static void main(String[] args) {
        SpringApplication.run(MessageProviderApplication.class, args);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/send/{message}")
    public @ResponseBody void sendMessage(@PathVariable("message") String text) {
        MessageDTO messageDTO = new MessageDTO(text, new Random().nextInt(100));
        System.out.println("Sending message: " + messageDTO);
		messageProducer.produce(messageDTO);
    }
}

