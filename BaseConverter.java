import java.util.Scanner;
import java.io.*;

/**
 * BaseConverter opens a data file, reads a nd converts numbers, prints
 * @version 11/18/21
 * @author zja
 */
public class BaseConverter {
    /**
     * Constructor for class.
     */
    public BaseConverter() {

    }
    // Convert a String num in fromBase to base-10 int.

    /**
     * Converts original input from string values to int values in base 10
     * @param num
     * @param fromBase
     * @return
     */
    public int strToInt(String num, String fromBase) {
        int base = Integer.parseInt(fromBase);
        String alpha = "0123456789ABCDEF";
        int sum = 0, exp = 0;
        for(int i = num.length()-1; i >= 0; i--) {
            sum += alpha.indexOf(num.charAt(i)) * Math.pow(base, exp);
            exp ++;
        }
        return sum;
    }
    // Convert a base-10 int to a String number of base toBase.

    /**
     * Converts base 10 converted input back to string values to be returned
     * @param num
     * @param toBase
     * @return
     */
    public String intToStr(int num, int toBase) {
        String alpha = "0123456789ABCDEF";
        String toNum = "";
        while(num > 0) {
            toNum = alpha.charAt(num % toBase) + toNum;
            num /= toBase;
        }
        if(toNum.equals(""))
            return "0";
        return toNum;
    }

    /** Opens the file stream, inputs data one line at a time, converts, prints
     * the result to the console window and writes data to the output stream.
     */
    public void inputConvertPrintWrite() {
        Scanner sc = null;
        PrintWriter pw = null;
        try {
            sc = new Scanner(new File("datafiles/values30.dat"));
            pw = new PrintWriter(new File("datafiles/converted.dat"));
            while (sc.hasNext()) {
                String[] line = sc.nextLine().split("\t");
                int fromBase =  Integer.parseInt(line[1]);
                int toBase = Integer.parseInt(line[2]);
                if(fromBase < 2 || fromBase > 16) {
                    System.out.println("Invalid input base " + fromBase);
                }
                else if(toBase < 2 || toBase > 16) {
                    System.out.println("Invalid output base " + toBase);
                }
                else {
                    System.out.println(line[0] + " base " + line[1] + " = " + intToStr(strToInt(line[0], line[1]), toBase) + " base " + line[2]);
                    pw.println(line[0] + "\t" + line[1] + "\t" + intToStr(strToInt(line[0], line[1]), toBase) + "\t" + line[2]);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if(sc != null)
            sc.close();
        if(pw != null)
            pw.close();
    }

    /**
     * Main method for class BaseConverter
     * @param args command line arguments, if needed
     */
    public static void main(String[] args) {
        BaseConverter app = new BaseConverter();
        app.inputConvertPrintWrite();
    }
}
