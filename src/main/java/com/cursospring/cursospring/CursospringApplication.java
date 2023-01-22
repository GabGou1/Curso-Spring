package com.cursospring.cursospring;

import jakarta.persistence.EntityManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.cursospring.cursospring.controller"
})
@EnableJpaRepositories(basePackages = {
		"com.cursospring.cursospring.repository"
})
@EntityScan(basePackages = {
		"com.cursospring.cursospring.entity"
})
public class CursospringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursospringApplication.class, args);
	}
}