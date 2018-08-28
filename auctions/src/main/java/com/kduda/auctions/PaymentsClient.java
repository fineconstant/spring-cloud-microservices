package com.kduda.auctions;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(value = "payments", fallback = PaymentsClientFallback.class)
interface PaymentsClient {
    @GetMapping("payments/status/{id}")
    PaymentStatus checkStatus(@PathVariable("id") String id);

    @PostMapping("payments/create")
    String createPayment(String id);
}
