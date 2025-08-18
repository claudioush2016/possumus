package com.backend.numeralconversion.service;

import com.backend.numeralconversion.dto.RomanRequest;
import com.backend.numeralconversion.dto.RomanResponse;
import com.backend.numeralconversion.RomanNumeralConverter;
import org.springframework.stereotype.Service;

@Service
public class RomanService {

    public RomanResponse toRoman(RomanRequest request) {
        return new RomanResponse(RomanNumeralConverter.toRoman(request.value()));
    }

    public RomanResponse toInteger(String roman) {
        return new RomanResponse(String.valueOf(RomanNumeralConverter.toInt(roman)));
    }
}
