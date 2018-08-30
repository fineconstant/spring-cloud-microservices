package com.kduda.auctions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Slf4j
@Service
class AuctionsService {

    private final PaymentsClient payments;

    AuctionsService(PaymentsClient payments) {
        this.payments = payments;
    }

    PaymentCreationStatus buyItem() {
        String id = UUID.randomUUID().toString();
        log.info("Generated item id: [{}]", id);
        return payments.createPayment(id);
    }

    PaymentStatus getStatus(String id) {
        return payments.checkStatus(id);
    }
}
