package io.hoseo.fbsample;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SimpleSender {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	
	@Scheduled(fixedDelay = 3000L)
    public void sendMessage() {
		log.info("Sending message...");
        rabbitTemplate.convertAndSend("sampleQueue", "HELLO WORLD");
    }
	
	@Scheduled(fixedDelay = 3000L)
    public void sendUsers() {
		log.info("Sending Users...");
        rabbitTemplate.convertAndSend("userExchange","ROUTE_USER", new UserInfo(1,"김민수","안녕하세요"));
    }
	
}
