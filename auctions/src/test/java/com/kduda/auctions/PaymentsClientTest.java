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
        String actual = client.checkStatus("abcde");
        final String expected = "Status for id: [abcde]: OK";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldCreatePayment() {
        String actual = client.createPayment("12345-abcdefg");
        final String expected = "Created new payment with id: [12345-abcdefg]";
        assertThat(actual).isEqualTo(expected);
    }
}
