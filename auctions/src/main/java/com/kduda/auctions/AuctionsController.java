package com.kduda.auctions;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("auctions")
class AuctionsController {
    private final AuctionsService auctionsService;

    AuctionsController(AuctionsService auctionsService) {
        this.auctionsService = auctionsService;
    }

    @PostMapping("buy")
    String buy() {
        return auctionsService.buyItem();
    }

    @GetMapping(value = "status/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    PaymentStatus statusForId(@PathVariable String id) {
        return auctionsService.getStatus(id);
    }

}
