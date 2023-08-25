package spacecolonies;

import list.*;

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
public class ColonyCalculator {

    /**
     * field constant for number of planets
     */
    public static final int NUM_PLANETS = 3;
    /**
     * field onstant for minimum skill
     */
    public static final int MIN_SKILL_LEVEL = 1;
    /**
     * field constant for minimum skill
     */
    public static final int MAX_SKILL_LEVEL = 5;
    /**
     * private field variables
     */
    private ArrayQueue<Person> applicantQueue;
    private AList<Person> rejectBus;
    private static Planet[] planets = new Planet[NUM_PLANETS + 1];

    /**
     * 
     * @param people
     *            for arrayqueue of people
     * @param planets
     *            for the array of planets
     */
    public ColonyCalculator(ArrayQueue<Person> people, Planet[] planets) {
        if (people == null) {
            throw new IllegalArgumentException("null");
        }
        this.applicantQueue = people;
        ColonyCalculator.planets = planets;
        this.rejectBus = new AList<Person>();
    }


    /**
     * 
     * gets the planets
     * 
     * @return the array of planets
     */
    public static Planet[] getPlanets() {
        return planets;
    }


    /**
     * gets queue
     * 
     * @return the arrayqueue of people
     */
    public ArrayQueue<Person> getQueue() {
        return this.applicantQueue;
    }


    /**
     * method to find corresponding planet for person
     * 
     * @param nextPerson
     *            for placement
     * 
     * @return the corresponding planet
     */
    public Planet getPlanetForPerson(Person nextPerson) {
        if (nextPerson == null || applicantQueue.isEmpty()) {
            return null;
        }
        String preference = nextPerson.getPlanetPreference();
        Planet pref = null;
        Planet mostAvailible = null;
        for (Planet planet : planets) {
            if (planet != null) {
                if (pref == null && planet.getName().equals(preference)
                    && !planet.isFull()) {
                    pref = planet;
                }
                if (planet.compareTo(mostAvailible) >= 0) {
                    mostAvailible = planet;
                }
            }
        }
        if (pref == null || pref.isFull() || !pref.isQualified(nextPerson)) {
            if (mostAvailible == null || mostAvailible.isFull()
                || !mostAvailible.isQualified(nextPerson)) {
                return null;
            }
            return mostAvailible;
        }
        return pref;
    }


    /**
     * 
     * @param planet
     *            for the corresponding number
     * @return the planet at the index
     */
    public Planet planetByNumber(int planet) {
        if (planet >= 1 && planet <= NUM_PLANETS) {
            return planets[planet - 1];
        }
        return null;
    }


    /**
     * Test the next person in the queue to see if a Planet fits for them. If
     * one is found, remove them from the queue and add the person to that
     * planet
     * 
     * @return successfully added the person to a planet
     */
    public boolean accept() {
        if (applicantQueue.isEmpty()) {
            return false;
        }
        Person person = applicantQueue.getFront();
        Planet planet = this.getPlanetForPerson(person);
        if (planet == null || person == null) {
            return false;
        }
        planet.addPerson(person);
        this.applicantQueue.dequeue();
        return true;
    }


    /**
     * Get the planet index from the name of the planet. Returns -1 if no index
     * is found
     * 
     * @param planet
     *            name of the planet
     * @return index in the Planet array
     */
    public int getPlanetIndex(String planet) {
        for (int i = 0; i < planets.length; i++) {
            if (planets[i].getName().equals(planet) && planets[i] != null) {
                return i;
            }
        }
        return -1;
    }


    /**
     * method to reject the next person in the queue
     */
    public void reject() {
        if (applicantQueue.isEmpty()) {
            return;
        }
        Person person = applicantQueue.dequeue();
        this.rejectBus.add(person);
    }

}
