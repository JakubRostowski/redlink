package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {SendSmsService.class})
public class SendSmsTest {

    @Autowired
    SendSmsService sendSmsService;

    @Test
    public void shouldReceive200() {
        SendSmsMessageRequest request = new SendSmsMessageRequest();
        request
                .setApplicationId(appId)
                .setApplicationToken(appToken)
                .setSender(sender)
                .setText("Hello!")
                .setPhone(phone);

        SendSmsMessageResponse response = sendSmsService.sendSms(request);

        assertEquals(200, response.getMeta().getStatus());
        assertEquals(0, response.getMeta().getNumberOfErrors());
    }

    @Test
    public void shouldGetHttpBody() {
        SendSmsMessageRequest request = new SendSmsMessageRequest();
        request
                .setSender("Test Sender")
                .setPhone("+48111222333")
                .setText("Text");

        assertEquals("{\"sender\":\"Test Sender\",\"message\":\"Text\",\"phoneNumbers\":[\"+48111222333\"]}", request.getHttpBody());
    }

    @Test
    public void shouldGetSentMessageStatus() {
        SendSmsMessageResponse response = new SendSmsMessageResponse();
        SmsResponseData data = new SmsResponseData();
        data.setStatus(1);
        response.setData(List.of(data));

        MessageStatus status = response.getMessageStatus();

        Assertions.assertEquals(1, status.getStatus());
        Assertions.assertEquals("sent", status.getDescription());
    }
}
