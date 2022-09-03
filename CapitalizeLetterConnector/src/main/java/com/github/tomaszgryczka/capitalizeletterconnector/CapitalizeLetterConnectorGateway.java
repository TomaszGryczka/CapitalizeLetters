package com.github.tomaszgryczka.capitalizeletterconnector;

import org.springframework.http.ResponseEntity;

public interface CapitalizeLetterConnectorGateway {
    ResponseEntity<CapitalizeLetterResponse> capitalizeLetters(CapitalizeLetterRequest request);
}
