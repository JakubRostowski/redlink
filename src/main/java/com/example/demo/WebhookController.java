package com.example.demo;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebhookController {

    @PutMapping("/update")
    public void updateSmsStatus(@RequestBody SmsStatusUpdate smsStatusUpdate) {

    }
}
