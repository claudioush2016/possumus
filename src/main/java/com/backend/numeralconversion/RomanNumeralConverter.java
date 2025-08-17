package com.backend.numeralconversion;

import com.backend.numeralconversion.exception.InvalidRomanNumeralException;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class RomanNumeralConverter {

    private static final LinkedHashMap<String, Integer> ROMAN_VALUES = new LinkedHashMap<>();
    static {
        ROMAN_VALUES.put("M", 1000);
        ROMAN_VALUES.put("CM", 900);
        ROMAN_VALUES.put("D", 500);
        ROMAN_VALUES.put("CD", 400);
        ROMAN_VALUES.put("C", 100);
        ROMAN_VALUES.put("XC", 90);
        ROMAN_VALUES.put("L", 50);
        ROMAN_VALUES.put("XL", 40);
        ROMAN_VALUES.put("X", 10);
        ROMAN_VALUES.put("IX", 9);
        ROMAN_VALUES.put("V", 5);
        ROMAN_VALUES.put("IV", 4);
        ROMAN_VALUES.put("I", 1);
    }

    //  Pattern para verificar que sea un número romano bien escrito
    private static final Pattern ROMAN_PATTERN = Pattern.compile(
            "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$"
    );

    /*
     * Pasa un número decimal a número Romano
    **/
    public String toRoman(int number) {
        if (number <= 0 || number > 3999) {
            throw new InvalidRomanNumeralException("Número fuera de rango [1, 3999]");
        }

        StringBuilder result = new StringBuilder();
        int remaining = number;

        for (Map.Entry<String, Integer> entry : ROMAN_VALUES.entrySet()) {
            while (remaining >= entry.getValue()) {
                result.append(entry.getKey());
                remaining -= entry.getValue();
            }
        }
        return result.toString();
    }
    /*
     * Pasa un número Romano a número Decimal
     **/
    public int toInt(String roman) {
        if (roman == null || roman.trim().isEmpty()) {
            throw new InvalidRomanNumeralException("Entrada nula o vacía");
        }

        String cleaned = roman.toUpperCase().trim();
        if (!ROMAN_PATTERN.matcher(cleaned).matches()) {
            throw new InvalidRomanNumeralException("Formato romano inválido con los símbolos permitidos");
        }

        int result = 0;
        int i = 0;

        while (i < cleaned.length()) {
            if (i + 1 < cleaned.length() && ROMAN_VALUES.containsKey(cleaned.substring(i, i + 2))) {
                result += ROMAN_VALUES.get(cleaned.substring(i, i + 2));
                i += 2;
            } else {
                result += ROMAN_VALUES.get(cleaned.substring(i, i + 1));
                i++;
            }
        }
        return result;
    }
}

