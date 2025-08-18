package com.backend.numeralconversion.controller;

import com.backend.numeralconversion.dto.ErrorResponse;
import com.backend.numeralconversion.dto.RomanResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RomanControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    // ===== Casos válidos =====
    @Test
    void testToRomanEndpoint_Valid() {
        ResponseEntity<RomanResponse> response =
                restTemplate.getForEntity("/api/roman/toRoman?value=21", RomanResponse.class);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody().roman()).isEqualTo("XXI");
    }

    @Test
    void testToIntegerEndpoint_Valid() {
        ResponseEntity<RomanResponse> response =
                restTemplate.getForEntity("/api/roman/toInteger?value=XXI", RomanResponse.class);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody().roman()).isEqualTo("21");
    }

    // ===== Casos inválidos =====
    @Test
    void testToIntegerEndpoint_InvalidSymbol() {
        ResponseEntity<ErrorResponse> response =
                restTemplate.getForEntity("/api/roman/toInteger?value=@", ErrorResponse.class);

        assertThat(response.getStatusCodeValue()).isEqualTo(400);
        assertThat(response.getBody().code()).isEqualTo("INVALID_ROMAN");
        assertThat(response.getBody().message()).contains("Formato romano inválido");
    }

    @Test
    void testToRomanEndpoint_OutOfRange() {
        ResponseEntity<ErrorResponse> response =
                restTemplate.getForEntity("/api/roman/toRoman?value=4000", ErrorResponse.class);

        assertThat(response.getStatusCodeValue()).isEqualTo(400);
        assertThat(response.getBody().code()).isEqualTo("INVALID_ROMAN");
        assertThat(response.getBody().message()).contains("Número fuera de rango");
    }

    // ===== Casos límite =====
    @Test
    void testToRomanEndpoint_Zero() {
        ResponseEntity<ErrorResponse> response =
                restTemplate.getForEntity("/api/roman/toRoman?value=0", ErrorResponse.class);

        assertThat(response.getStatusCodeValue()).isEqualTo(400);
        assertThat(response.getBody().code()).isEqualTo("INVALID_ROMAN");
        assertThat(response.getBody().message()).contains("Número fuera de rango");
    }

    @Test
    void testToRomanEndpoint_Negative() {
        ResponseEntity<ErrorResponse> response =
                restTemplate.getForEntity("/api/roman/toRoman?value=-5", ErrorResponse.class);

        assertThat(response.getStatusCodeValue()).isEqualTo(400);
        assertThat(response.getBody().code()).isEqualTo("INVALID_ROMAN");
        assertThat(response.getBody().message()).contains("Número fuera de rango");
    }
}
