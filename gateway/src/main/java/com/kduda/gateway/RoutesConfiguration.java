package com.kduda.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
class RoutesConfiguration {
    @Bean
    public RouteLocator locator(RouteLocatorBuilder builder) {
        return builder.routes().route("auctions", route -> route.path("/auctions/**").uri("lb://auctions"))
                .build();
    }
}
