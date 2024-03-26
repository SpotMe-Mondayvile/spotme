package com.mts.spotmerest;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@EntityScan
@SpringBootApplication

public class SpotmeRestApplication {

//public static DataSourceProperties dataSourceProperties;
//
//	public static void printURL(){
//		System.out.println("DataSource URL:++++++++++++++++++++\n\n\n\n\n\n\n\n " + dataSourceProperties.determineUrl() + "\n\n\n\n\n\n\n\n\n\n\n\n" );
//
//	}// trying to find a way to return the URL, I can get the name for the driver but not the URL to see what Springboot keeps trying to use for the DB_URL
	public static void main(String[] args) {
		SpringApplication.run(SpotmeRestApplication.class, args);
//		printURL();
	}

}
