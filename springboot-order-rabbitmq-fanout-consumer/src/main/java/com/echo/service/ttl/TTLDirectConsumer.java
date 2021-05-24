package com.echo.service.ttl;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = {"ttl-direct-queue"})
public class TTLDirectConsumer {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("TTL direct -- 接收到了消息: " + message);
    }
}
