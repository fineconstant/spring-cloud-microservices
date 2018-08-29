package com.kduda.payments;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Slf4j
@Service
class PaymentsService {

    private final PaymentsQueue paymentsQueue;

    PaymentsService(PaymentsQueue paymentsQueue) {
        this.paymentsQueue = paymentsQueue;
    }

    PaymentCreationStatus createPayment(String id) {
        log.info("Creating new payment with id: [" + id + "]");
        return new PaymentCreationStatus(id, "Payment created");
    }

    PaymentStatus statusForPayment(String id) {
        log.info("Checking status for payment with id: [" + id + "]");
        return new PaymentStatus(id, "OK", "Success!");
    }

    void paymentReceived(String id) {
        // send payment
        final HashMap<String, Object> headers = new HashMap<>();
        headers.put("contentType", "application/json");

        final PaymentMessage messageContent = new PaymentMessage(id, "Paid");

        paymentsQueue.paymentsQueue()
                     .send(MessageBuilder.createMessage(messageContent, new MessageHeaders(headers)));
    }
}
