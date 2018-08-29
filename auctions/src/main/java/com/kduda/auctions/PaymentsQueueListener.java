package com.kduda.auctions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
class PaymentsQueueListener {

    private final PaymentsQueue paymentsQueue;

    Payment lastPayment;

    PaymentsQueueListener(PaymentsQueue paymentsQueue) {
        this.paymentsQueue = paymentsQueue;
    }

    @StreamListener(PaymentsQueue.QUEUE_NAME)
    void handleMessage(Payment payment) {
        log.info("Received Payment message: {}", payment);
        lastPayment = payment;
    }
}
