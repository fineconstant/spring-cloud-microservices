package com.kduda.payments;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("payments")
class PaymentsController {

    @PostMapping("create")
    String createPayment(@RequestBody String id) {
        log.info("Creating new payment with id: [" + id + "]");
        return "Created new payment with id: [" + id + "]";
    }

    @GetMapping("status/{id}")
    String statusForPayment(@PathVariable String id) {
        log.info("Checking status for payment with id: [" + id + "]");
        return "Status for id: [" + id + "]: OK";
    }

}
