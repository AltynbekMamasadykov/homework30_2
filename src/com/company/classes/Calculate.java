package com.company.classes;

public class Calculate {


      public  static void calculateRoman(String firstNumber,String secondNumber,String operator) {
          String strResult = "";
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


      public static void calculateArabic(String firstNumber,String secondNumber,String opr){
          String strResult = "";
          int result = 0;
          switch (opr) {
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
          }System.out.println(firstNumber+" "+opr+" "+secondNumber+" = "+result);

      }

    public  static String assignOperator(String str){
        String opr = "";
        if(str.contains("+")){
            opr = "+";
        }else if(str.contains("-")){
            opr = "-";
        }else if(str.contains("*")) {
            opr = "*";
        }else if(str.contains("/")) {
            opr = "/";
        }return opr;
    }

    public static int findIndexOfOperator(String str){
        int oprIndex = -1;
        if(str.contains("+")){
            oprIndex = str.indexOf('+');
        }else if(str.contains("-")){
            oprIndex = str.indexOf('-');
        }else if(str.contains("*")) {
            oprIndex = str.indexOf('*');
        }else if(str.contains("/")) {
            oprIndex = str.indexOf('/');
        }return oprIndex;
    }
}
