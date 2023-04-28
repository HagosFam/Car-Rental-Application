package com.example.CarRentalRESTClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CarRentalRestClientApplication implements CommandLineRunner {

	RestTemplate restTemplate = new RestTemplate();
	@Value("${serverUrl}")
	private String serverUrl;
	public static void main(String[] args) {
		SpringApplication.run(CarRentalRestClientApplication.class, args);
	}

	public void run(String... args) throws Exception {

		ResponseEntity<Customer[]> response = restTemplate.getForEntity(serverUrl+"customer", Customer[].class);
		Customer[] customers = response.getBody(); // get the array of cars from the response
		System.out.println("Printing all customers");
		System.out.print("\n" + Arrays.toString(customers));

		ResponseEntity<Payment[]> response2 = restTemplate.getForEntity(serverUrl+"payments", Payment[].class);
		Payment[] payments = response2.getBody(); // get the array of cars from the response
		System.out.println("Printing all payments");
		System.out.print("\n" + Arrays.toString(payments));

		ResponseEntity<Reservation[]> response3 = restTemplate.getForEntity(serverUrl+"reservations", Reservation[].class);
		Reservation[] reservations = response3.getBody(); // get the array of cars from the response
		System.out.println("Printing all Reservations");
		System.out.print("\n" + Arrays.toString(reservations));


		Customer customer = new Customer();

		List<Reservation> reservationList = new ArrayList<>();
		Reservation reservation1 = new Reservation();
		reservation1.setCustomer(customer);
		reservation1.setLicensePlate("123434A");
		reservationList.add(reservation1);


		List<Payment> paymentList = new ArrayList<>();
		Payment payment1 = new Payment();
		payment1.setPaymentType("Credit card");
		payment1.setCvv("23434");
		payment1.setAmountPaid(new BigDecimal(234234.3));
		payment1.setCreditCardNumber("9653845374");
		payment1.setCustomer(customer);
		paymentList.add(payment1);

		System.out.println("Creating one customer");
		restTemplate.postForLocation(serverUrl+"customer", new Customer("Cust123", "Hagos Abraha", "niggus@gmail.com", reservationList , paymentList));



	}

}
