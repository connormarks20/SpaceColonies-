package spacecolonies;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Connor Marks (connorm20)
/**
 * 
 * @author Connor Marks
 * @version 4.5.2021
 *
 */
public class SpaceColonyDataException extends Exception {
    public static final long serialVersionUID = 10;

    /**
     * Constructor
     * 
     * @param string
     *            for the String
     */
    public SpaceColonyDataException(String string) {
        super(string);
    }
}
