package com.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@Slf4j
public class ServiceApplication {

  @GetMapping("/service-hi")
  String hi(){
      log.info("service side hi get call");
      return "Hello?";
  }

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}
}
