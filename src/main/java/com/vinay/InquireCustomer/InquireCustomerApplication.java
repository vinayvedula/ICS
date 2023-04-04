package com.vinay.InquireCustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class InquireCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InquireCustomerApplication.class, args);
	}

}
