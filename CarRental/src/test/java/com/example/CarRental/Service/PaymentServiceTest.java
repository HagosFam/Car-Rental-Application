package com.example.CarRental.Service;
import com.example.CarRental.domain.dto.PaymentDTO;
import com.example.CarRental.domain.entity.Payment;
import com.example.CarRental.repositories.PaymentRepository;
import com.example.CarRental.services.PaymentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTest {

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentService paymentService;

    @Test
    public void testGetAllPaymentInformation() {
        // Create a mock list of Payment objects
        List<Payment> mockPaymentList = new ArrayList<>();
        Payment payment1 = new Payment();
        payment1.setCvv("123");
        Payment payment2 = new Payment();
        payment2.setCreditCardNumber("456");
        mockPaymentList.add(payment1);
        mockPaymentList.add(payment2);

        // Set up the mock behavior for the paymentRepository.findAll() method
        when(paymentRepository.findAll()).thenReturn(mockPaymentList);

        // Call the method under test
        List<PaymentDTO> paymentDTOList = paymentService.getAllPaymentInformation();

        // Verify that the PaymentAdapter was called with the correct argument
        assertEquals(paymentDTOList.size(), 2);
        assertEquals(paymentDTOList.get(0).getCvv(), "123");
        assertEquals(paymentDTOList.get(1).getCreditCardNumber(), "456");
    }

}
