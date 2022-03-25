package com.company;
import com.company.classes.ArabicToRoman;
import com.company.classes.RomanToArabic;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to basic calculator");
        System.out.println("Давай жаз, Маалыматтар бир сапта берилиши керек! " +
                "Ар бир сан жана арифметикалык операция жаңы сапта берилсе, " +
                "андай чечимдер жараксыз деп эсептелет.");

        String operation = scanner.nextLine();
        int result = 0;
        String strResult = "";
        int indexOfOperator = -1;
        String operator = "";

        if(operation.contains("+")){
            indexOfOperator = operation.indexOf('+');
            operator = "+";
        }else if(operation.contains("-")){
            indexOfOperator = operation.indexOf('-');
            operator = "-";
        }else if(operation.contains("*")) {
            indexOfOperator = operation.indexOf('*');
            operator = "*";
        }else if(operation.contains("/")) {
            indexOfOperator = operation.indexOf('/');
            operator = "/";
        }

        String firstNumber = operation.substring(0,indexOfOperator);
        String secondNumber = operation.substring(indexOfOperator+1);

        if(firstNumber.matches("[A-Z]+") && secondNumber.matches("[A-Z]+")){
            int intFirstNumber = RomanToArabic.covertRomanToArabic(firstNumber);
            int intSecondNumber = RomanToArabic.covertRomanToArabic(secondNumber);
            switch (operator) {
                case "+" -> result = intFirstNumber + intSecondNumber;
                case "-" -> result = intFirstNumber - intSecondNumber;
                case "*" -> result = intFirstNumber * intSecondNumber;
                case "/" -> result = intFirstNumber / intSecondNumber;
            }strResult = ArabicToRoman.convertArabicToRoman(result);
            System.out.println(firstNumber+" "+operator+" "+secondNumber+" = "+strResult);

        }else if(firstNumber.matches("[0-9]+") && secondNumber.matches("[0-9]+")){
            switch (operator) {
            case "+" -> result = Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber);
            case "-" -> result = Integer.parseInt(firstNumber) - Integer.parseInt(secondNumber);
            case "*" -> result = Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber);
            case "/" -> result = Integer.parseInt(firstNumber) / Integer.parseInt(secondNumber);
            }System.out.println(firstNumber+" "+operator+" "+secondNumber+" = "+result);
        }

            else{
                System.out.println("error");
            }


        }

//

}
