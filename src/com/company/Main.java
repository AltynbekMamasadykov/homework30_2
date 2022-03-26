package com.company;
import com.company.classes.ArabicToRoman;
import com.company.classes.RomanToArabic;
import com.company.exceptions.EmptyLineException;
import com.company.exceptions.WrongOperatorException;
import com.company.exceptions.WrongTypeException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

            //---------------------- printing greeting -------------

            System.out.println("Welcome to basic arithmetic calculator");
            System.out.println("Давай жаз, Маалыматтар бир сапта берилиши керек! " +
                    "Ар бир сан жана арифметикалык операция жаңы сапта берилсе, " +
                    "андай чечимдер жараксыз деп эсептелет." +
                    "\nКалькулятор бир эле учурда араб же рим цифралары менен гана иштей алат");

            //--------------- checking if entered line is empty ------------

            Scanner scanner = new Scanner(System.in);
            String operation = scanner.nextLine();
            if(operation==null || operation.equals("")){
                try {
                    throw new EmptyLineException("Жазбайсынбы, ойундагыны окуйт дейсинби?");
                }catch (EmptyLineException e){
                    System.out.println(e.getMessage());
                    return;
                }
            }

            //---------------------- declaration & initialization -------------

            int result = 0;
            String strResult = "";
            int indexOfOperator = -1;
            String operator = "";

            //-------------------- assigning operator -------------------------

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

            //-------------------- checking for valid operator -------------------

            if(!operator.matches(".*[-*/+].*")){
                try {
                    throw new WrongOperatorException("+ - * / эле колдонсо болот, бул арифметический калькулятор");
                }catch (WrongOperatorException e){
                    System.out.println(e.getMessage());
                    return;
                }
            }

            //----------------- getting values of first and second operand --------

            String firstNumber = operation.substring(0,indexOfOperator);
            String secondNumber = operation.substring(indexOfOperator+1);


            //---------------- calculation with roman numerals ---------------------

            if(firstNumber.matches(".*[IVXLCDM].*") && secondNumber.matches(".*[IVXLCDM].*")){
                int intFirstNumber = RomanToArabic.convertRomanToArabic(firstNumber);
                int intSecondNumber = RomanToArabic.convertRomanToArabic(secondNumber);
                switch (operator) {
                    case "+" -> result = intFirstNumber + intSecondNumber;
                    case "-" -> result = intFirstNumber - intSecondNumber;
                    case "*" -> result = intFirstNumber * intSecondNumber;
                    case "/" -> result = intFirstNumber / intSecondNumber;
                }strResult = ArabicToRoman.convertArabicToRoman(result);
                System.out.println(firstNumber+" "+operator+" "+secondNumber+" = "+strResult);

            //------------------- calculation with arabic numerals --------------------

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

            //------------------- checking if wrong type entered ---------------------

            } else{
                try {
                    throw new WrongTypeException("Окуганды билесинби? Калькулятор бир эле учурда араб же рим " +
                            "цифралары менен гана иштей алат деп турат ко");
                }catch (WrongTypeException e){
                    System.out.println(e.getMessage());
                }
            }
        }
}
