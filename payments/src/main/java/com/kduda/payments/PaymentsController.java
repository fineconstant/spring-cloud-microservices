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

    // TODO: tests with DTO and JSON
    @PostMapping("create")
    String createPayment(@RequestBody String id) {
        return paymentsService.createPayment(id);
    }

    @GetMapping(value = "status/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    PaymentStatus statusForPayment(@PathVariable String id) {
        return paymentsService.statusForPayment(id);
    }
}
