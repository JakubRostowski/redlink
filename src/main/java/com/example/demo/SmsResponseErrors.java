package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SmsResponseErrors {

    private String title;
    private String message;
    private String code;
}
