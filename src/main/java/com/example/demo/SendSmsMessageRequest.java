package com.example.demo;

import lombok.Getter;

@Getter
public class SendSmsMessageRequest {
    private String sender;
    private String phone;
    private String text;
    private String applicationId;
    private String applicationToken;
    private boolean isCounterPrefix;

    public String getHttpBody() {
        return "{\"sender\":\"" + this.sender + "\",\"message\":\"" + this.text + "\",\"phoneNumbers\":[\"" + this.phone + "\"]}";
    }

    public SendSmsMessageRequest setSender(String sender) {
        this.sender = sender;
        return this;
    }

    public SendSmsMessageRequest setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public SendSmsMessageRequest setText(String text) {
        this.text = text;
        return this;
    }

    public SendSmsMessageRequest setApplicationId(String applicationId) {
        this.applicationId = applicationId;
        return this;
    }

    public SendSmsMessageRequest setApplicationToken(String applicationToken) {
        this.applicationToken = applicationToken;
        return this;
    }

    public SendSmsMessageRequest setCounterPrefix(boolean counterPrefix) {
        isCounterPrefix = counterPrefix;
        return this;
    }
}
