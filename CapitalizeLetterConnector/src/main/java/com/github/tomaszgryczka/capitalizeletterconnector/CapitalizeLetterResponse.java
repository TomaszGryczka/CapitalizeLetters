package com.github.tomaszgryczka.capitalizeletterconnector;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;


@Builder
@Jacksonized
public class CapitalizeLetterResponse {
    @JsonProperty(value = "INPUT")
    private String input;

    @JsonProperty(value = "OUTPUT")
    private String output;
}
