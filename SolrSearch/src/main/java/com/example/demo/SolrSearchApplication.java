package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication

@ComponentScan({"com.spellChecker","com.suggestions"})
public class SolrSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolrSearchApplication.class, args);
	}
}
