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
 * @version 4.7.2021
 *
 */
public class SkillsetTest extends TestCase {
    /**
     * field variables
     */
    private Skillset skilltest1;
    private Skillset skilltest2;
    private Skillset zero;
    private Skillset equalSet;
    private Skillset nullSet;
    private String diff;
    private Skillset t1;
    private Skillset t2;
    private Skillset t3;
    private Skillset t4;

    /**
     * sets up the skillset objects
     */
    public void setUp() {
        this.skilltest1 = new Skillset(3, 3, 3);
        this.skilltest2 = new Skillset(2, 2, 2);
        this.equalSet = new Skillset(3, 3, 3);
        this.zero = new Skillset(0, 0, 0);
        this.nullSet = null;
        this.t1 = new Skillset(1, 1, 1);
        this.t2 = new Skillset(2, 1, 1);
        this.t3 = new Skillset(2, 2, 1);
        this.t4 = new Skillset(2, 2, 2);
        this.diff = "message";

    }


    /**
     * tests the lessThanOrEqualTo() method from skillset
     */
    public void testLessThanOrEqualTo() {
        assertFalse(this.skilltest1.isLessThanOrEqualTo(this.skilltest2));
        assertTrue(this.skilltest2.isLessThanOrEqualTo(this.skilltest1));
    }


    /**
     * tests the getAgriculture() method from Skillset
     */
    public void testGetAgriculture() {
        assertEquals(this.skilltest2.getAgriculture(), 2);
        assertEquals(this.skilltest1.getAgriculture(), 3);
        assertEquals(this.zero.getAgriculture(), 0);

    }


    /**
     * tests the getMedicine() method
     */
    public void testMedicine() {
        assertEquals(this.skilltest1.getMedicine(), 3);

    }


    /**
     * tests the getTechnology() method
     */
    public void testGetTechnology() {
        assertEquals(this.skilltest1.getTechnology(), 3);
    }


    /**
     * tests the toString() method
     */
    public void testToString() {
        assertEquals(this.skilltest1.toString(),
            "Agriculture:3, Medicine:3, Technology:3");
    }


    /**
     * tests the equals() method
     */
    public void testEquals() {
        assertFalse(this.skilltest1.equals(this.skilltest2));
        assertTrue(this.skilltest1.equals(this.equalSet));
        assertNull(this.nullSet);
        assertTrue(this.skilltest1.equals(skilltest1));
        assertEquals(this.skilltest1.getAgriculture(), equalSet
            .getAgriculture());
        assertFalse(this.skilltest1.equals(nullSet));
        assertFalse(this.skilltest1.equals(diff));

        assertFalse(t2.equals(t3));
        assertFalse(t2.equals(t4));
        assertFalse(t3.equals(t1));
        assertFalse(t3.equals(t2));
        assertFalse(t3.equals(t4));
        assertFalse(t4.equals(t1));
        assertFalse(t4.equals(t2));
        assertFalse(t4.equals(t3));
        assertFalse(t1.equals(t2));
        assertFalse(t1.equals(t2));
        assertFalse(t1.equals(t2));
        assertFalse(t1.equals(t2));

    }


    /**
     * tests compareTo()
     */
    public void testCompareTo() {
        assertEquals(this.skilltest1.compareTo(equalSet), 0, 0.01);
    }

}
