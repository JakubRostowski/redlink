package com.example.demo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class SendSmsResponseV1JTO {

    private String description;

    private Long day;

    private Long dayCounter;

    public SendSmsResponseV1JTO(String description, Long day) {
        this.description = description;
        this.day = day;
    }
}
