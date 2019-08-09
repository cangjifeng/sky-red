package org.jerfan.red.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DirectRabbitConfig {


    @Bean
    public Queue CalonDirectQueue() {
        return new Queue("CalonDirectQueue",true);
    }

    @Bean
    public DirectExchange CalonDirectExchange() {
        return new DirectExchange("CalonDirectExchange");
    }
    @Bean
    public Binding bindingDirect() {
        return BindingBuilder.bind(CalonDirectQueue()).to(CalonDirectExchange()).with("CalonDirectRouting");
    }
}
