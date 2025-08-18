package com.backend.numeralconversion.controller;


import com.backend.numeralconversion.dto.RomanRequest;
import com.backend.numeralconversion.dto.RomanResponse;
import com.backend.numeralconversion.service.RomanService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roman")
public class RomanController {
    private final RomanService romanService;
    public RomanController(RomanService romanService) {
        this.romanService = romanService;
    }

    @GetMapping("/toRoman")
    public RomanResponse toRoman(@RequestParam int value) {
        return romanService.toRoman(new RomanRequest(value));
    }

    @GetMapping("/toInteger")
    public RomanResponse toInteger(@RequestParam String value) {
        return romanService.toInteger(value);
    }
}
