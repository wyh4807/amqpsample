package io.hoseo.fbsample;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitConfig {
	
	@Bean
	public Queue testQueue() {
		return new Queue("testQueue");
	}
	
	@Bean
	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
	    final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
	    rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
	    return rabbitTemplate;
	}
	 
	@Bean
	public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
	    return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public Queue sampleQueue() {
		return new Queue("sampleQueue",true);
	}
	
	@Bean
	public TopicExchange userExchange() {
		return new TopicExchange("userExchange");
	}
	
	@Bean
	public Queue userQueue() {
		return new Queue("userQueue",true);
	}
	
	@Bean
	public Binding userBinding() {
		return BindingBuilder.bind(userQueue()).to(userExchange()).with("ROUTE_USER");
	}
	
}
