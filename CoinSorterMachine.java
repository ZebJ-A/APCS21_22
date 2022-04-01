import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.io.*;

/**
 * Class CoinSorterMachine takes user input data set of coin values, counts total number of each kind of coin and returns total value of all coins
 * @version 03/31/22
 * @author zja
 */
public class CoinSorterMachine {
    private ArrayList<Coin> coins;
    private ArrayList<Coin> coinMap;
    private int[] typeCounts;

    /**
     * method CoinSorterMachine initializes coins ArrayList
     */
    public CoinSorterMachine() {
        coins = new ArrayList<>();
        coinMap = new ArrayList<Coin>();
        coinMap.add(new Penny());
        coinMap.add(new Nickel());
        coinMap.add(new Dime());
        coinMap.add(new Quarter());
        coinMap.add(new HalfDollar());
        coinMap.add(new Dollar());
        typeCounts = new int[6];

    }
    private Coin makeCoin(double value) {
        for(Coin c : coinMap) {
            if(c.getValue() == value)
                return c;
        }
        return null;
    }

    /**
     * "deposits" coins in ArrayList based on value and resulting name
     */
    public void depositCoins() {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the name of the data file for coin deposit: ");
            String dataFile = in.nextLine();
            in.close();
            System.out.println("Depositing coins...");
            Scanner sc = new Scanner(new File(dataFile));
            while (sc.hasNext()) {
                int value = sc.nextInt();
                Coin c = makeCoin(value/100.);
                if(c == null)
                    System.out.println("Coin value " + value + " not recognized");
                else {
                    if(c instanceof Penny)
                        typeCounts[0]++;
                    else if(c instanceof Nickel)
                        typeCounts[1]++;
                    else if(c instanceof Dime)
                        typeCounts[2]++;
                    else if(c instanceof Quarter)
                        typeCounts[3]++;
                    else if(c instanceof HalfDollar)
                        typeCounts[4]++;
                    else if(c instanceof Dollar)
                        typeCounts[5]++;
                    coins.add(c);

                }
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    /**
     * printDepositSummary prints deposit summary using a DecimalFormat object
     */
    public void printDepositSummary() {
        DecimalFormat df = new DecimalFormat("$0.00");
        System.out.println("Summary of deposit:");
        for(int i = 0; i < typeCounts.length; i++) {
            System.out.println("\t" + typeCounts[i] + " " +
                    ((typeCounts[i] == 1) ? coinMap.get(i).getName() : coinMap.get(i).getPluralName()) +
                    " " + df.format(typeCounts[i]*coinMap.get(i).getValue()));
        }
        System.out.println("TOTAL DEPOSIT: " + df.format(getTotalValue()));
    }

    /**
     *  getTotalValue returns the total value of all Coin objects stored in coins as a double
     */
    public double getTotalValue() {
        double totalVal = 0;
        for(Coin c : coins) {
            totalVal += c.getValue();
        }
        return totalVal;
    }

    /**
     * Main method calls two methods in the class which allow the program to run: depositCoins and printDepositSummary
     * @param args
     */
    public static void main(String[] args) {
        CoinSorterMachine app = new CoinSorterMachine();
        app.depositCoins();
        app.printDepositSummary();
    }
}
