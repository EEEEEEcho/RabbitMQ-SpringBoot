package com.echo.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = {"email-fanout-queue"})//这是个数组，就意味着可以监听多个队列
@Component
public class FanoutEmailConsumer {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("Email fanout -- 接收到了消息: " + message);
    }
}
