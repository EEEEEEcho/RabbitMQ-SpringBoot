package com.echo;

import com.echo.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootOrderRabbitmqProducerApplicationTests {
    @Autowired
    private OrderService orderService;
    @Test
    void testFanout() {
        orderService.makeOrderFanout("1","1",12);
    }

    @Test
    void testDirect(){
        orderService.makeOrderDirect("2","2",13);
    }

    @Test
    void testTopic(){
        orderService.makeOrderTopic("3","3",14);
    }

    @Test
    void testTTL(){
        orderService.makeOrderTTL("4","4",15);
    }

    @Test
    void testTTLMessage(){
        orderService.makeOrderTTLMessage("5","5",16);
    }
}
