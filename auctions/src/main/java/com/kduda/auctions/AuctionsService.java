package com.kduda.auctions;

import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
class AuctionsService {

    private final PaymentsClient payments;

    AuctionsService(PaymentsClient payments) {
        this.payments = payments;
    }

    PaymentCreationStatus buyItem(){
        String id = UUID.randomUUID().toString();
        return payments.createPayment(id);
    }

    PaymentStatus getStatus(String id){
        return payments.checkStatus(id);
    }
}
