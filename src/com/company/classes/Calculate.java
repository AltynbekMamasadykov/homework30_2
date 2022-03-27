package com.company.classes;

public class Calculate {


      public  static void calculateRoman(String firstNumber,String secondNumber,String operator) {
          String strResult;
          int result = 0;
          int intFirstNumber = RomanToArabic.convertRomanToArabic(firstNumber);
          int intSecondNumber = RomanToArabic.convertRomanToArabic(secondNumber);
          switch (operator) {
              case "+" -> result = intFirstNumber + intSecondNumber;
              case "-" -> result = intFirstNumber - intSecondNumber;
              case "*" -> result = intFirstNumber * intSecondNumber;
              case "/" -> result = intFirstNumber / intSecondNumber;
          }
          strResult = ArabicToRoman.convertArabicToRoman(result);
          System.out.println(firstNumber + " " + operator + " " + secondNumber + " = " + strResult);
      }


      public static void calculateArabic(String firstNumber,String secondNumber,String operator){
          int result = 0;
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

      }

    public  static String assignOperator(String str){
        String operator = "";
        if(str.contains("+")){
            operator = "+";
        }else if(str.contains("-")){
            operator = "-";
        }else if(str.contains("*")) {
            operator = "*";
        }else if(str.contains("/")) {
            operator = "/";
        }return operator;
    }

    public static int findIndexOfOperator(String str){
        int indexOfOperator = -1;
        if(str.contains("+")){
            indexOfOperator = str.indexOf('+');
        }else if(str.contains("-")){
            indexOfOperator = str.indexOf('-');
        }else if(str.contains("*")) {
            indexOfOperator = str.indexOf('*');
        }else if(str.contains("/")) {
            indexOfOperator = str.indexOf('/');
        }return indexOfOperator;
    }
}
