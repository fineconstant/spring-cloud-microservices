package com.kduda.payments;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("payments")
class PaymentsController {
    private final PaymentsService paymentsService;

    PaymentsController(PaymentsService paymentsService) {
        this.paymentsService = paymentsService;
    }

    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    PaymentCreationStatus createPayment(@RequestBody String id) {
        return paymentsService.createPayment(id);
    }

    @GetMapping(value = "status/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    PaymentStatus statusForPayment(@PathVariable String id) {
        return paymentsService.statusForPayment(id);
    }
}
