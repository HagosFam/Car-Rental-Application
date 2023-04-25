# Car-Rental-Application
A complete car rental application using Spring boot. It contains messaging using activemq and kafka, Spring data JPA, Mongo data JPA, monitoring applications like prometheus, micrometer and grafna 

The whole application description is as follows

Enterprise Architecture Project 

Implement a car rental application with the following requirements: 
Functional requirements: 
Car functionality: 
We can add, remove, update and find cars in the car rental application. You can search cars on car 
type, brand, price. We can have multiple cars of the same brand and type. For example we have 15 
Ford F1 Pickup trucks. Every individual car has a unique license plate. 
The system keeps track of how many cars of a certain brand and type are available in the car fleet. 
Customer functionality: 
We can add, remove, update and find customers in the car rental application. You can search 
customers on customernumber, name and email address. Every customers has an unique 
customernumber. 
Reservation functionality: 
A customer can reserve a certain car type for a certain period. 
Borrowing functionality. 
A customer can pickup the car at the car renting location 
A customer can return the car to the car renting location 
The customer pays for the car when the car is returned. 
Rentals can only be paid by creditcard. 
We can retrieve the following information: 
- Get all data from a customer(including reserved cars, rental history, payments made) 
- Get all data from a particular car including the rental history. 
-
Architecture requirements 
The Car rental system consist of 2 separate applications: 

![image](https://user-images.githubusercontent.com/41420437/234293215-ce50a58e-0185-4a17-b5b6-32a6ed614cfb.png)


Application 1: Car fleet application 
- Contains the collection of cars with all car functionality described above. This functionality 
can be accessed through a REST interface. Write a REST client that calls the functionality of 
this application. 
- Uses a Mongo database 
Application 2: Car rental application 
- Contains all functionality that a customer needs in order to search and reserve a car. It also 
contains the functionality for the rental employee to handle car pickups and car returns. This 
functionality can be accessed through a REST interface. Write a REST client that calls the 
functionality of this application. 
- Uses a HSQLDB database 
- Use JPA for database access 
- Add logging (console and file) to this application at different logging levels. 
- This application should be monitored with Grafana. 
- Use scheduling so that the application prints every 20 seconds an overview of all cars 
including their state (rented out, available).
- The following data can be configured in application.properties:
o Maximum number of cars a customer can reserve.
o The URL to the car fleet application
- Use @ConfigurationProperties to read these properties
- All domain logic is tested in unit tests 
- All queries in the repositories are tested. 
- Rental functionality is tested with RestAssured 
- Anytime a car is reserved, the car rental application sends a JMS message using ActiveMQ to 
the car fleet application. The car fleet keeps track of how many cars are available of a certain 
brand/type. 
- The car fleet application keeps the data of all cars. It is important that the car rental 
application always calls the car fleet application if it needs car data. 
- When there are less than 3 cars available of a certain brand/type combination, the system 
should send an email to the fleet manager (Do net send a real email, but use 
System.out.println())
