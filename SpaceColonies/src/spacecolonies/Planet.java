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
 * @version 4.2.2021
 *
 */
public class Planet implements Comparable<Planet> {
    private String name;
    private Skillset minSkills;
    private Person[] population;
    private int populationSize;
    private int capacity;

    /**
     * Planet constructor
     * 
     * @param planetName
     *            for the name of the planet
     * @param planetAgri
     *            for agriculture
     * @param planetMedi
     *            for medicine
     * @param planetTech
     *            for technology
     * @param planetCap
     *            for capacity
     */
    public Planet(
        String planetName,
        int planetAgri,
        int planetMedi,
        int planetTech,
        int planetCap) {
        this.name = planetName;
        this.populationSize = 0;
        this.capacity = planetCap;
        this.minSkills = new Skillset(planetAgri, planetMedi, planetTech);
        this.population = new Person[capacity];

    }


    /**
     * method to get the minimum skills for this planet stored as a Skill object
     * 
     * @return minimum Skills
     */
    public Skillset getSkills() {
        return minSkills;
    }


    /**
     * sets the name for planet
     * 
     * @param name
     *            for the name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * gets the population size
     * 
     * @return the population size
     */
    public int getPopulationSize() {
        return populationSize;
    }


    /**
     * gets the capacity
     * 
     * @return the planets capacity
     */
    public int getCapacity() {
        return capacity;
    }


    /**
     * gets the population of people
     * 
     * @return the population of people
     */
    public Person[] getPopulation() {
        return population;
    }


    /**
     * gets the leftover space
     * 
     * @return the difference between capacity and population size.
     */
    public int getAvailability() {
        return capacity - populationSize;
    }


    /**
     * checks if the queue is full
     * 
     * @return true if the population has reached capacity
     */
    public boolean isFull() {
        return populationSize == capacity;
    }


    /**
     * gets the name of type String.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }


    /**
     * 
     * @param newbie
     *            for the person we are adding.
     * @return true if the person can be added.
     */
    public boolean addPerson(Person newbie) {
        if (getAvailability() > 0 && isQualified(newbie)) {
            population[populationSize] = newbie;
            populationSize++;
            return true;
        }
        return false;
    }


    /**
     * 
     * @param person
     *            that will be checked
     * @return true if the parameter has a higher skill than this.
     */
    public boolean isQualified(Person person) {
        return this.minSkills.isLessThanOrEqualTo(person.getSkillset());
    }


    /**
     * compares two planet objects
     */
    @Override
    public int compareTo(Planet o) {
        if (o == null) {
            return 1;
        }
        return this.getAvailability() - o.getAvailability();
    }


    /**
     * Get the string version of planets.
     * 
     * @return toString() of planets
     */
    @Override
    public String toString() {
        StringBuilder build = new StringBuilder();

        build.append(name + ", ");
        build.append("population ");
        build.append(populationSize);
        build.append(" (capacity: " + capacity + "), ");
        build.append("Requir: ");
        build.append("Agriculture >= " + minSkills.getAgriculture());
        build.append(", Medicine >= " + minSkills.getMedicine());
        build.append(", Technlogy >= " + minSkills.getTechnology());
        return build.toString();
    }
}
