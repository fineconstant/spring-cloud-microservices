package com.kduda.auctions;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

interface PaymentsQueue {
    String QUEUE_NAME = "paymentsQueue";

    @Input(QUEUE_NAME)
    MessageChannel paymentsQueue();
}
