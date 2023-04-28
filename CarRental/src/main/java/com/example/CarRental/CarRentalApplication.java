package com.example.CarRental;

import com.example.CarRental.services.CustomerService;
import com.example.CarRental.web.CustomerController;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
//@EnableJms
@ConfigurationPropertiesScan
public class CarRentalApplication implements CommandLineRunner {

	Logger loggerFactory = LoggerFactory.logger(CarRentalApplication.class);
	@Autowired
	CustomerController customerController;

	@Autowired
	JmsTemplate jmsTemplate;

	@Autowired
	CustomerService customerService;
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

		System.out.println("Testing sending message");
		//jmsTemplate.convertAndSend("CarRentalMessage", "Sending message");

		// expect car to be printed
		System.out.println("Checking search cars");
		//customerController.searchCar("13321F");

		//System.out.println(" EVENT Sending email to fleet manager");
		//new CountCarEvent("Count");

		System.out.println("Logger starting here");
		loggerFactory.warn("Warning logging");
		loggerFactory.info("Info logging");
		loggerFactory.error("Error logging");
		loggerFactory.debug("Debug logging");

	}

}
