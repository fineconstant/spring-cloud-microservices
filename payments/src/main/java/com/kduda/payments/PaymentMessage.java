package com.kduda.payments;

import lombok.Value;

@Value
class PaymentMessage {
    String paymentId;
    String status;
}

