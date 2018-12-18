package com.example.messageconsumer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    @Value("${queue.name}")
    private String queueName;

    @Value("${fanout.exchange}")
    private String fanoutExchange;

    @Bean
    Queue queue() {
        return new Queue(queueName, true);
    }

    @Bean
    FanoutExchange exchange() {
        return new FanoutExchange(fanoutExchange);
    }

    @Bean
    Binding binding(Queue queue, FanoutExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange);
    }

}
