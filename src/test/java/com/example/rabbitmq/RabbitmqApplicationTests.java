package com.example.rabbitmq;

import com.example.rabbitmq.Controller.IndexController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

    @Autowired
    private IndexController indexController;

    @Test
    public void contextLoads() {

        indexController.sendDirectQueue();

        indexController.sendTopicQueue();
    }


}
