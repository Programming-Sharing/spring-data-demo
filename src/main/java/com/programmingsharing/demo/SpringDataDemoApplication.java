package com.programmingsharing.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.programmingsharing.demo.repository.CountryRepository;

@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner {
	
	@Autowired
	private CountryRepository countryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		countryRepository.findAll().forEach(it -> {System.out.println(it);});
		
	}

}
