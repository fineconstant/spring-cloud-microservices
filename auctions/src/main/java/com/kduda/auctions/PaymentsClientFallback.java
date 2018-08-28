package com.kduda.auctions;

import org.springframework.stereotype.Component;


@Component
class PaymentsClientFallback implements PaymentsClient {
    @Override
    public String checkStatus(String id) {
        return "Status fallback";
    }

    @Override
    public String createPayment(String id) {
        return "Payment unavailable";
    }
}
