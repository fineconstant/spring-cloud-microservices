package com.kduda.auctions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureStubRunner(ids = "com.kduda:payments:+:stubs")
public class PaymentsClientTest {

    @Autowired
    private PaymentsClient client;

    @Test
    public void shouldCheckPaymentStatus() {
        PaymentStatus actual = client.checkStatus("abcde");
        PaymentStatus expected = new PaymentStatus("Status for id: [abcde]: OK");
        assertThat(actual).isEqualTo(expected);
    }

    // TODO: tests with DTO and JSON
    @Test
    public void shouldCreatePayment() {
        String actual = client.createPayment("12345-abcd");
        final String expected = "Created new payment with id: [12345-abcd]";
        assertThat(actual).isEqualTo(expected);
    }
}
