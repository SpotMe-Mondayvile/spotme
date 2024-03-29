package com.mts.spotmerest;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@SpringBootApplication
public class SpotmeRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpotmeRestApplication.class, args);
	}

}
