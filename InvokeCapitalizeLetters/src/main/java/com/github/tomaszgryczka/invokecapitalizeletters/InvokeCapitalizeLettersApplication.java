package com.github.tomaszgryczka.invokecapitalizeletters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomaszgryczka.capitalizeletterconnector.CapitalizeLetterConnectorGateway;
import com.github.tomaszgryczka.capitalizeletterconnector.CapitalizeLetterRequest;
import com.github.tomaszgryczka.capitalizeletterconnector.CapitalizeLetterResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.SpringVersion;

@SpringBootApplication(scanBasePackages = {"com.github.tomaszgryczka.capitalizeletterconnector", "com.github.tomaszgryczka.invokecapitalizeletters"})
public class InvokeCapitalizeLettersApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvokeCapitalizeLettersApplication.class, args);
    }
}
