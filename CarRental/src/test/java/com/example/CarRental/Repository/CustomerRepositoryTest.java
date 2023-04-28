package com.example.CarRental.Repository;

import com.example.CarRental.domain.entity.Customer;
import com.example.CarRental.repositories.CustomerRepository;
import com.example.CarRental.services.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerRepositoryTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    public void testFindByCustomerNumber() {
        // Create a mock customer object
        Customer customer = new Customer();
        customer.setCustomerNumber("12345");

        // Set up the mock behavior for the customerRepository.findByCustomerNumber() method
//        when(customerRepository.findByCustomerNumber("12345")).thenReturn(Optional.of(customer));
//
//        // Call the method under test
//        Customer foundCustomer = customerService.findByCustomerNumber("12345");
//
//        // Verify that the customerRepository.findByCustomerNumber() method was called with the correct argument
//        assertEquals(foundCustomer.getCustomerNumber(), "12345");
    }
}
