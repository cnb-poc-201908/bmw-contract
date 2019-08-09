package com.bmw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BmwContractApplication {

	public static void main(String[] args) {
		SpringApplication.run(BmwContractApplication.class, args);
	}

}
