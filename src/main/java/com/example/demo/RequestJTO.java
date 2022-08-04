package com.example.demo;

import lombok.Getter;

@Getter
public class RequestJTO {

    private String sender;
    private String phone;
    private String text;
    private String applicationId;
    private boolean counterPrefix;

    public RequestJTO setSender(String sender) {
        this.sender = sender;
        return this;
    }

    public RequestJTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public RequestJTO setText(String text) {
        this.text = text;
        return this;
    }

    public RequestJTO setApplicationId(String applicationId) {
        this.applicationId = applicationId;
        return this;
    }

    public RequestJTO setCounterPrefix(boolean counterPrefix) {
        this.counterPrefix = counterPrefix;
        return this;
    }
}
