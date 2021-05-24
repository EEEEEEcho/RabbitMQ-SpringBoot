package com.echo.service.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = {"sms-direct-queue"})//这是个数组，就意味着可以监听多个队列
@Component
public class DirectSMSConsumer {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("SMS direct -- 接收到了消息: " + message);
    }
}
