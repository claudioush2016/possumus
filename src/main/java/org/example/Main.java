package org.example;

import com.backend.numeralconversion.RomanNumeralConverter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean continueProgram = true;
        Scanner scanner = new Scanner(System.in);
        RomanNumeralConverter converter = new RomanNumeralConverter();

        while (continueProgram) {
            System.out.println("\n=======================================");
            System.out.println("Elija una opción para continuar:");
            System.out.println("1) Convertir de entero a romano");
            System.out.println("2) Convertir de romano a entero");
            System.out.println("Otro) Salir");
            System.out.println("=======================================");
            System.out.print("Opción: ");

            String input = scanner.nextLine();
            switch (input) {
                case "1": {
                    System.out.print("Ingrese un número entero entre 1 y 3999: ");
                    try {
                        int number = Integer.parseInt(scanner.nextLine());
                        String roman = converter.toRoman(number);
                        System.out.println("Resultado: " + number + " → " + roman);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Debe ingresar un número válido.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    waitEnter(scanner);
                    break;
                }
                case "2": {
                    System.out.print("Ingrese un número romano (I - MMMCMXCIX): ");
                    String romanInput = scanner.nextLine().toUpperCase();
                    try {
                        int result = converter.toInt(romanInput);
                        System.out.println("Resultado: " + romanInput + " → " + result);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    waitEnter(scanner);
                    break;
                }
                default: {
                    continueProgram = false;
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                }
            }
        }
        scanner.close();
    }

    // Método para pausar hasta que el usuario presione Enter
    private static void waitEnter(Scanner scanner) {
        System.out.println("\nPresione Enter para continuar...");
        scanner.nextLine();
    }
}
