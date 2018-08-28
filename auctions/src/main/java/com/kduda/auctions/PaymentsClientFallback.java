package com.kduda.auctions;

import org.springframework.stereotype.Component;


@Component
class PaymentsClientFallback implements PaymentsClient {
    @Override
    public PaymentStatus checkStatus(String id) {
        return new PaymentStatus(id, "Status fallback");
    }

    @Override
    public PaymentCreationStatus createPayment(String id) {
        return new PaymentCreationStatus("Payment unavailable");
    }
}
