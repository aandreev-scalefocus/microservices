package com.example.messageprovider;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    @Value("${queue.name}")
    private String queueName;

    @Value("${fanout.exchange}")
    private String fanoutExchange;

    @Value("${dead.letter.queue.name}")
    private String deadLetterQueue;

    @Bean
    Queue queue() {
        return QueueBuilder.durable(queueName)
                .withArgument("x-dead-letter-exchange", "")
                .withArgument("x-dead-letter-routing-key", deadLetterQueue)
                .build();
    }

    @Bean
    FanoutExchange exchange() {
        return new FanoutExchange(fanoutExchange);
    }

    @Bean
    Queue deadLetterQueue() { return new Queue(deadLetterQueue); }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange());
    }

}
