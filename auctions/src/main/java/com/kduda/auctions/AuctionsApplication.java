package com.kduda.auctions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;


@EnableFeignClients
@EnableCircuitBreaker
@SpringBootApplication
@EnableHystrixDashboard
@EnableBinding(PaymentsQueue.class)
public class AuctionsApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuctionsApplication.class, args);
    }
}
