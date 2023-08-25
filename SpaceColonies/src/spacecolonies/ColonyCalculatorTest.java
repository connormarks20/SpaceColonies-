// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Connor Marks(connorm20)
package spacecolonies;

/**
 * ColonyCalculatorTest
 * 
 * @author Connor Marks
 * @version 4.7.2021
 *
 */
public class ColonyCalculatorTest extends student.TestCase {

    /**
     * ColonyCalculator fields
     */
    private Planet[] planets;
    private ColonyCalculator calc1;
    private ArrayQueue<Person> arr;
    private Planet earth;
    private Planet mars;
    private Planet plan;
    private Person empt;

    /**
     * Constructs the fields
     */
    public void setUp() {
        this.arr = new ArrayQueue<Person>();
        arr.enqueue(new Person("Connor", 10, 10, 10, "Earth"));
        arr.enqueue(new Person("Carol", 3, 3, 2, "Mars"));
        arr.enqueue(new Person("Andrew", 5, 4, 3, "Plan"));
        arr.enqueue(new Person("Judy", 2, 2, 2, "Plan"));

        earth = new Planet("Earth", 1, 1, 1, 1);
        mars = new Planet("Mars", 1, 1, 1, 1);
        plan = new Planet("Plan", 1, 1, 1, 1);
        this.planets = new Planet[] { earth, mars, plan, null };
        this.calc1 = new ColonyCalculator(arr, planets);

    }


    /**
     * tests for exception
     */
    public void testConstructor() {
        Exception exception = null;
        try {
            new ColonyCalculator(null, planets);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);
    }


    /**
     * tests getQueue()
     */
    public void testGetQueue() {
        assertEquals(arr, calc1.getQueue());
    }


    /**
     * tests getPlanets()
     */
    public void testGetPlanets() {
        assertEquals(planets, ColonyCalculator.getPlanets());
    }


    /**
     * Test ColonyCalculator accept and reject methods for proper functionality
     */
    public void testAccept() {

        assertEquals(plan.getAvailability(), 1, 0.01);
        assertTrue(calc1.accept());
        assertEquals(mars.getAvailability(), 1, 0.01);
        assertTrue(calc1.accept());
        assertEquals(earth.getAvailability(), 0, 0.01);
        assertTrue(calc1.accept());
        assertFalse(calc1.accept());
        calc1.reject();
        assertFalse(calc1.accept());
        calc1.reject();
    }


    /**
     * tests planetByNumber()
     */
    public void testPlanetByNumber() {

        assertEquals(plan, calc1.planetByNumber(3));
        assertNull(calc1.planetByNumber(-1));
        assertNull(calc1.planetByNumber(20));
        assertEquals(earth, calc1.planetByNumber(1));
        assertEquals(mars, calc1.planetByNumber(2));
    }


    /**
     * tests getPlanetIndex()
     */
    public void testGetPlanetIndex() {
        assertEquals(0, calc1.getPlanetIndex(earth.getName()));
        assertEquals(1, calc1.getPlanetIndex(mars.getName()));
        assertEquals(2, calc1.getPlanetIndex(plan.getName()));

    }


    /**
     * tests getPlanetForPerson()
     */
    public void testGetPlanetForPerson() {
        assertNull(calc1.getPlanetForPerson(empt));
        Person person = this.arr.dequeue();
        earth.addPerson(person);
        person = this.arr.dequeue();
        plan.addPerson(person);
        person = this.arr.dequeue();
        assertEquals(mars, calc1.getPlanetForPerson(person));
        mars.addPerson(person);
        person = this.arr.dequeue();
        assertNull(calc1.getPlanetForPerson(person));

        Planet preferred = new Planet("p4", 3, 3, 3, 1);
        Planet avail = new Planet("p5", 2, 2, 2, 10);
        Planet[] webps = { preferred, avail };

        Person qualified = new Person("t1", 5, 5, 5, "p4");
        Person notqualified1 = new Person("t1", 1, 1, 1, "p4");
        Person notqualified2 = new Person("t1", 2, 2, 2, "p4");
        Person availqualified = new Person("t2", 5, 5, 5, "");

        ArrayQueue<Person> q = new ArrayQueue<Person>();
        q.enqueue(qualified);
        ColonyCalculator cal2 = new ColonyCalculator(q, webps);

        assertNull(cal2.getPlanetForPerson(notqualified1));
        assertEquals(avail, cal2.getPlanetForPerson(notqualified2));
        assertEquals(preferred, cal2.getPlanetForPerson(qualified));
        preferred.addPerson(qualified);
        assertEquals(avail, cal2.getPlanetForPerson(qualified));
        assertEquals(avail, cal2.getPlanetForPerson(availqualified));

    }

}
