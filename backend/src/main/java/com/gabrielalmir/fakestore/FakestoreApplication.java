package com.gabrielalmir.fakestore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FakestoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(FakestoreApplication.class, args);
	}

}
