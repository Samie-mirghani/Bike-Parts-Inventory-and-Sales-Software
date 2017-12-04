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
/**
 *
 * @author I K
 */
public class WareHouse {

    protected static ArrayList<BikePart> allInventory = new <BikePart>ArrayList();

    protected int qty;
    protected String id;

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public WareHouse() {

    }

   
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
   

    public int getQuantity() {
        return allInventory.size();
    }

   

 

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

    public BikePart findPart(String pNum, String pName) {
        for (BikePart p : allInventory) {
            if (p.getPNumber().equals(pNum) || p.getPname().equals(pName)) {
                return p;
            }

        }
        return null;
    }

    public BikePart findPartByNumber(String pNum) {
        for (BikePart p : allInventory) {
            if (p.getPNumber().equals(pNum)) {
                return p;
            }

        }
        return null;
    }

    public BikePart findPartByName(String pName) {
        for (BikePart p : allInventory) {
            if (p.getPname().equals(pName)) {
                return p;
            }

        }
        return null;
    }

    public String display(String pName) {
        BikePart p = this.findPartByName(pName);
        if (p == null) {
            return "Cannot find this part";
        } else {
             return p.toString();
        }
    }
    
     public String displayPartByNum(String pName) {
        BikePart p = this.findPartByNumber(pName);
        if (p == null) {
            return "Cannot find this part";
        } else {
           
            return p.toString();
        }
    }

    public String display() {
        String r = "";
        for (BikePart p : allInventory) {
            if (p.getQuantity() > 0) {
                r += p + "\n";
            }
        }
        return r;
    }

    public String displayByName() {
        BikePart.sortType = 0;
        Collections.sort(allInventory);
        return display();

    }

    public String displayByNumber() {
        BikePart.sortType = 1;
        Collections.sort(allInventory);
        return display();
    }

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

    public boolean readFileToMain(String file) {
        return readFile(file,allInventory);
    }

   public boolean readFile(String file) {
       return readFileToMain(file);
    }

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
