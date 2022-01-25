import java.util.*;
import java.io.*;

/**
 * Class ScrabbleScorer takes user input of a word, determines whether valid, and then determines the point score of the word
 * @version 1/24/22
 * @author 23jewell-alibhai
 */
public class ScrabbleScorer {
    private ArrayList<String> dictionary;
    private int[] points = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
    private String alpha;

    /**
     * Method ScrabbleScorer creates new ArrayList called dictionary and implements alpha inside of it
     */
    public ScrabbleScorer() {
        dictionary = new ArrayList<>();
        alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        buildDictionary();
    }

    /**
     * Method buildDictionary finds and implements scrabble word dictionary
     */
    public void buildDictionary() {
        try {
            Scanner rf = new Scanner(new File("SCRABBLE_WORDS.txt"));
            while(rf.hasNext()) {
                dictionary.add(rf.nextLine());
            }

            rf.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        Collections.sort(dictionary);
    }

    /**
     * Method isValidWord returns whether user word is a valid word in the scrabble dictionary
     * @param word
     * @return
     */
    public boolean isValidWord(String word) {
        return Collections.binarySearch(dictionary, word) >= 0;
    }

    /**
     * Method getWordScore finds the point value for each character in a string based on the values in array points[]
     * @param word
     * @return
     */
    public int getWordScore(String word) {
        int sum = 0;
        for(int i = 0; i < word.length(); i++) {
            sum += points[alpha.indexOf(word.charAt(i))];
        }
        return sum;
    }

    /**
     * Main method takes user input, determines the point value of the word entered if it is a valid word
     * @param args
     */
    public static void main(String[] args) {
        ScrabbleScorer app = new ScrabbleScorer();
        String userWord;
        Scanner userIn = new Scanner(System.in);
        System.out.println("* Welcome to the Scrabble Word Scorer app *");
        try {
            while(true) {
                System.out.println("Enter a word to score or 0 to quit: ");
                userWord = userIn.nextLine();
                if(userWord.equals("0"))
                    break;
                else {
                    if(app.isValidWord(userWord.toUpperCase())) {
                        System.out.println(userWord.toUpperCase() + " = " + app.getWordScore(userWord.toUpperCase()) + " points");
                    }
                    else {
                        System.out.println(userWord.toUpperCase() + " is not a valid word in the dictionary");
                    }
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("Exiting the program thanks for playing");
    }
}
