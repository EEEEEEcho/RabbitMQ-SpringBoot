package com.echo.service.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "email-topic-queue",durable = "true",autoDelete = "false"), //绑定的队列
        exchange = @Exchange(value = "topic-order-exchange",type = ExchangeTypes.TOPIC), //绑定的交换机
        key = "*.email.*" //路由key
))
@Component
public class TopicEmailConsumer {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("Email topic -- 接收到了消息: " + message);
    }
}
