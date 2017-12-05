package project.pkg3;


import data.BikePart;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class WareHouse {
    /**
     * Initialized variables that make up a WareHouse object.
     */
    protected static ArrayList<BikePart> allInventory = new <BikePart>ArrayList();
    protected int qty;
    protected String id;
    /**
     * Getter for the ID of a WareHouse object.
     * @return id String
     */
    public String getID() {
        return id;
    }
    /**
     * Setter for the ID of a WareHouse object.
     * @param id String: id of the current WareHouse.
     */
    public void setID(String id) {
        this.id = id;
    }
    public WareHouse() {

    }
    /**
     * Reads in a file of bike parts and adds them to the inventory ArrayList.
     * @param file String: name of the file to be read.
     * @param inventory ArrayList: list in which the parts from the file will be
     * added.
     */
    public boolean readFile(String file, ArrayList<BikePart> inventory) {

        try {
            File f = new File(file);
            if (!f.exists()) {
                return false;
            }
            Scanner scan = new Scanner(f);
            scan.useDelimiter(",|\\n|\\r\\n");
            while (scan.hasNext()) {
                String name = scan.next();
                String id = scan.next();
                double lp = scan.nextDouble();
                System.out.println("name "+name);
                double sp = scan.nextDouble();
                //  System.out.println(sp);
                boolean is = scan.nextBoolean();
                int q = scan.nextInt();
                //scan.next();
                BikePart part;
                part = this.findPart(id, name);
                if (part == null) {
                    part = new BikePart(name, id, lp, sp, is, q);
                    inventory.add(part);
                } else {
                    part.setIsSale(is);
                    part.setLPrice(lp);
                    part.setSPrice(sp);
                    part.addQuantity(q);
                }

                qty++;
                //System.out.println(quantity+"  "+key.nextLine());
            }
            System.out.println("************************************************");
            System.out.println("Reading file is complete successfully");
            scan.close();
            return true;

        } catch (IOException ex) {
            /// System.out.println("************************************************");
            // System.out.printf("ERROR: Cannot read file\n", ex);
            //   System.out.println("************************************************");
            //quantity=0;
            return false;
        }
    }
    /**
     * Getter for the WareHouse object's allInventory ArrayList size.
     * @return ArrayList size Int.
     */
    public int getQuantity() {
        return allInventory.size();
    }
    /**
     * Adds BikePart object to allInventory ArrayList.
     * @param p BikePart: part object to be added.
     */
    public void addPart(BikePart p) {
        BikePart part;
        part = this.findPart(p.getPNumber(), p.getPname());
        if (part == null) {
            allInventory.add(p);
        } else {
            part.setIsSale(p.isIsSale());
            part.setLPrice(p.getLPrice());
            part.setSPrice(p.getSPrice());
            part.addQuantity(p.getQuantity());
        }

       // inventory.add(part);
        qty++;
    }
    /**
     * Saves allInevntory ArrayList to a separate file.
     */
    public void save() {
        try {
            PrintWriter pWriter = new PrintWriter(new File(WareHouseManager.DATABASE));
            for (BikePart p : allInventory) {
                String line = p.getPname() + "," + p.getPNumber() + "," + p.getLPrice() + "," + p.getSPrice() + "," + p.isIsSale() + "," + p.getQuantity()+"\n";
                pWriter.print(line);
            }
            pWriter.close();
        } catch (FileNotFoundException ex) {
        }
    }
    /**
     * Runs a loop through allInventory ArrayList, in search for a BikePart 
     * object.
     * @param pNum Strung: Should match a BikePart number.
     * @param pName String: Should match a BikePart name.
     * @return BikePart if found, otherwise null.
     */
    public BikePart findPart(String pNum, String pName) {
        for (BikePart p : allInventory) {
            if (p.getPNumber().equals(pNum) || p.getPname().equals(pName)) {
                return p;
            }

        }
        return null;
    }
    /**
     * Runs a loop through allInventory, searching a BikePart by number only.
     * @param pNum String: Should match a BikePart number.
     * @return BikePart if found, otherwise null.
     */
    public BikePart findPartByNumber(String pNum) {
        for (BikePart p : allInventory) {
            if (p.getPNumber().equals(pNum)) {
                return p;
            }

        }
        return null;
    }
    /**
     * Runs a loop through allInventory, searching a BikePart by name only.
     * @param pName String: Should match a BikePart name.
     * @return BikePart if found, otherwise null.
     */
    public BikePart findPartByName(String pName) {
        for (BikePart p : allInventory) {
            if (p.getPname().equals(pName)) {
                return p;
            }

        }
        return null;
    }
    /**
     * Searches BikePart by name and returns it to user.
     * @param pName String: Should match a BikePart name.
     * @return BikePart if found, otherwise null.
     */
    public String display(String pName) {
        BikePart p = this.findPartByName(pName);
        if (p == null) {
            return "Cannot find this part";
        } else {
             return p.toString();
        }
    }
    /**
     * Searches BikePart by number and returns it to user.
     * @param pNum String: Should match a BikePart number.
     * @return BikePart if found, otherwise null.
     */
    public String displayPartByNum(String pNum) {
        BikePart p = this.findPartByNumber(pNum);
        if (p == null) {
            return "Cannot find this part";
        } else {
           
            return p.toString();
        }
    }
    /**
     * Displays contents from allInventory ArrayList through a loop.
     * @return BikePart object.
     */
    public String display() {
        String r = "";
        for (BikePart p : allInventory) {
            if (p.getQuantity() > 0) {
                r += p + "\n";
            }
        }
        return r;
    }
    /**
     * Sorts allInventory ArrayList by name and calls display method.
     */
    public String displayByName() {
        BikePart.sortType = 0;
        Collections.sort(allInventory);
        return display();
    }
    /**
     *  Sorts allInventory ArrayList by name and calls display method.
     */
    public String displayByNumber() {
        BikePart.sortType = 1;
        Collections.sort(allInventory);
        return display();
    }
    /**
     * The following methods perform the same functions as the three previous,
     * but in the entire inventory.
     */
    public String displayAll() {
        String r = "";
        for (BikePart p : allInventory) {
            if (!p.isSoldOut()) {
                r += p.getAllInfo() + "\n";
            }
        }
        return r;
    }
    public String  displayAllByName() {
        BikePart.sortType = 0;
        Collections.sort(allInventory);
        return displayAll();
    }
    public String displayAllByNum() {
       
    BikePart.sortType = 1;
        Collections.sort(allInventory);
        return displayAll();
    }
    /**
     * Calls readFile method to add BikeParts 
     * @param file String: name of file from which BikeParts will be added.
     */
    public boolean readFileToMain(String file) {
        return readFile(file,allInventory);
    }
    public boolean readFile(String file) {
       return readFileToMain(file);
    }
    /**
     * 
     * @param qty
     * @return 
     */
    public String getPartsCloseTo(int qty) {
        String r = "";
        for (BikePart p : allInventory) {
            if (p.getQuantity()<=qty) {
                r += p.getPname()+"\t\t"+ p.getQuantity() + "\n";
            }

        }
        return r;
    }

  

}
