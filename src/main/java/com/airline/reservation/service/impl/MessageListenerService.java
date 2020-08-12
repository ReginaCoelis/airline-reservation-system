package com.airline.reservation.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MessageListenerService {
    @RabbitListener(queues = {"emails"})
    public void onEmailReceived(List<String> emails){
        // email
        log.info("Triggered {}",emails);
    }
}
