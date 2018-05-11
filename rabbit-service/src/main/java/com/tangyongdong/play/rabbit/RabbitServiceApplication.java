package com.tangyongdong.play.rabbit;

import com.tangyongdong.base.annotation.BaseStarter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@BaseStarter
public class RabbitServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitServiceApplication.class, args);
	}
}
