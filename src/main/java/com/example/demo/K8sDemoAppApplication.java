package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class K8sDemoAppApplication {

	private RestTemplate rest = new RestTemplateBuilder().build();

	@GetMapping("/")
	public String hello()
	{
		String name = rest.getForObject("http://k8s-workshop-name-service", String.class);
		return "Hola " + name;
	}

	public static void main(String[] args) {
		SpringApplication.run(K8sDemoAppApplication.class, args);
	}

}
