import java.util.*;
import java.io.File;

/**
 * Class TrailDatabase takes data from App trail database and sorts it based on user decisions as to what value it is sorted by
 * @version 04/29/22
 * @author zja
 */
public class TrailDatabase {
    private ArrayList<Waypoint> database;
    private int searchTerm;
    private boolean asc;

    /**
     * defines database as ArrayList and populates database with data from given file
     */
    public TrailDatabase() {
        database = new ArrayList();
        populateDatabase();

    }

    /**
     * Imports all data out of the app trail file
     */
    public void populateDatabase() {
        try {
            Scanner in = new Scanner(new File("apptrailDB.txt"));
            while(in.hasNext()) {
                String[] line = in.nextLine().split("\t");
                database.add(new Waypoint(line[0], line[1], line[2], Double.parseDouble(line[5]), Double.parseDouble(line[6]), Integer.parseInt(line[7])));
            }
            in.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        Collections.sort(database);
    }

    /**
     * Uses user-defined input to determine which value or string the database should be sorted by
     */
    public void getSearchTerm() {
        System.out.println("+ Menu of search terms to use for sorting waypoints + \n" +
                "\tTY by type\n" +
                "\tNA by name\n" +
                "\tDS by distance to Springer\n" +
                "\tDK by distance to Katahdin\n" +
                "\tEL by elevation\n");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your preferred sort by term or 'Q' to quit: ");
        String term = in.nextLine();
        if(term.equals("TY"))
            searchTerm = 1;
        else if(term.equals("NA"))
            searchTerm = 2;
        else if(term.equals("DS"))
            searchTerm = 3;
        else if(term.equals("DK"))
            searchTerm = 4;
        else if(term.equals("EL"))
            searchTerm = 5;
        else
            searchTerm = 0;
        if(searchTerm != 0) {
            System.out.println("Enter 'A' to sort in ascending order or D to sort in descending order: ");
            term = in.nextLine();
            asc = (term.toLowerCase().equals("a")) ? true : false;
        }
    }

    /**
     * Prints all values in database
     */
    public void printDatabase() {
        for(Waypoint w : database) {
            System.out.println(w);
        }
    }

    /**
     * Uses selection sort technique to sort the values based on either ascending or descending order
     */
    public void selectionSort() {
        WaypointComparator wc = new WaypointComparator(searchTerm, asc);
        Waypoint toSwap;
        int index;
        for(int out = 0; out < database.size(); out++) {
            index = out;
            toSwap = database.get(out);
            for(int in = out+1; in < database.size(); in++) {
                Waypoint temp = database.get(in);
                if(wc.compare(temp, toSwap) < 0) {
                    toSwap = database.get(index);
                    index = in;
                }
            }
            database.set(index, database.get(out));
            database.set(out, toSwap);
        }
    }

    /**
     * Main method calls the sort and print methods for the database, and executes beginning and end of program
     * @param args
     */
    public static void main(String[] args) {
        TrailDatabase db = new TrailDatabase();
        System.out.println("*** Welcome to the Appalachian Trail Database ***");
        while(true) {
            db.getSearchTerm();
            if(db.searchTerm == 0)
                break;
            db.selectionSort();
            db.printDatabase();
        }
        System.out.println("End of program");
    }
}
