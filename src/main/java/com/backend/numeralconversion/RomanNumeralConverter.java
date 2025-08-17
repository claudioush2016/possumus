package com.backend.converter;

import com.backend.converter.exception.InvalidRomanNumeralException;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class RomanNumeralConverter {

    //Diccionario Romano a Int
    private static final LinkedHashMap<String, Integer> romanToIntMap;
    static {
        LinkedHashMap<String, Integer> tempMap = new LinkedHashMap<>();
        tempMap.put("M", 1000);
        tempMap.put("CM", 900);
        tempMap.put("D", 500);
        tempMap.put("CD", 400);
        tempMap.put("C", 100);
        tempMap.put("XC", 90);
        tempMap.put("L", 50);
        tempMap.put("XL", 40);
        tempMap.put("X", 10);
        tempMap.put("IX", 9);
        tempMap.put("V", 5);
        tempMap.put("IV", 4);
        tempMap.put("I", 1);
        romanToIntMap = tempMap;
    }

    private static final Map<Integer, String> intToRomanMap = new LinkedHashMap<>();
    static {
        intToRomanMap.put(1000, "M");
        intToRomanMap.put(900, "CM");
        intToRomanMap.put(500, "D");
        intToRomanMap.put(400, "CD");
        intToRomanMap.put(100, "C");
        intToRomanMap.put(90, "XC");
        intToRomanMap.put(50, "L");
        intToRomanMap.put(40, "XL");
        intToRomanMap.put(10, "X");
        intToRomanMap.put(9, "IX");
        intToRomanMap.put(5, "V");
        intToRomanMap.put(4, "IV");
        intToRomanMap.put(1, "I");
    }


    //  Pattern para verificar que sea un número romano bien escrito
    private static final Pattern ROMAN_NUMERALS_PATTERN = Pattern.compile(
            "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$"
    );

    /**
     * Convierte un número entero a su representación en números romanos.
     *
     * @param number el número entero a convertir. Debe estar en el rango [1, 3999].
     * @return la cadena de texto con el número romano.
     * @throws InvalidRomanNumeralException si el número de entrada no es válido.
     */
    public String toRoman(int number) {
        if (number <= 0 || number > 3999) {
            throw new InvalidRomanNumeralException("El número debe estar entre 1 y 3999.");
        }

        StringBuilder roman = new StringBuilder();
        int tempNumber = number;

        for (Map.Entry<Integer, String> entry : intToRomanMap.entrySet()) {
            int value = entry.getKey();
            String symbol = entry.getValue();
            while (tempNumber >= value) {
                roman.append(symbol);
                tempNumber -= value;
            }
        }
        return roman.toString();
    }

    /**
     * Convierte un número romano a su representación entera.
     *
     * @param roman el número romano a convertir. Debe ser una cadena válida.
     * @return el valor entero.
     * @throws InvalidRomanNumeralException si la cadena de entrada no es un número romano válido.
     */
    public int toInt(String roman) {
        if (roman == null || roman.trim().isEmpty()) {
            throw new InvalidRomanNumeralException("El número romano no puede ser nulo o vacío.");
        }

        String romanCleaned = roman.toUpperCase().trim();
        if (!ROMAN_NUMERALS_PATTERN.matcher(romanCleaned).matches()) {
            throw new InvalidRomanNumeralException("El número romano '" + roman + "' no es una notación válida.");
        }
        int result = 0;
        int i = 0;
        while (i < romanCleaned.length()) {
            String currentSymbol = String.valueOf(romanCleaned.charAt(i));
            if (i + 1 < romanCleaned.length()) {
                String twoSymbols = romanCleaned.substring(i, i + 2);
                if (romanToIntMap.containsKey(twoSymbols)) {
                    result += romanToIntMap.get(twoSymbols);
                    i += 2;
                    continue;
                }
            }
            if (romanToIntMap.containsKey(currentSymbol)) {
                result += romanToIntMap.get(currentSymbol);
                i++;
            } else {
                throw new InvalidRomanNumeralException("Símbolo romano no válido encontrado: " + currentSymbol);
            }
        }
        return result;
    }
}

