package com.example.demo;

import com.google.gson.Gson;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.springframework.stereotype.Service;

@Service
public class SendSmsService {

    private final Gson gson = new Gson();

    @CircuitBreaker(name = "smsService")
    @Retry(name = "smsService")
    @TimeLimiter(name = "smsService")
    public SendSmsMessageResponse sendSms(SendSmsMessageRequest request) {
        HttpResponse<String> response = Unirest
                .post("https://api.redlink.pl/v2/sms")
                .header("content-type", "application/json")
                .header("Application-Key", request.getApplicationId())
                .header("Authorization", request.getApplicationToken())
                .body(request.getHttpBody())
                .asString();

        return mapToSendSmsMessageResponse(response);
    }

    private SendSmsMessageResponse mapToSendSmsMessageResponse(HttpResponse<String> response)
    {
        SendSmsMessageResponse sendSmsMessageResponse = gson.fromJson(response.getBody(), SendSmsMessageResponse.class);
        if (sendSmsMessageResponse.getMeta().getStatus() == 200) {
            throw new RuntimeException("An error has occurred: " + sendSmsMessageResponse.getMeta().toString());
        }
        return sendSmsMessageResponse;
    }
}
