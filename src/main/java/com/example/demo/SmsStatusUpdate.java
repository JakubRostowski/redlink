package com.example.demo;

import lombok.Getter;

@Getter
public class SmsStatusUpdate {

    private String externalId;
    private int status;
    private String statusDesc;
    private String statusTime;
    private String webhookUrl;
}
