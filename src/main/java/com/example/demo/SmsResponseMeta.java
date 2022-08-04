package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SmsResponseMeta {

    private int numberOfErrors;
    private int numberOfData;
    private int status;
    private String uniqId;
}
