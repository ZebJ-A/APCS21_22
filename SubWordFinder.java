import java.util.*;
import java.io.*;

/**
 * Class SubWordFinder finds all words with 2 words within them within an ArrayList of words
 * @author zjewell-alibhai
 * @version 02/01/22
 */

public class SubWordFinder implements WordFinder {
    private ArrayList<ArrayList<String>> dictionary;
    private String alpha = "abcdefghijklmnopqrstuvwxyz";

    /**
     * Method SubWordFinder defines dictionary, then populates the dictionary with 26 ArrayLists (1 for each letter)
     */
    public SubWordFinder() {
        dictionary = new ArrayList<>();
        for(int i = 0; i < 26; i++) {
            dictionary.add(new ArrayList<String>());
        }
        populateDictionary();
    }

    /**
     * Method populateDictionary() opens file of words and populates dictionary with every word
     */
    public void populateDictionary() {
        try {
            Scanner in = new Scanner(new File("words_all_os.txt"));
            while(in.hasNext()) {
                String word = in.nextLine();
                dictionary.get(alpha.indexOf(word.charAt(0))).add(word);
            }
            in.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    private int indexOf(ArrayList<String> bucket, String word) {
        int index = alpha.indexOf(word.charAt(0));
        bucket = dictionary.get(index);
        int left = 0, right = bucket.size() - 1;
        while (left <= right) {
            for (int i = 0; i < bucket.size() - 1; i++) {
                int mid = left + (right - left) / 2;
                if (bucket.get(i).equals(word))
                    return mid;
                if (bucket.get(i).compareTo(bucket.get(mid)) > 0)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }


    /**
     * Method inDictionary determines whether a word is in the dictionary using a user-created binary search method
     * @param word The item to be searched for in dictionary
     * @return
     */
    public boolean inDictionary(String word) {
        int index = alpha.indexOf(word.charAt(0));
        ArrayList<String> bucket = dictionary.get(index);
        return indexOf(bucket, word) >= 0;
    }

    /**
     * Method getSubWords parses through every word in the dictionary to find if it is a subword
     * @return
     */
    public ArrayList<SubWord> getSubWords() {
        ArrayList<SubWord> subwords = new ArrayList<>();
        for(ArrayList<String> bucket : dictionary) {
            for(String word : bucket) {
                for(int i = 3; i < word.length()-2; i++) {
                    if(inDictionary(word.substring(0, i)))
                        if(inDictionary(word.substring(i)))
                            subwords.add(new SubWord(word, word.substring(0, i), word.substring(i)));

                }
            }
        }

        return subwords;
    }

    /**
     * Main method prints subwords with each word as well as the number of subwords in dictionary
     * @param args
     */
    public static void main(String[] args) {
        SubWordFinder app = new SubWordFinder();
        int count = 0;
        for(SubWord a: app.getSubWords()) {
            System.out.println(a);
            count++;
        }
        System.out.println("There are " + count + " subwords");
    }
}
