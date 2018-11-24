package io.hoseo.fbsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BootsampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootsampleApplication.class, args);
	}
}
