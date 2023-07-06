package com.demo.otp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class OtpDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtpDemoApplication.class, args);
	}

}
