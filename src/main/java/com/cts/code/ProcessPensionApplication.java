package com.cts.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProcessPensionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessPensionApplication.class, args);
	}

}
