package com.github.tomaszgryczka.capitalizeletterconnector;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CapitalizeLetterRequest {
    String input;
}
