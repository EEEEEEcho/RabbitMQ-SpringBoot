package com.echo.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OrderService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void makeOrderFanout(String userId, String productId, Integer num){
        //1.根据商品ID查询库存是否充足
        //2.保存订单
        String orderId = UUID.randomUUID().toString().replace("-","");
        System.out.println("订单：" + orderId + "生成成功.....");
        //3.通过MQ来完成消息的分发
        String exchangeName = "fanout-order-exchange";  //交换机名称
        String routeKey = "";   //路由key

        /**
         * 队列与交换机的绑定等配置在配置类RabbitMQConfiguration中完成
         */

        //参数说明 param1:交换机名称,param2:路由key/queue队列名称,param3:消息内容
        rabbitTemplate.convertAndSend(exchangeName,routeKey,orderId);
    }

    public void makeOrderDirect(String userId,String productId,Integer num){
        //1.根据商品ID查询库存是否充足
        //2.保存订单
        String orderId = UUID.randomUUID().toString().replace("-","");
        System.out.println("订单：" + orderId + "生成成功direct.....");
        //3.通过MQ来完成消息的分发
        String exchangeName = "direct-order-exchange";  //交换机名称
        String routeKey1 = "sms";   //路由key
        String routeKey2 = "email";

        /**
         * 队列与交换机的绑定等配置在配置类RabbitMQConfiguration中完成
         */

        //参数说明 param1:交换机名称,param2:路由key/queue队列名称,param3:消息内容
        rabbitTemplate.convertAndSend(exchangeName,routeKey1,orderId);
        rabbitTemplate.convertAndSend(exchangeName,routeKey2,orderId);
    }

    public void makeOrderTopic(String userId,String productId,Integer num){
        //1.根据商品ID查询库存是否充足
        //2.保存订单
        String orderId = UUID.randomUUID().toString().replace("-","");
        System.out.println("订单：" + orderId + "生成成功direct.....");
        //3.通过MQ来完成消息的分发
        String exchangeName = "topic-order-exchange";  //交换机名称
        String routeKey1 = "com.email.xxx";
        String routeKey2 = "org.wechat.cc";
        /**
         * 队列与交换机的绑定等在消费方，使用注解完成
         */

        //参数说明 param1:交换机名称,param2:路由key/queue队列名称,param3:消息内容
        rabbitTemplate.convertAndSend(exchangeName,routeKey1,orderId);
        rabbitTemplate.convertAndSend(exchangeName,routeKey2,orderId);
    }

    public void makeOrderTTL(String userId,String productId,Integer num){
        //1.根据商品ID查询库存是否充足
        //2.保存订单
        String orderId = UUID.randomUUID().toString().replace("-","");
        System.out.println("订单：" + orderId + "生成成功TTL.....");
        //3.通过MQ来完成消息的分发
        String exchangeName = "ttl-direct-exchange";  //交换机名称
        String routeKey1 = "ttl";
        /**
         * 队列与交换机的绑定等在消费方
         */

        //参数说明 param1:交换机名称,param2:路由key/queue队列名称,param3:消息内容
        rabbitTemplate.convertAndSend(exchangeName,routeKey1,orderId);
    }
}
