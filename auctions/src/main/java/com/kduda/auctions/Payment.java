package com.kduda.auctions;

import lombok.Value;

// TODO: status as enum
@Value
class Payment {
    String paymentId;
    String status;
}
