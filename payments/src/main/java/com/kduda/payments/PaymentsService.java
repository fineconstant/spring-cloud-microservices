package com.kduda.payments;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
class PaymentsService {
    PaymentCreationStatus createPayment(String id) {
        log.info("Creating new payment with id: [" + id + "]");
        return new PaymentCreationStatus(id, "Payment created");
    }

    PaymentStatus statusForPayment(String id) {
        log.info("Checking status for payment with id: [" + id + "]");
        return new PaymentStatus(id, "OK", "Success!");
    }
}
