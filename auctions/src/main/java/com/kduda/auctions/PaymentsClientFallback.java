package com.kduda.auctions;

import org.springframework.stereotype.Component;


@Component
class PaymentsClientFallback implements PaymentsClient {
    @Override
    public PaymentStatus checkStatus(String id) {
        return new PaymentStatus("Status fallback");
    }

    @Override
    public String createPayment(String id) {
        return "Payment unavailable";
    }
}
