package com.company;
import com.company.classes.Calculate;
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

            int indexOfOperator = -1;
            String operator = "";
            operator = Calculate.assignOperator(operation);
            indexOfOperator = Calculate.findIndexOfOperator(operation);


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
                Calculate.calculateRoman(firstNumber,secondNumber,operator);

            //------------------- calculation with arabic numerals --------------------

            }else if(firstNumber.matches("[0-9]+") && secondNumber.matches("[0-9]+")){
                Calculate.calculateArabic(firstNumber,secondNumber,operator);

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
