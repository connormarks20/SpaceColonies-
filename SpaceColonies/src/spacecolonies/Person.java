package spacecolonies;

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
 * @version 4.1.2021
 *
 */
public class Person {
    private String name;
    private Skillset skills;
    private String planetPreference;

    /**
     * Constructor for Person objects
     * 
     * @param name
     *            for the persons name
     * @param agri
     *            for value of agriculture
     * @param medi
     *            for value of medicine
     * @param tech
     *            for value of technlogy
     * @param planet
     *            for name of planet.
     */
    public Person(String name, int agri, int medi, int tech, String planet) {
        this.name = name;
        this.skills = new Skillset(agri, medi, tech);
        this.planetPreference = planet;
    }


    /**
     * returns planetPreference of type String.
     * 
     * @return the planetPreference of the Person.
     */
    public String getPlanetPreference() {
        return planetPreference;
    }


    /**
     * gets the string for name
     * 
     * @return the name in the Person object.
     */
    public String getName() {
        return name;
    }


    /**
     * gets the int for skillset
     * 
     * @return the int associated with skills
     */
    public Skillset getSkillset() {
        return skills;
    }


    /**
     * 
     * toString() method
     * 
     * @return the string represenation
     */
    public String toString() {

        StringBuilder build = new StringBuilder();
        build.append(name + " ");
        build.append(skills.toString());
        if (planetPreference.length() > 0) {
            build.append(" planetPref: " + planetPreference);
        }
        return build.toString();
    }


    /**
     * equals method
     * 
     * @param obj
     *            for the object
     * @return boolean
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass().equals(this.getClass())) {
            Person other = (Person)obj;
            if (this.name.equals(other.name) && this.skills.equals(other.skills)
                && this.planetPreference.equals(other.planetPreference)) {
                return true;
            }
        }
        return false;
    }
}
