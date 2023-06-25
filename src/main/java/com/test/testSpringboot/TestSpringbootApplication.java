package com.test.testSpringboot;

import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestSpringbootApplication {

	public static void main(String[] args) {
		MDC.put("id_trx","SYSTEM");
		SpringApplication.run(TestSpringbootApplication.class, args);
	}

}
