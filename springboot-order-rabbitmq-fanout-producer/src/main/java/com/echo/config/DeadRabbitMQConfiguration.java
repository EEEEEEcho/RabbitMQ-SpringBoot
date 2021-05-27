package com.echo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeadRabbitMQConfiguration {
    //1.声明注册direct模式的死信交换机
    @Bean
    public DirectExchange deadDirectExchange(){
        //param1:交换机名，param2:是否持久化，param3:是否自动删除
        return new DirectExchange("dead-direct-exchange",true,false);
    }

    //2.在死信交换机中声明一个死信队列
    @Bean
    public Queue deadQueue(){
        //params1:队列名字，params2:是否持久化
        return new Queue("dead-direct-queue",true);
    }

    //3.绑定队列和交换机
    @Bean
    public Binding deadBinding(){
        //direct模式需要一个路由key
        return BindingBuilder.bind(deadQueue()).to(deadDirectExchange()).with("dead");
    }
}
