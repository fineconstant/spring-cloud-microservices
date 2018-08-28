package com.kduda.payments;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
class PaymentsService {
    String createPayment(String id) {
        log.info("Creating new payment with id: [" + id + "]");
        return "Created new payment with id: [" + id + "]";
    }

    String statusForPayment(String id) {
        log.info("Checking status for payment with id: [" + id + "]");
        return "Status for id: [" + id + "]: OK";
    }
}
