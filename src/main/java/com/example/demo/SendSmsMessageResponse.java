package com.example.demo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SendSmsMessageResponse {

    private SmsResponseMeta meta;
    private List<SmsResponseData> data;
    private List<SmsResponseErrors> errors;

    public MessageStatus getMessageStatus() {
        int code = this.data.get(0).getStatus();
        String description = "";

        switch(code) {
            case 1:
                description = "new";
            case 2:
                description = "move to send";
            case 9:
                description = "rejected";
            case 21:
                description = "sent";
        }
        return new MessageStatus(code, description);
    }
}
