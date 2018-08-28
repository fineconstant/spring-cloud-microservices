package com.kduda.payments;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.mockito.Mockito;


public class BaseContractTest {
    @Before
    public void setup() {
        // mock
        final PaymentsService paymentsService = Mockito.mock(PaymentsService.class);
        mockPaymentService(paymentsService);

        RestAssuredMockMvc.standaloneSetup(new PaymentsController(paymentsService));
    }

    private void mockPaymentService(PaymentsService service) {
        Mockito.when(service.statusForPayment("abcde"))
                .thenReturn(new PaymentStatus("abcde", "OK", "Success!"));
        Mockito.when(service.createPayment("12345-abcd"))
                .thenReturn(new PaymentCreationStatus("12345-abcd", "Payment created"));
    }
}
