package com.PWS.RabbitMQ.config;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;




@Configuration
public class MessageConfig {
    @Bean
    public Queue queue() {
        return new Queue(STATIC.QUEUE);
        
    }
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(STATIC.EXCHANGE);
        
    }
    @Bean
    public Binding binding(Queue queue,TopicExchange exchange) {
      return BindingBuilder.bind(queue).to(exchange).with(STATIC.ROUTING_KEY); 
    }
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
        
    }
    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

}
