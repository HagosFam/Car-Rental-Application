package com.example.CarRental.repositories;

import com.example.CarRental.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // searching cars should be query
   // @Query("Select c ")

    Customer findByCustomerNumber(String customerNumber);



}