package spacecolonies;

import java.io.FileNotFoundException;
import bsh.ParseException;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and
// integrity at all times.
// I will not lie, cheat, or steal, nor will I accept
// the actions of those who
// do.
// -- Connor Marks (connorm20)

/**
 * 
 * @author Connor Marks
 * @version 4.8.2021
 *
 */

public class ProjectRunner {
    public ProjectRunner() {
        /**
         * empty method
         */
    }


    /**
     * 
     * @param args
     *            for the array of string arguments
     * @throws ParseException
     *             for parseexception
     * @throws SpaceColonyDataException
     *             for spacecolonydataexception
     * @throws FileNotFoundException
     *             for filenotfoundexception
     */
    public static void main(String[] args)
        throws SpaceColonyDataException,
        ParseException,
        FileNotFoundException {
        
        if (args.length == 2) {
            new ColonyReader(args[0], args[1]);
        }
        else {
            new ColonyReader("balancedInput.txt", "planets.txt");
        }

    }

}
