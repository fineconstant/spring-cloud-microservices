package com.kduda.payments;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("payments")
class PaymentsController {
    private final PaymentsService paymentsService;

    PaymentsController(PaymentsService paymentsService) {
        this.paymentsService = paymentsService;
    }

    @PostMapping("create")
    String createPayment(@RequestBody String id) {
        return paymentsService.createPayment(id);
    }

    @GetMapping("status/{id}")
    String statusForPayment(@PathVariable String id) {
        return paymentsService.statusForPayment(id);
    }
}
