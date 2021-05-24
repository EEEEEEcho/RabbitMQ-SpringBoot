package com.echo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class TTLRabbitMQConfiguration {

    @Bean
    public DirectExchange ttlDirectExchange(){
        //定义一个交换机
        return new DirectExchange("ttl-direct-exchange",true,false);
    }

    @Bean
    public Queue directTTLQueue(){
        //定义一个ttl的队列
        Map<String,Object> args = new HashMap<>();
        //参数 x-message-ttl 的值 必须是非负 32 位整数 (0 <= n <= 2^32-1),
        //以毫秒为单位表示TTL的值。这样值5000表示存在于队列中的当前消息将最多只存活5秒钟。
        args.put("x-message-ttl",5000);
        return new Queue("ttl-direct-queue",true,false,false,args);
    }

    @Bean
    public Binding directTTLBinding(){
        return BindingBuilder.bind(directTTLQueue()).to(ttlDirectExchange()).with("ttl");
    }
}
