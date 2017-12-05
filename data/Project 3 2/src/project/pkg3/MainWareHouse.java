package project.pkg3;


public class MainWareHouse extends WareHouse{
    /**
     * Creates a MainWareHouse object
     * @param n String: constructs id object.
     */
    public MainWareHouse(String n) {
        id = n;
        readFile(WareHouseManager.DATABASE, allInventory);
    }

    

}
