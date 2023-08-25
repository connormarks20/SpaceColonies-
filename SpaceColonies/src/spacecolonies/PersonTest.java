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
 * @version 4.8.2021
 *
 */
public class PersonTest extends TestCase {
    // public Person(String name, int agri, int medi, int tech, String planet)
    private Person person1;
    private Person person2;
    private Person equals;
    private Person test3;
    private Person empt;
    private String stringTest;
    private Person planetP;

    /**
     * sets up the Person objects
     */
    public void setUp() {
        this.person1 = new Person("Connor", 3, 5, 8, "Earth");
        this.person2 = new Person("Andrew", 1, 3, 5, "Mars");
        this.equals = new Person("Connor", 3, 5, 8, "Earth");
        this.stringTest = "test";
        this.test3 = new Person("Connor", 1, 2, 3, "Earth");
        this.planetP = new Person("Jim", 4, 6, 2, "Earth");
    }


    /**
     * tests getPlanetPreference() from Person class
     */
    public void testGetPlanetPreference() {
        assertEquals(this.person1.getPlanetPreference(), "Earth");
        assertEquals(this.person2.getPlanetPreference(), "Mars");
    }


    /**
     * tests getName() from Person class
     */
    public void testGetName() {
        assertEquals(this.person1.getName(), "Connor");
        assertEquals(this.person2.getName(), "Andrew");
    }


    /**
     * tests getSkillSet() method from class Person
     */
    public void testGetSkillSet() {
        assertEquals(this.person1.getSkillset(), new Skillset(3, 5, 8));
        assertEquals(this.person2.getSkillset(), new Skillset(1, 3, 5));
    }


    /**
     * tests toString() from Person class
     */
    public void testToString() {
        assertEquals(this.person1.getSkillset().toString(),
            "Agriculture:3, Medicine:5, Technology:8");
        assertEquals(this.person1.getPlanetPreference().toString(), "Earth");
        assertEquals(
            "Andrew Agriculture:1, Medicine:3, Technology:5 planetPref: Mars",
            person2.toString());

    }


    /**
     * tests the equals method from Person class
     */
    public void testEquals() {
        assertFalse(this.person1.equals(this.person2));
        assertEquals(this.person1, this.equals);
        assertTrue(this.person1.equals(this.equals));
        assertFalse(this.person1.equals(empt));
        assertFalse(this.person1.equals(stringTest));
        assertFalse(this.person1.equals(test3));
        assertTrue(this.person1.equals(person1));
        assertFalse(this.person1.equals(planetP));
    }

}
