package com.apigateway.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {


    @GetMapping("/userServiceFallBack")
    public String userServiceFallback()
    {
        return "User service is down at this time...!!!!!";
    }
    @GetMapping("/contactServiceFallBack")
    public String contactServiceFallback()
    {
        return "Contact service is down at this time...!!!!!";
    }
    @GetMapping("/catalogServiceFallBack")
    public String catalogServiceFallback()
    {
        return "User catalogService is down at this time...!!!!!";
    }
    @GetMapping("/inventoryServiceFallBack")
    public String inventoryServiceFallback()
    {
        return "User inventory Service is down at this time...!!!!!";
    }


    @GetMapping("/cartServiceFallBack")
    public String cartServiceFallback()
    {
        return "User cart Service is down at this time...!!!!!";
    }
    @GetMapping("/ordersServiceFallBack")
    public String ordersServiceFallback()
    {
        return "User order Service is down at this time...!!!!!";
    }
    @GetMapping("/customersServiceFallBack")
    public String customersServiceFallback()
    {
        return "User customer Service is down at this time...!!!!!";
    }

}
