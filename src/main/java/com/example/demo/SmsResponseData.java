package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SmsResponseData {

    private String sender;
    private String message;
    private String phoneNumber;
    private long scheduleTime;
    private int type;
    private boolean shortLink;
    private String externalId;
    private int status;
    private int statusTime;
    private int createTime;
    private int smsPrice;
    private int currency;
    private int numberOfParts;
    private int encoding;
}
