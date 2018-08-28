package com.kduda.payments;

import lombok.Value;

@Value
class PaymentStatus {
    String id;
    String status;
    String description;
}
