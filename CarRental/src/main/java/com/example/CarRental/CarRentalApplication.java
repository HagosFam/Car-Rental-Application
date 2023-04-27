package com.example.CarRental;

import com.example.CarRental.web.CustomerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJms
public class CarRentalApplication implements CommandLineRunner {

	@Autowired
	CustomerController customerController;
	public static void main(String[] args) {
		SpringApplication.run(CarRentalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		// create list of credit cards
//		List<CreditCard> creditCardList = new ArrayList<>();
//		CreditCard creditCard = new CreditCard("76232", "232", new BigDecimal(2322), "Electronic");
//		creditCardList.add(creditCard);
//
//		// create list of reservations
//		List<Reservation> reservations = new ArrayList<>();
//		Reservation reservation = new Reservation();

		// expect car to be printed
		System.out.println("Checking search cars");
		//customerController.searchCar("13321F");



	}

}
