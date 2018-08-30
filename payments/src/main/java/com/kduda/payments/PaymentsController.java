package com.kduda.payments;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("payments")
class PaymentsController {
    private final PaymentsService paymentsService;

    PaymentsController(PaymentsService paymentsService) {
        this.paymentsService = paymentsService;
    }

    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    PaymentCreationStatus createPayment(@RequestBody String id) {
        log.info("Creating new payment with id: [" + id + "]");
        return paymentsService.createPayment(id);
    }

    @GetMapping(value = "status/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    PaymentStatus statusForPayment(@PathVariable String id) {
        log.info("Checking status for payment with id: [" + id + "]");
        return paymentsService.statusForPayment(id);
    }
}
