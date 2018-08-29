package com.kduda.auctions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("auctions")
class AuctionsController {
    private final AuctionsService auctionsService;

    AuctionsController(AuctionsService auctionsService) {
        this.auctionsService = auctionsService;
    }

    @PostMapping("buy")
    PaymentCreationStatus buy() {
        log.info("Buying item");
        return auctionsService.buyItem();
    }

    @GetMapping(value = "status/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    PaymentStatus statusForId(@PathVariable String id) {
        log.info("Checking status for id: [" + id + "]");
        return auctionsService.getStatus(id);
    }
}
