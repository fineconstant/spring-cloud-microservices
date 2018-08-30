package com.kduda.auctions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
class PaymentsClientFallback implements PaymentsClient {
    @Override
    public PaymentStatus checkStatus(String id) {
        log.warn("Falling back for status checking");
        return new PaymentStatus(id, "Payment status fallback");
    }

    @Override
    public PaymentCreationStatus createPayment(String id) {
        log.warn("Falling back fo payment");
        return new PaymentCreationStatus("Payment unavailable fallback");
    }
}
