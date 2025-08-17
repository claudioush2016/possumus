package org.example;

import com.backend.numeralconversion.RomanNumeralConverter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean continue_program = true;
        Scanner scanner = new Scanner(System.in);

        RomanNumeralConverter romanNumeralConverter = new RomanNumeralConverter();
        while(continue_program) {
            System.out.println("Elija una opción para continuar? \n 1)Convertir de entero a romano \n 2)Convertir de romano a entero");
            int op = scanner.nextInt();
            switch (op) {
                case 1: {
                    System.out.println("Ingrese el número entero para convertirlo a número Romano entre 1 y 3999");
                    int number =  scanner.nextInt();
                    System.out.println("El numero " + number + " es " + romanNumeralConverter.toRoman(number) + " en romano");
                    break;

                }
                case 2:{
                    System.out.println("Ingrese el número romano para convertirlo a número decimal entre I y MMMCMXCIX");
                    String roman =  scanner.next();
                    System.out.println("El numero " + roman + " es " + romanNumeralConverter.toInt(roman) + " en decimal");
                    break;

                }
                default: {
                    continue_program = false;
                    scanner.close();
                    break;
                }
            }
        }
    }
}