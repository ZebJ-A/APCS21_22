import java.util.*;
import java.io.*;

/**
 * Class ScrabbleRackManager creates a random tileRack of 7 letters and determines every possible word that can be created using those letters
 * @version 3/25/22
 * @author 23jewell-alibhai
 */
public class ScrabbleRackManager {
    private ArrayList<ArrayList<String>> dictionary;
    private ArrayList<String> tileRack;
    private String alpha;

    /** class constructor */
    public ScrabbleRackManager() {
        alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        dictionary = new ArrayList<ArrayList<String>>();
        for(int i = 0; i < 26; i++)
            dictionary.add(new ArrayList<String>());
        buildDictionary();
        buildTileRack();
    }

    private void buildDictionary() {
        try {
            Scanner filein = new Scanner(new File("2019_collins_scrabble.txt"));
            while(filein.hasNext()) {
                String temp = filein.next();
                dictionary.get(alpha.indexOf(temp.charAt(0))).add(temp);
            }
            filein.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void buildTileRack() {
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        tileRack = new ArrayList<String>();
        int[] frqs = {9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1};
        ArrayList<String> allTiles = new ArrayList<>();
        int index = 0;
        for(int count : frqs) {
            for(int i = 0; i < count; i++) {
                allTiles.add(alpha.substring(index, index + 1));
            }
            index++;
        }
        Collections.shuffle(allTiles);
        for(int i = 0; i < 7; i++) {
            tileRack.add(allTiles.remove((int)(Math.random()*allTiles.size())));
        }

    }
    /** printRack displays the contents of the player's tile rack */
    public void printRack() {
        System.out.println("Letters in your Scrabble rack: " + tileRack);
    }

    /** getPlaylist builds and returns an ArrayList of String objects that are values pulled
     from
     * the dictionary/database based on the available letters in the user's tile
     * rack */
    public ArrayList<String> getPlaylist() {
        ArrayList<String> plays = new ArrayList<>();
        for(ArrayList<String> bucket : dictionary) {
            if(!tileRack.contains(bucket.get(0).substring(0, 1))) {
                continue;
            }
            for(String s : bucket) {
                if(s.length() <= 7 && isPlayable(s))
                    plays.add(s);
            }
        }
        return plays;
    }
    private boolean isPlayable(String word) {
        ArrayList<String> copy = new ArrayList<>(tileRack);
        for(int i = 0; i < word.length(); i++) {
            if(!copy.remove(word.substring(i, i+1)))
                return false;
        }
        return true;
    }
    /** printMatches prints all of the playable words based on the letters in the tile rack */
    public void printMatches() {
        ArrayList<String> plays = getPlaylist();
        boolean bingo = false;
        System.out.println("You can play the following words from the letters in your rack:");
        if(plays.isEmpty())
            System.out.println("Sorry, NO words can be played from those tiles.");
        for(int i = 0; i < plays.size(); i++) {
            String word = plays.get(i);
            if(word.length() == 7) {
                word += "*";
                bingo = true;
            }
            System.out.printf("%-10s", word);
            if((i+1) % 10 == 0)
                System.out.println();
        }
        if(bingo)
            System.out.println("\n* Denotes BINGO");
    }
    /** main method for the class; use only 3 command lines in main */
    public static void main(String[] args){
        ScrabbleRackManager app = new ScrabbleRackManager();
        app.printRack();
        app.printMatches();

    }
}
