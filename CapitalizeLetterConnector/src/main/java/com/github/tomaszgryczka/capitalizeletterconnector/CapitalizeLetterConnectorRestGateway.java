package com.github.tomaszgryczka.capitalizeletterconnector;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class CapitalizeLetterConnectorRestGateway implements CapitalizeLetterConnectorGateway {

    private final RestTemplate restTemplate;
    private final CapitalizeLetterConnectorProperties properties;

    @Override
    public ResponseEntity<CapitalizeLetterResponse> capitalizeLetters(CapitalizeLetterRequest request) {
        return restTemplate.exchange(
                properties.getUrl(),
                HttpMethod.POST,
                new HttpEntity<>(request, createHeaders()),
                CapitalizeLetterResponse.class
        );
    }

    private HttpHeaders createHeaders() {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBasicAuth(properties.getLogin(), properties.getPassword());
        return headers;
    }
}
