package com.kduda.auctions;

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

    @GetMapping("status/{id}")
    String statusForId(@PathVariable String id) {
        return auctionsService.getStatus(id);
    }

}
