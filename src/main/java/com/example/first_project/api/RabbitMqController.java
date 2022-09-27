package com.example.first_project.api;

import com.example.first_project.service.RabbitMqService;
import com.example.first_project.vo.RabbitMqMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMqController {
    @Autowired
    RabbitMqService rabbitMqService;

    @RequestMapping("/messegeSend")
    public RabbitMqMessage send(RabbitMqMessage rabbitMqMessage) {
        rabbitMqService.addQueue(rabbitMqMessage);
        System.out.printf("fff");
        return rabbitMqMessage;
    }

}
