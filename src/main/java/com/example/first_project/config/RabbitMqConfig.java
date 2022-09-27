package com.example.first_project.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    private static final String EXCHANGE_NAME = "test-exchange";
    private static final String QUEUE_NAME = "test-queue";
    private static final String ROUTING_KEY = "test";
    /**
     * durable : 브로커 (exchange + queue)가 재시작 될 때 남아있는 지 여부
     * ture : 재시작해도 유지 가능 false : 재시작하면 사라짐 **/
    @Bean
    Queue queue() {
        return new Queue(QUEUE_NAME, false);
    }
    /**
     * Exchange 모드
     * Direct : routing 키와 일치 할 때
     * Topic : routing 키 패턴과 일치할 때
     * Fanout : 모든 큐에 전달 **/
    @Bean
    DirectExchange exchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }
    @Bean
    RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory, MessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }
    @Bean
    MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
