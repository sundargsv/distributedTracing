package com.example.zipkinclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
@Slf4j
public class ZipkinClientApplication {

  @Bean
  RestTemplate restTemplate(){
    return new RestTemplate();
  }

  @NewSpan("callingHi")
  @GetMapping("/client-hi")
  String hi(){
      log.info("client side hi get call");
      return restTemplate().getForEntity("http://localhost:8081/service-hi",String.class).getBody();
  }

	public static void main(String[] args) {
		SpringApplication.run(ZipkinClientApplication.class, args);
	}
}
