package com.github.tomaszgryczka.invokecapitalizeletters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomaszgryczka.capitalizeletterconnector.CapitalizeLetterConnectorGateway;
import com.github.tomaszgryczka.capitalizeletterconnector.CapitalizeLetterRequest;
import com.github.tomaszgryczka.capitalizeletterconnector.CapitalizeLetterResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyService {

    private static final Logger logger = LoggerFactory.getLogger(InvokeCapitalizeLettersApplication.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private final CapitalizeLetterConnectorGateway capitalizeLetterConnectorGateway;

    @EventListener(ApplicationStartedEvent.class)
    public void testRestTemplateConnector() throws JsonProcessingException {
        logger.info(SpringVersion.getVersion());

        CapitalizeLetterRequest request = CapitalizeLetterRequest.builder()
                .input("hello my friend")
                .build();

        logger.info(objectMapper.writeValueAsString(request));

        CapitalizeLetterResponse response = capitalizeLetterConnectorGateway.capitalizeLetters(request).getBody();

        logger.info(objectMapper.writeValueAsString(response));
    }
}
