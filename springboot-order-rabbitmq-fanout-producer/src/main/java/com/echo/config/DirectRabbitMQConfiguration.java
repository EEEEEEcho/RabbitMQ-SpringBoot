package com.echo.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectRabbitMQConfiguration {
    //1.声明注册direct模式的交换机
    @Bean
    public DirectExchange directExchange(){
        //param1:交换机名，param2:是否持久化，param3:是否自动删除
        return new DirectExchange("direct-order-exchange",true,false);
    }
    //2.声明队列sms.direct.queue, email.direct.queue, wechat.direct.queue
    @Bean
    public Queue smsDirectQueue(){
        //params1:队列名字，params2:是否持久化
        return new Queue("sms-direct-queue",true);
    }
    @Bean
    public Queue emailDirectQueue(){
        //params1:队列名字，params2:是否持久化
        return new Queue("email-direct-queue",true);
    }
    @Bean
    public Queue wechatDirectQueue(){
        //params1:队列名字，params2:是否持久化
        return new Queue("wechat-direct-queue",true);
    }
    //3.完成绑定关系
    @Bean
    public Binding smsDirectBinding(){
        //direct模式需要一个路由key
        return BindingBuilder.bind(smsDirectQueue()).to(directExchange()).with("sms");
    }
    @Bean
    public Binding emailDirectBinding(){
        //direct模式需要一个路由key
        return BindingBuilder.bind(emailDirectQueue()).to(directExchange()).with("email");
    }
    @Bean
    public Binding wechatDirectBinding(){
        //direct模式需要一个路由key
        return BindingBuilder.bind(wechatDirectQueue()).to(directExchange()).with("wechat");
    }
}
