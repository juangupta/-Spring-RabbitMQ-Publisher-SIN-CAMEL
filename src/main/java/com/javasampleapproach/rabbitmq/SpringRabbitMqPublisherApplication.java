package com.javasampleapproach.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringRabbitMqPublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRabbitMqPublisherApplication.class, args);
	}
	
	@Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        //connectionFactory.setUri("amqp://juagomez:vinula@localhost:5672");
    	//*******RabbitMQ-DEV
        //connectionFactory.setUri("amqps://admin:SNMYSCACWOLMHZHS@portal-ssl1233-20.bmix-dal-yp-eccd01e7-4f3d-4c90-bc67-220feeeb8e46.2126222060.composedb.com:54907/bmix-dal-yp-eccd01e7-4f3d-4c90-bc67-220feeeb8e46");
        connectionFactory.setUri("amqp://ifyrtjsc:F9fttMFgJ1_RUJX6d4DIvn9TyQiNmiR8@chimpanzee.rmq.cloudamqp.com/ifyrtjsc");
        connectionFactory.setChannelCacheSize(100);
        return connectionFactory;
    }
	
	@Bean
	public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		//rabbitTemplate.setMessageConverter(jsonMessageConverter());
		return rabbitTemplate;
	}
}
