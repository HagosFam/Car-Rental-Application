package com.example.CarFleetRESTClient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

@SpringBootApplication
public class CarFleetRestClientApplication implements CommandLineRunner {
	RestTemplate restTemplate = new RestTemplate();
	private String serverUrl =  "http://localhost:8080/cars";

	public static void main(String[] args) {
		SpringApplication.run(CarFleetRestClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
         // Getting all cars
		ResponseEntity<Car[]> response = restTemplate.getForEntity(serverUrl, Car[].class);
		Car[] cars = response.getBody(); // get the array of cars from the response
		System.out.println("Printing all cars");
		System.out.print("\n" + Arrays.toString(cars));

		// Posting cars
		restTemplate.postForLocation(serverUrl, new Car("123434A", "Truck", "Chevi", new BigDecimal(23322.2), false));
		// posting second car
		restTemplate.postForLocation(serverUrl, new Car("123434B", "Pick up", "Chevi", new BigDecimal(233222.2), false) );


		// searching cars based on type
		// searching cars by brand
		// searching cars by price
		// updating cars












		//get all cars
//		System.out.println("Listing all cars");
//		Cars cars = restTemplate.getForObject(serverUrl, Cars.class);
//		System.out.println(cars);





	}

}
