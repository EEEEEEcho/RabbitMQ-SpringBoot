package com.echo.service.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = {"email-direct-queue"})//这是个数组，就意味着可以监听多个队列
@Component
public class DirectEmailConsumer {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("Email direct -- 接收到了消息: " + message);
    }
}
