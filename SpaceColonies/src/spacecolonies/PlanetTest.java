package spacecolonies;

import student.TestCase;

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
 * @version 4.5.2021
 *
 */
public class PlanetTest extends TestCase {
    /**
     * planet field variables
     */
    private Planet planet1;
    private Planet planet2;

    private Person toAdd;

    /**
     * sets up the objects
     */
    public void setUp() {
        this.planet1 = new Planet("Earth", 1, 1, 1, 1);
        this.planet2 = new Planet("Mars", 2, 4, 6, 8);
        this.toAdd = new Person("jim", 1, 1, 1, "planet1");

    }


    /**
     * tests the getSkills() method
     */
    public void testGetSkills() {
        assertEquals(planet1.getSkills(), new Skillset(1, 1, 1));
        assertEquals(planet2.getSkills(), new Skillset(2, 4, 6));
    }


    /**
     * tests the getPopulationSize() method
     */
    public void testGetPopulationSize() {
        assertEquals(this.planet1.getPopulationSize(), 0);
    }


    /**
     * tests the getCapacity() method
     */
    public void testGetCapacity() {
        assertEquals(this.planet1.getCapacity(), 1, 0.01);
        assertEquals(this.planet2.getCapacity(), 8, 0.01);
    }


    /**
     * tests the getAvailability() method
     */
    public void testGetAvailability() {
        assertEquals(this.planet1.getAvailability(), 1, 0.01);
        this.planet1.addPerson(toAdd);
        assertEquals(this.planet1.getAvailability(), 0, 0.01);
    }


    /**
     * tests the isFull() method
     */
    public void testIsFull() {
        assertFalse(this.planet1.isFull());
        this.planet1.addPerson(toAdd);
        assertTrue(this.planet1.isFull());

    }


    /**
     * tests the getName() method
     */
    public void testGetName() {
        assertEquals(this.planet1.getName(), "Earth");
    }


    /**
     * tests the addPerson() method
     */
    public void testAddPerson() {
        assertEquals(this.planet1.getPopulationSize(), 0);
        this.planet1.addPerson(toAdd);
        assertEquals(this.planet1.getPopulationSize(), 1);

    }


    /**
     * tests the isQualified() method
     */
    public void testIsQualified() {
        assertTrue(this.planet1.isQualified(toAdd));
        assertFalse(this.planet2.isQualified(toAdd));
    }


    /**
     * tests the compareTo() method
     */
    public void testCompareTo() {
        assertEquals(0, planet1.compareTo(planet1), 0.01);
        assertTrue(planet1.compareTo(planet2) < 0);
        assertTrue(planet1.compareTo(null) > 0);
        assertTrue(planet2.compareTo(planet1) > 0);

    }


    /**
     * tests the toString() method
     */
    public void testToString() {
        assertEquals(planet1.toString(),
            "Earth, population 0 (capacity: 1), Requir: Agriculture >= 1, "
                + "Medicine >= 1, Technlogy >= 1");

    }
}
