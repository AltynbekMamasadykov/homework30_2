package com.company.classes;

import java.util.HashMap;
import java.util.Map;

public class RomanToArabic {

    private static final Map<Character, Integer> romanToArabicMap = new HashMap<>(7);
    static {
        romanToArabicMap.put('I', 1);
        romanToArabicMap.put('V', 5);
        romanToArabicMap.put('X', 10);
        romanToArabicMap.put('L', 50);
        romanToArabicMap.put('C', 100);
        romanToArabicMap.put('D', 500);
        romanToArabicMap.put('M', 1000);
    }

    public static int convertRomanToArabic(String stringNumber) {
        int sum = 0;
        int len = stringNumber.length() - 1;
        for (int i = 0; i < len; i++) {
            if (romanToArabicMap.get(stringNumber.charAt(i)) < romanToArabicMap.get(stringNumber.charAt(i + 1))) {
                sum -= romanToArabicMap.get(stringNumber.charAt(i));
            } else {
                sum += romanToArabicMap.get(stringNumber.charAt(i));
            }
        }
        return sum += romanToArabicMap.get(stringNumber.charAt(len));
    }
}
