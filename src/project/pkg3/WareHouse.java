package project.pkg3;

import java.util.*;

/**
 * This class will create a ware house and give it its special attributes
 *
 * @author Shamsadean Mirghani
 */

public class WareHouse {

    /**
     * This class will create a ware house and give it its special attributes
     *
     * @author Shamsadean Mirghani
     */
    ArrayList<BikePart> wareHouse;
    String wareName;

    /**
     * This constructor will take an ArrayList and a name of a warehouse and it
     * will create a warehouse
     *
     * @param wareHouse
     * @param wareName
     */
    public WareHouse(ArrayList<BikePart> wareHouse, String wareName) {
        this.wareHouse = wareHouse;
        this.wareName = wareName;

    }

    /**
     * This method will get the name of the warehouse
     *
     * @return wareName
     */
    public String getWareName() {
        return wareName;
    }

    /**
     * This method will get the ArrayList that belongs to the warehouse
     *
     * @return wareHouse
     */
    public ArrayList<BikePart> getWareHouse() {
        return wareHouse;
    }
}
