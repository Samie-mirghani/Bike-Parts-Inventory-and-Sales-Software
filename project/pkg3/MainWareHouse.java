package project.pkg3;


public class MainWareHouse extends WareHouse{

    public MainWareHouse(String n) {
        id = n;
        readFile(WareHouseManager.DATABASE, allInventory);
    }

    

}
