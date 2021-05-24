package com.echo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitMQConfiguration {
    //1.声明注册fanout模式的交换机
    @Bean
    public FanoutExchange fanoutExchange(){
        //param1:交换机名，param2:是否持久化，param3:是否自动删除
        return new FanoutExchange("fanout-order-exchange",true,false);
    }
    //2.声明队列sms.fanout.queue, email.fanout.queue, wechat.fanout.queue
    @Bean
    public Queue smsQueue(){
        //params1:队列名字，params2:是否持久化
        return new Queue("sms-fanout-queue",true);
    }
    @Bean
    public Queue emailQueue(){
        //params1:队列名字，params2:是否持久化
        return new Queue("email-fanout-queue",true);
    }
    @Bean
    public Queue wechatQueue(){
        //params1:队列名字，params2:是否持久化
        return new Queue("wechat-fanout-queue",true);
    }
    //3.完成绑定关系
    @Bean
    public Binding smsBinding(){
        return BindingBuilder.bind(smsQueue()).to(fanoutExchange());
    }
    @Bean
    public Binding emailBinding(){
        return BindingBuilder.bind(emailQueue()).to(fanoutExchange());
    }
    @Bean
    public Binding wechatBinding(){
        return BindingBuilder.bind(wechatQueue()).to(fanoutExchange());
    }
}
