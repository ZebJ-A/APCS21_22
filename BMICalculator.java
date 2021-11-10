import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Class BMICalculator takes user input of height and weight and calculates BMI
 * @version 11/9/21
 * @author zja
 */
public class BMICalculator {
    /** Convert English to metric units, perform the BMI calculation.
     * NOTE: this method must properly handle bad data */
    public static double computeBMI(int inches, int pounds) {
        if(inches <= 0 || pounds <= 0)
            return 0;
        return pounds*.454 / Math.pow(inches*.0254, 2);
    }

    /**
     * extractInches uses parseInt method to derive the total number of inches from the quotation form
     */
    public static int extractInches(String value) {
        int qtPos = value.indexOf("'");
        int dblQtPos = value.indexOf("\"");
        if (qtPos == -1 || dblQtPos == -1) {
            return -1;
        }
        int feet = Integer.parseInt(value.substring(0, qtPos));
        int inches = Integer.parseInt(value.substring(qtPos + 1, dblQtPos));
        if (inches < 0 || inches > 11 || feet < 0) {
            return -1;
        }
        return (feet * 12 + inches == 0) ? -1 : feet * 12 + inches;
    }

    /** Uses a Scanner to prompt the user for info, processes the feet/inches conversion,
     * calls the computeBMI method and prints the correct info */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        while(true) {
            try {
                System.out.print("Enter your height in feet and inches (ex: 6'1\"): ");
                String height = in.nextLine();
                int inches = extractInches(height);
                System.out.print("Enter your weight in pounds: ");
                String weight = in.nextLine();
                int pounds = Integer.parseInt(weight);
                System.out.println("Your BMI is: " + df.format(computeBMI(inches, pounds)));
                System.out.print("Continue? Y/N: ");
                String cont = in.nextLine();
                if (!cont.toLowerCase().equals("y"))
                    break;
            }
            catch(Exception e) {
                System.out.println("Looks like you entered invalid data. Please try again.");
                    continue;
            }
        }
        System.out.println("End of program");
    }
}
