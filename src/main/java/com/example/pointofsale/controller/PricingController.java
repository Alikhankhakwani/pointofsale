package com.example.pointofsale.controller;

import com.example.pointofsale.service.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PricingController {
    @Autowired
    public PricingService pricingService;
}
