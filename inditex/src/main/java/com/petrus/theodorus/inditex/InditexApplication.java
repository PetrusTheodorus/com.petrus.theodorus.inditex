package com.petrus.theodorus.inditex;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class InditexApplication {

	public static void main(String[] args) {
		log.info("Iniciando servicio inditex con fecha {}", new Date());
		SpringApplication.run(InditexApplication.class, args);
	}

}