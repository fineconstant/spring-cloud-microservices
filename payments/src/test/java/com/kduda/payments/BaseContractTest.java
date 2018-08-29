package com.kduda.payments;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMessageVerifier // for message streams verification
public abstract class BaseContractTest {

    // SpringContext required
    @Autowired
    PaymentsService paymentsService;

    @Before
    public void setup() {
        // mock
        final PaymentsService paymentsService = Mockito.mock(PaymentsService.class);
        configureMocks(paymentsService);

        RestAssuredMockMvc.standaloneSetup(new PaymentsController(paymentsService));
    }

    private void configureMocks(PaymentsService service) {
        Mockito.when(service.statusForPayment("abcde"))
               .thenReturn(new PaymentStatus("abcde", "OK", "Success!"));
        Mockito.when(service.createPayment("12345-abcd"))
               .thenReturn(new PaymentCreationStatus("12345-abcd", "Payment created"));
    }

    public void triggerPaymentReceived(String id) {
        paymentsService.paymentReceived(id);
    }
}
