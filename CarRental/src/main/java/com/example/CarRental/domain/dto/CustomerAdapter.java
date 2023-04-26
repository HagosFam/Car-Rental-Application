package com.example.CarRental.domain.dto;

import com.example.CarRental.domain.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerAdapter {
    public static CustomerDTO getCustomerDTOFromCustomer(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerNumber(customer.getCustomerNumber());
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setReservationList(customer.getReservationList());
        return customerDTO;
    }

    public static Customer getCustomerFromCustomerDTO(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setCustomerNumber(customerDTO.getCustomerNumber());
        customer.setEmail(customerDTO.getEmail());
        customer.setName(customerDTO.getName());
        customer.setReservationList(customerDTO.getReservationList());
        return customer;
    }

    public static List<CustomerDTO> getListCustomerDTOFromCustomerList(List<Customer> customerList) {
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for(Customer cus:customerList){
            customerDTOS.add(getCustomerDTOFromCustomer(cus));
        }
        return customerDTOS;
    }


}
