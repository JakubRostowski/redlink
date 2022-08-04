package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

public class Redlink {

    @Autowired
    private SendSmsService sendSmsService;
    private final RequestJTO requestJTO = new RequestJTO()
            .setSender(sender)
            .setPhone(phone)
            .setText("Hello!")
            .setApplicationId(appID)
            .setCounterPrefix(true);

    private final String applicationToken = appToken;

    final SendSmsMessageResponse serviceResponse = sendSmsService.sendSms(
            new SendSmsMessageRequest()
                    .setSender(requestJTO.getSender())
                    .setPhone(requestJTO.getPhone())
                    .setText(requestJTO.getText())
                    .setApplicationId(requestJTO.getApplicationId())
                    .setApplicationToken(applicationToken)
                    .setCounterPrefix(requestJTO.isCounterPrefix())
    );

    final MessageStatus status = serviceResponse.getMessageStatus();

    final SendSmsResponseV1JTO responseJTO = new SendSmsResponseV1JTO(
            status.getDescription(),
            serviceResponse.getData().get(0).getScheduleTime()
    );



}
