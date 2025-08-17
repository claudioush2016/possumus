package com.backend.numeralconversion;

import com.backend.numeralconversion.exception.InvalidRomanNumeralException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para Traslator.
 * Se utilizan al menos 2 casos de borde para cada método, además de casos generales.
 */
class RomanNumeralConverterTest {

    private RomanNumeralConverter romanNumeralConverter;

    @BeforeEach
    void setUp() {
        romanNumeralConverter = new RomanNumeralConverter();
    }

    // --- Tests para la conversión de Entero a Romano (toRoman) ---

    @Test
    void testToRoman_SimpleCases() {
        assertEquals("I", romanNumeralConverter.toRoman(1));
        assertEquals("V", romanNumeralConverter.toRoman(5));
        assertEquals("IX", romanNumeralConverter.toRoman(9));
        assertEquals("XXI", romanNumeralConverter.toRoman(21));
        assertEquals("L", romanNumeralConverter.toRoman(50));
        assertEquals("C", romanNumeralConverter.toRoman(100));
        assertEquals("D", romanNumeralConverter.toRoman(500));
        assertEquals("M", romanNumeralConverter.toRoman(1000));
    }

    @Test
    void testToRoman_ComplexCases() {
        assertEquals("LXXXIX", romanNumeralConverter.toRoman(89));
        assertEquals("CMLXXXIX", romanNumeralConverter.toRoman(989));
        assertEquals("MCMLXXXIV", romanNumeralConverter.toRoman(1984));
        assertEquals("MCMXCIX", romanNumeralConverter.toRoman(1999));
        assertEquals("MMMCMXCIX", romanNumeralConverter.toRoman(3999));
    }

    // Casos de Borde para toRoman()
    @Test
    void testToRoman_BorderCase_Min() {
        // El valor mínimo permitido es 1.
        assertEquals("I", romanNumeralConverter.toRoman(1));
    }

    @Test
    void testToRoman_BorderCase_Max() {
        // El valor máximo permitido es 3999.
        assertEquals("MMMCMXCIX", romanNumeralConverter.toRoman(3999));
    }

    @Test
    void testToRoman_InvalidNumber_Zero() {
        // Prueba de excepción para un número no permitido (0).
        assertThrows(InvalidRomanNumeralException.class, () -> romanNumeralConverter.toRoman(0));
    }

    @Test
    void testToRoman_InvalidNumber_Negative() {
        // Prueba de excepción para un número no permitido (negativo).
        assertThrows(InvalidRomanNumeralException.class, () -> romanNumeralConverter.toRoman(-10));
    }

    @Test
    void testToRoman_InvalidNumber_TooLarge() {
        // Prueba de excepción para un número no permitido (mayor a 3999).
        assertThrows(InvalidRomanNumeralException.class, () -> romanNumeralConverter.toRoman(4000));
    }


    // --- Tests para la conversión de Romano a Entero (toInt) ---

    @Test
    void testToInt_SimpleCases() {
        assertEquals(1, romanNumeralConverter.toInt("I"));
        assertEquals(5, romanNumeralConverter.toInt("V"));
        assertEquals(9, romanNumeralConverter.toInt("IX"));
        assertEquals(21, romanNumeralConverter.toInt("XXI"));
        assertEquals(50, romanNumeralConverter.toInt("L"));
        assertEquals(100, romanNumeralConverter.toInt("C"));
        assertEquals(500, romanNumeralConverter.toInt("D"));
        assertEquals(1000, romanNumeralConverter.toInt("M"));
    }

    @Test
    void testToInt_ComplexCases() {
        assertEquals(89, romanNumeralConverter.toInt("LXXXIX"));
        assertEquals(989, romanNumeralConverter.toInt("CMLXXXIX"));
        assertEquals(1984, romanNumeralConverter.toInt("MCMLXXXIV"));
        assertEquals(1999, romanNumeralConverter.toInt("MCMXCIX"));
        assertEquals(3999, romanNumeralConverter.toInt("MMMCMXCIX"));
    }

    // Casos de Borde para toInt()
    @Test
    void testToInt_BorderCase_Min() {
        // Valor mínimo que se puede obtener de la conversión.
        assertEquals(1, romanNumeralConverter.toInt("I"));
    }

    @Test
    void testToInt_BorderCase_Max() {
        // Valor máximo que se puede obtener de la conversión.
        assertEquals(3999, romanNumeralConverter.toInt("MMMCMXCIX"));
    }

    @Test
    void testToInt_InvalidRoman_UnknownSymbol() {
        // Prueba de excepción para un símbolo no válido.
        assertThrows(InvalidRomanNumeralException.class, () -> romanNumeralConverter.toInt("VIIX"));
    }

    @Test
    void testToInt_InvalidRoman_EmptyString() {
        // Prueba de excepción para una cadena vacía.
        assertThrows(InvalidRomanNumeralException.class, () -> romanNumeralConverter.toInt(""));
    }

    @Test
    void testToInt_InvalidRoman_Null() {
        // Prueba de excepción para una cadena nula.
        assertThrows(InvalidRomanNumeralException.class, () -> romanNumeralConverter.toInt(null));
    }

    @Test
    void testToInt_InvalidRoman_InvalidNotation() {
        // Prueba de excepción para una notación romana no válida.
        assertThrows(InvalidRomanNumeralException.class, () -> romanNumeralConverter.toInt("XIXC"));
        assertThrows(InvalidRomanNumeralException.class, () -> romanNumeralConverter.toInt("IIII"));
        assertThrows(InvalidRomanNumeralException.class, () -> romanNumeralConverter.toInt("VV"));
    }
}
