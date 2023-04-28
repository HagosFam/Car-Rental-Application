package com.example.CarRental.Controllers;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;

import com.example.CarRental.domain.dto.CustomerDTO;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class CustomerControllerTest {

    private static final String BASE_URL = "http://localhost:8090";
    private static final String CUSTOMER_NUMBER = "123456";

    @Test
    public void getCustomer_returnsCustomerDetails() {

//        @Before
//        public static void setup() {
//            RestAssured.port = Integer.valueOf(8081);
//            RestAssured.baseURI = "http://localhost/";
//            RestAssured.basePath = "";
//        }

        // Arrange - setup the test data and expected results
        CustomerDTO expectedCustomer = new CustomerDTO();
        expectedCustomer.setCustomerNumber(CUSTOMER_NUMBER);
        expectedCustomer.setName("John");
        expectedCustomer.setEmail("john.doe@example.com");

        // Act - execute the GET request and retrieve the response
//        given().bbaseUri(BASE_URL)
//                .when()
//                .get("/customer/{customerNumber}", CUSTOMER_NUMBER)
//                .then()
//
//                // Assert - verify the response and expected results
//                .statusCode(HttpStatus.OK.value())
//                .body("customerNumber", equalTo(expectedCustomer.getCustomerNumber()))
//                .body("firstName", equalTo(expectedCustomer.getName()))
//                .body("email", equalTo(expectedCustomer.getEmail()));
    }
}
