package com.kduda.auctions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.StubFinder;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureStubRunner(ids = ":payments")
public class PaymentListenerTest {

    @Autowired
    StubFinder stubFinder;

    @Autowired
    PaymentsQueueListener paymentsQueuelistener;

    @Test
    public void shouldReceivePaymentNotification() {
        // trigger message from stub by label
        stubFinder.trigger("paymentReceived");

        // when
        Payment actualPayment = paymentsQueuelistener.lastPayment;

        // then
        Payment expectedPayment = new Payment("abc", "Paid");
        assertThat(actualPayment).isEqualTo(expectedPayment);
    }
}
