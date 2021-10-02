import java.util.Scanner;

/**
 * Class SimpleIOMath asks for and returns name, age, and favorite color as well as various simple mathematical things
 * @version 09/28/21
 * @author zja
 */
public class SimpleIOMath {
    private String name;
    private int age;
    private int favNumber;

    private int smallestPrime(int num)  {
        for(int i = 2; i <= (int)(Math.sqrt(num))+1; i++) {
            if (num % i == 0)
                return i;
        }
        return num;
    }

    /**
     * method promptUser() asks user for name, age, and favorite number, stores information
     */
    public void promptUser()  {
        Scanner input = new Scanner(System.in);
        System.out.print("Question 1: What is your name? ");
        name = input.nextLine();
        System.out.print("Question 2: How old are you? ");
        age = input.nextInt();
        System.out.print("Question 3: What is your favorite number? ");
        favNumber = input.nextInt();
    }

    /**
     * method printInfo() prints name, age, and favorite number that user entered, and then finds smallest prime factor and favorite number squared
     */
    public void printInfo()  {
        System.out.println("Your name is: " + name);
        System.out.println("Your age is: " + age);
        System.out.println("At your next birthday, you will turn " + (age+1) + ".");
        System.out.println("The first prime factor of " + (age+1) + " is: " + smallestPrime(age+1) );
        System.out.println("Your favorite number is: " + favNumber);
        System.out.println("Your favorite number squared is: " + favNumber*favNumber);
    }

    /**
     * main entry point; calls 2 other methods and adds necessary text
     * @param args
     */
    public static void main(String[] args)  {
        System.out.println("* Sit yourself down, take a seat *");
        System.out.println("* All you gotta do is repeat after me *");
        SimpleIOMath obj = new SimpleIOMath();
        obj.promptUser();
        System.out.println("I'm gonna teach you how to sing it out");
        System.out.println("Come on, come on, come on");
        System.out.println("Let me tell you what it's all about");
        System.out.println("Reading, writing, arithmetic");
        System.out.println("Are the branches of the learning tree");
        obj.printInfo();
        System.out.println("* end of program *");


    }
}
