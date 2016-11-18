package com.example.core.logical;

//Since 153 = 1*1*1 + 5*5*5 + 3*3*3. So 153 is an Armstrong number
public class Armstrong {

    public static void main(String[] args) {
        System.out.println(validateArmstrong(153));
    }

    private static boolean validateArmstrong(int number) {
        int numeric, remainder, newNumber = 0;
        numeric = number;
        while (numeric != 0) {
            remainder = numeric % 10;
            newNumber = newNumber + remainder * remainder * remainder;
            numeric = numeric / 10;
        }
        if (numeric == number) {
            return true;
        }
        return false;
    }
}
