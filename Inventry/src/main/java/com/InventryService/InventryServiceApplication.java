package com.InventryService;

import com.InventryService.Entity.Inventry;
import com.InventryService.Repository.InventryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventryRepository inventryRepository) {
		return args -> {
			Inventry inventry = new Inventry();
			inventry.setQuantity(100);
			inventry.setSkuCode("Iphone_13");

			Inventry inventry1 = new Inventry();
			inventry1.setQuantity(10);
			inventry1.setSkuCode("Iphone_13_red");

			inventryRepository.save(inventry);
			inventryRepository.save(inventry1);
		};
	}
}
