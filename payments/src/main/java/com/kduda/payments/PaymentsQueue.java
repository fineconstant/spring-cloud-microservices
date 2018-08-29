package com.kduda.payments;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

interface PaymentsQueue {
    @Output
    MessageChannel paymentsQueue();
}
