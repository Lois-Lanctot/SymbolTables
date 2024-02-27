import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Refer to p. 372 of the Algorithms book
 */
public class FrequencyCounter {
//    private SymbolTable<String, Integer> table;


    public static void main(String[] args) throws FileNotFoundException {
//        alternate();


        Scanner in = new Scanner(new File("leipzig1M.txt"));

        // create an empty symbol table (map)
        SymbolTable<String, Integer> table = new SeperateChainingHashST<>(500000);

        while (in.hasNext()) {
            String word = in.next();

            // check if the word is in the table
            if (!table.contains(word)) {
                table.put(word, 1);
            }
            else {
                // the word is in the table - update the value
                int count = table.get(word);
                count++;
                table.put(word, count);
//                table.put(word, table.get(word)+1); //the short way
            }
        }

        // print out the table
        for (String word : table.keys()) {
            System.out.println(word + " : " + table.get(word));
        }
    }


    public static void alternate() throws FileNotFoundException{
        Scanner in = new Scanner(new File("leipzig1M.txt"));


        // similar code to above, except using Java built-in libraries
        // BST - Treemap
//        Map<String, Integer> table = new TreeMap<>();
        Map<String, Integer> table = new HashMap<>(); // instead of SeparateChaining


        while (in.hasNext()) {
            String word = in.next();

            // check if the word is in the table
            if (!table.containsKey(word)) { // << difference
                table.put(word, 1);
            }
            else {
                // the word is in the table - update the value
                int count = table.get(word);
                count++;
                table.put(word, count);
//                table.put(word, table.get(word)+1); //the short way
            }
        }

        // print out the table
        for (String word : table.keySet()) { // << difference
            System.out.println(word + " : " + table.get(word));
        }
    }

}

