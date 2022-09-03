package com.github.tomaszgryczka.capitalizeletterconnector;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Validated
@ConfigurationProperties(prefix = "capitalize.letter.service")
public class CapitalizeLetterConnectorProperties {
    @NotBlank
    private String url;

    private int readTimeout = 1000;
    private int connectionTimeout = 5000;

    @NotBlank
    private String login;
    @NotBlank
    private String password;
}
