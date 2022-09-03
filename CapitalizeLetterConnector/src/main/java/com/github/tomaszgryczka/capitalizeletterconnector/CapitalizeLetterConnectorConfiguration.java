package com.github.tomaszgryczka.capitalizeletterconnector;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Collections;

@Configuration
@ComponentScan
@RequiredArgsConstructor
@EnableConfigurationProperties(CapitalizeLetterConnectorProperties.class)
public class CapitalizeLetterConnectorConfiguration {
    private final CapitalizeLetterConnectorProperties properties;

    private static final Logger logger = LoggerFactory.getLogger(CapitalizeLetterConnectorConfiguration.class);

    @Bean
    public RestTemplate createRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(requestFactory());
        restTemplate.setInterceptors(Collections.singletonList((request, body, execution) -> {
            logger.info(new String(body, StandardCharsets.UTF_8));
            ClientHttpResponse response = execution.execute(request, body);
            logger.info(new String(response.getBody().readAllBytes(), StandardCharsets.UTF_8));
            return response;
        }));
        return restTemplate;
    }

    private ClientHttpRequestFactory requestFactory() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(properties.getReadTimeout());
        requestFactory.setConnectTimeout(properties.getConnectionTimeout());
        requestFactory.setOutputStreaming(false);
        return new BufferingClientHttpRequestFactory(requestFactory);
    }
}
