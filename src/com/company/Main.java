package com.company;
import com.company.classes.ArabicToRoman;
import com.company.classes.RomanToArabic;
import com.company.exceptions.EmptyLineException;
import com.company.exceptions.WrongOperatorException;
import com.company.exceptions.WrongTypeException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to basic arithmetic calculator");
            System.out.println("Давай жаз, Маалыматтар бир сапта берилиши керек! " +
                    "Ар бир сан жана арифметикалык операция жаңы сапта берилсе, " +
                    "андай чечимдер жараксыз деп эсептелет." +
                    "\nКалькулятор бир эле учурда араб же рим цифралары менен гана иштей алат");

            String operation = scanner.nextLine();
            if(operation==null || operation.equals("")){
                try {
                    throw new EmptyLineException("Жазбайсынбы, ойундагыны окуйт дейсинби?");
                }catch (EmptyLineException e){
                    System.out.println(e.getMessage());
                    return;
                }
            }

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

            if(!operator.matches(".*[-*/+].*")){
                try {
                    throw new WrongOperatorException("+ - * / эле колдонсо болот, бул арифметический калькулятор");
                }catch (WrongOperatorException e){
                    System.out.println(e.getMessage());
                    return;
                }
            }

            String firstNumber = operation.substring(0,indexOfOperator);
            String secondNumber = operation.substring(indexOfOperator+1);

            if(firstNumber.matches("[A-Z]+") && secondNumber.matches("[A-Z]+")){
                int intFirstNumber = RomanToArabic.convertRomanToArabic(firstNumber);
                int intSecondNumber = RomanToArabic.convertRomanToArabic(secondNumber);
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
                    case "/" -> {
                        try{
                            result = Integer.parseInt(firstNumber) / Integer.parseInt(secondNumber);
                            }catch (ArithmeticException e){
                            System.out.println ("Бовойт! Сандар нолго болунбойт!");
                            return;
                        }
                    }
                }System.out.println(firstNumber+" "+operator+" "+secondNumber+" = "+result);
            } else{
                try {
                    throw new WrongTypeException("Окуганды билесинби? Калькулятор бир эле учурда араб же рим цифралары менен гана иштей алат деп турат ко");
                }catch (WrongTypeException e){
                    System.out.println(e.getMessage());
                }
            }
        }
}
