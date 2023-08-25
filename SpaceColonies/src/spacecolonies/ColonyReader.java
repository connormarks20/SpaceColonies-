
package spacecolonies;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import bsh.ParseException;
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and 
//integrity at all times.
//I will not lie, cheat, or steal, nor will I accept
//the actions of those who
//do.
//-- Connor Marks (connorm20)
/**
 * 
 * @author Connor Marks (connorm20)
 * @version 4.5.2021
 *
 */
public class ColonyReader {
    private Planet[] planets;
    private ArrayQueue<Person> queue;
    


    /**
     * 
     * @param applicantFileName
     * @param planetFileName
     * @throws SpaceColonyDataException
     * @throws ParseException
     * @throws FileNotFoundException
     */
    public ColonyReader(String applicantFileName, String planetFileName)
        throws 
        SpaceColonyDataException,
        ParseException,
        FileNotFoundException {
        queue = this.readQueueFile(applicantFileName);
        planets = this.readPlanetFile(planetFileName);
        new SpaceWindow(new ColonyCalculator(queue, planets));
        
    }
    


    /**
     * 
     * @param fileName for the name of the file
     * @return the thing
     * @throws SpaceColonyDataException exception
     * @throws ParseException exception
     * @throws FileNotFoundException exception
     */
    private Planet[] readPlanetFile(String fileName)
        throws 
        SpaceColonyDataException,
        ParseException,
        FileNotFoundException {
        int flag = 0;
        Scanner scan = new Scanner(new File(fileName));
        Planet[] planetArray = new Planet[3];
        
        
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] split = line.split(",");
            try {
                String name = split[0].trim();
                int ag = Integer.parseInt(split[1].trim());
                int med = Integer.parseInt(split[2].trim());
                int tech = Integer.parseInt(split[3].trim());
                int cap = Integer.parseInt(split[4].trim());
                if (!isInSkillRange(ag, med, tech)) {
                    throw new SpaceColonyDataException("");
                }
                planetArray[flag] = new Planet(name, ag, med, tech, cap);
            }
            catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                throw new ParseException("Invalid Planet text Formatting");
            }
            catch (SpaceColonyDataException e) {
                throw new SpaceColonyDataException("Skills not in range (1,5)");
            }
            ++flag;
        }
        if (flag != ColonyCalculator.NUM_PLANETS) {
            throw new SpaceColonyDataException(
                "Does not meet required Planets");
        }
        scan.close();
        return planetArray;
    }
    /**
     * 
     * @param agr for agriculture
     * @param medi for medicine
     * @param techn for technology
     * @return 
     */
    private boolean isInSkillRange(int agr, int medi, int techn) {
        int[] skill = { agr, medi, techn };
        for (int i : skill) {
            if (i < ColonyCalculator.MIN_SKILL_LEVEL
                || i > ColonyCalculator.MAX_SKILL_LEVEL) {
                return false;
            }
        }
        return true;
    }


    /**
     * 
     * @param fileName for the name of the file
     * @return the thing
     * @throws SpaceColonyDataException exception
     * @throws ParseException exception
     * @throws FileNotFoundException exception
     */
    private ArrayQueue<Person> readQueueFile(String fileName)
        throws SpaceColonyDataException,
        ParseException,
        FileNotFoundException {
        Scanner scan = new Scanner(new File(fileName));
        ArrayQueue<Person> personArray = new ArrayQueue<Person>();
        
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] split = line.split(",");
            try {
                String name = split[0].trim();
                int ag = Integer.parseInt(split[1].trim());
                int med = Integer.parseInt(split[2].trim());
                int tech = Integer.parseInt(split[3].trim());
                String pref = "";
                if (split.length == 5) {
                    pref = split[4].trim();
                }
                if (!isInSkillRange(ag, med, tech)) {
                    throw new SpaceColonyDataException("");
                }
                personArray.enqueue(new Person(name, ag, med, tech, pref));
            }
            catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                throw new ParseException("Invalid Person text Formatting");
            }
            catch (SpaceColonyDataException e) {
                throw new SpaceColonyDataException("out of range");
            }
        }
        scan.close();
        return personArray;
    }

   
}
