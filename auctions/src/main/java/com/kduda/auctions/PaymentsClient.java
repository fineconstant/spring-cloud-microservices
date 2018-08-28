package com.kduda.auctions;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(value = "payments", fallback = PaymentsClientFallback.class)
interface PaymentsClient {
    @GetMapping("payments/status/{id}")
    PaymentStatus checkStatus(@PathVariable("id") String id);

    @PostMapping(value = "payments/create", produces = MediaType.APPLICATION_JSON_VALUE)
    PaymentCreationStatus createPayment(String id);
}
