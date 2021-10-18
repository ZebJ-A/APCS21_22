import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Class RomanToDecimal takes Roman args, converts to decimal or prints logically incorrect or invalid input
 * @version 10/16/21
 * @author zja
 */
public class RomanToDecimal {
    //left in for future reference
    /*public static int romantoDecimalUsingLookupTables(String roman) {
        int decimal = 0;
        roman = roman,toUpperCase();
        String[] letters = {"I", "V", "X", "L", "C", "D", "M"};
        List<String> letterList = new ArrayList<>(Arrays.asList(letters));
        int[] values = {1, 5, 10, 50, 100, 500, 1000};
        for (int i = 0; i < roman.length(); i++) {
            String let = roman.substring(i, i + 1);
            if(letterList.indexOf(let) == -1)
                return -1;
            else
                decimal += values[letterList.indexOf(let)];
        }
        //INVARIANTS
        String subRoman = roman;
        String[] invariants = {"IV", "IX", "XL", "XC", "CD", "CM"};
        int[] deductions = {-2, -2, -20, -20, -200, -200};
        for(int i = 0; i < invariants.length(); i++}  {
            if(roman.indexOf(invariants[i] != -1)  {
            decimal -= deductions[i]
            }
        }
        return decimal;
     */

    /**
     * boolean isLogicallyValid determines whether args that include roman characters are valid
     * @param roman
     * @param decimal
     * @return
     */
    public static boolean isLogicallyValid(String roman, int decimal)  {
        roman = roman.toUpperCase();
        String newRoman = "";
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        //System.out.print("DEBUG:" + decimal + " new: ");
        for(int i = 0; i < values.length; i++) {
            while (decimal >= values[i]) {
                newRoman += romans[i];
                decimal -= values[i];
            }
        }
            return newRoman.equals(roman);
    }

    /**
     * romanToDecimal method converts roman args into decimal
     * @param roman
     * @return
     */
    public static int romanToDecimal(String roman)  {
        int decimal = 0;
        roman = roman.toUpperCase();
        for(int i = 0; i < roman.length(); i++)  {
            String let = roman.substring(i, i+1);
            //System.out.print(roman.substring(i, i+1).toUpperCase());
            if(let.equals("I"))  {
                decimal += 1;
            }
            else if (let.equals("V"))  {
                decimal += 5;
            }
            else if (let.equals("X")) {
                decimal += 10;
            }
            else if (let.equals("L")) {
                decimal += 50;
            }
            else if (let.equals("C")) {
                decimal += 100;
            }
            else if (let.equals("D")) {
                decimal += 500;
            }
            else if (let.equals("M"))  {
                    decimal += 1000;
            }
            else  {
                // the program encountered an invalid number
                return -1;
            }
        }

        if(roman.toUpperCase().indexOf("IV") != -1)
            decimal -= 2;
        if(roman.toUpperCase().indexOf("IX") != -1)
            decimal -= 2;
        if(roman.toUpperCase().indexOf("XL") != -1)
            decimal -= 20;
        if(roman.toUpperCase().indexOf("XC") != -1)
            decimal -= 20;
        if(roman.toUpperCase().indexOf("CD") != -1)
            decimal -= 200;
        if(roman.toUpperCase().indexOf("CM") != -1)
            decimal -= 200;
        return decimal;
    }


    /**
     * Main entry point
     * Uses xor gate to determine scenarios
     * @param args
     */
    public static void main(String[] args)  {
        for(String temp : args) {
            int val = romanToDecimal(temp);
            if (val == -1)
                System.out.println("Input: " + temp + " ==> output: invalid");
            else if (isLogicallyValid(temp, val))
                System.out.println("Input: " + temp + " ==> output: " + val);
            else
                System.out.println("Input: " + temp + " ==> output: logically incorrect ");
        }
    }
}
