package spacecolonies;

import student.TestCase;

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
public class SpaceColonyDataExceptionTest extends TestCase {
    /**
     * fields
     */
    private String message;

    /**
     * constructs the object
     */
    public void setUp() {
        this.message = "message";
    }


    /**
     * make sure the exception is thrown
     */
    public void testException() {
        Exception exception = new SpaceColonyDataException("message");
        assertEquals(exception.getLocalizedMessage(), message);
    }
}
