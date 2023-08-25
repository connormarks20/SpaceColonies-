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
 * @version 4.1.2021
 *
 */
public class Skillset implements Comparable<Skillset> {
    /**
     * fields
     */
    private int agriculture;
    private int medicine;
    private int technology;

    /**
     * Constructs Skillset objects using the field variables above
     * 
     * @param ag
     *            for agriculture
     * @param med
     *            for medicine
     * @param tech
     *            for technology
     */
    public Skillset(int ag, int med, int tech) {
        this.agriculture = ag;
        this.medicine = med;
        this.technology = tech;
    }


    /**
     * 
     * @param other
     *            is the object we are using to compare
     * @return true if other is larger than the other objects.
     */
    public boolean isLessThanOrEqualTo(Skillset other) {
        return agriculture <= other.agriculture && medicine <= other.medicine
            && technology <= other.technology;

    }


    /**
     * method to get the int stored in agriculture
     * 
     * @return the value stored in agriculture
     */
    public int getAgriculture() {
        return agriculture;
    }


    /**
     * method to get the int stored in medicine
     * 
     * @return the value stored in medicine
     */
    public int getMedicine() {
        return medicine;
    }


    /**
     * 
     * @return the technology value
     */
    public int getTechnology() {
        return technology;
    }


    /**
     * returns string represenatino.
     * 
     * @return the string representation
     */
    public String toString() {
        return "Agriculture:" + agriculture + "," + " Medicine:" + medicine
            + "," + " Technology:" + technology;
    }


    /**
     * tests whether two skillset objects are equal.
     * 
     * @param obj
     *            for the object passed
     * @return a boolean
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass().equals(this.getClass())) {
            Skillset other = (Skillset)obj;
            if (other.agriculture == this.agriculture
                && other.medicine == this.medicine
                && other.technology == this.technology) {
                return true;
            }
        }
        return false;
    }


    /**
     * return the comparison
     */
    @Override
    public int compareTo(Skillset o) {
        return this.getAgriculture() - o.getAgriculture() + this.getMedicine()
            - o.getMedicine() + this.getTechnology() - o.getTechnology();
    }

}
