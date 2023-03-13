package ru.savkins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
// final work by Savkin Sergey Java-23

@SpringBootApplication
@EnableJpaRepositories("ru.savkins.dao*")
@ComponentScan(basePackages = {"ru.savkins.*"})
@EntityScan({"ru.savkins.model.*", "ru.savkins.dao.*", "ru.savkins.service.*"})
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

}
