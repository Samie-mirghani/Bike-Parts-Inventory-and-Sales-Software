package project.pkg3;

import data.Invoice;
import data.BikePart;
import data.Account;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class MobileWareHouse extends WareHouse {

    protected ArrayList<BikePart> inventory = new ArrayList<>();
    protected HashMap<String, Invoice> invoices = new HashMap<>();
    private Account salesPerson;

    MobileWareHouse(int i) {
        id = "salesVan" + (char) ('A' + i);
        System.out.println(id);
        File f = new File(id + ".txt");
        if (f.exists()) {
            return;
        }
        try {
            f.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void associate(Account ac) {
        salesPerson = ac;
    }

    public Account getSalesPerson() {
        return salesPerson;
    }

    /**
     * A method to read a file.
     *
     * @return integer that represents the number of lines.
     * @throws FileNotFoundException
     */
    public boolean readFile(String file) {

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
                double sp = scan.nextDouble();
                //  System.out.println(sp);
                boolean is = scan.nextBoolean();
                int q = scan.nextInt();
                //  scan.next();
                BikePart part;
                part = this.findPart(id, name);

                if (part == null) {
                    part = new BikePart(name, id, lp, sp, is, 0);
                    part.addLocation(this.id, q);
                    addPart(part);
                    inventory.add(part);

                } else {
                    //part.setIsSale(is);
                    //part.setLPrice(lp);
                    //part.setSPrice(sp);
                    //part.addQuantity(q);
                    // part.
                    inventory.add(part);
                    part.addLocation(this.id, q);
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

    public BikePart findPartInVan(String pNum, String pName) {
        for (BikePart p : inventory) {
            if (p.getPNumber().equals(pNum) || p.getPname().equals(pName)) {
                return p;
            }

        }
        return null;
    }

    public BikePart findPartByNumberInVan(String pNum) {
        for (BikePart p : inventory) {
            if (p.getPNumber().equals(pNum)) {
                return p;
            }

        }
        return null;
    }

    public BikePart findPartByNameinVan(String pName) {
        for (BikePart p : inventory) {
            if (p.getPname().equals(pName)) {
                return p;
            }

        }
        return null;
    }

    public void addPart(BikePart p) {
        BikePart part;
        part = this.findPartInVan(p.getPNumber(), p.getPname());
        if (part == null) {
            inventory.add(p);
        } else {
            part.setIsSale(p.isIsSale());
            part.setLPrice(p.getLPrice());
            part.setSPrice(p.getSPrice());
            part.addQuantity(p.getQuantity());
        }

        // inventory.add(part);
        qty++;
    }

    public String displayByName(String vanID) {
        BikePart.sortType = 0;
        Collections.sort(inventory);
        return display(vanID);

    }

    public String displayByNumber(String vanID) {
        BikePart.sortType = 1;
        Collections.sort(inventory);
        return display(vanID);
    }

    public String display(String vanID) {
        String r = "";
        for (BikePart p : inventory) {
            if (p.getQuantity() > 0) {
                r += p.getVanInfo(vanID) + "\n";
            }
        }
        return r;
    }

    public void addInvoice(String n, Invoice in) {
        invoices.put(n, in);
    }

    public String toString() {
        return id;
    }

    public Invoice getInvoice(String name) {
        Invoice in = invoices.get(name);
        return in;
    }

    public String generateInvoice(String inID) {
        Invoice in = invoices.get(inID);
        return in.generateInvoice();
    }

    public void saveInvocies() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(id + ".obj")));
            oos.writeObject(invoices);
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void readInvocies() {
        File f = new File(id + ".obj");
        if (!f.exists()) {
            return;
        }
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            invoices = (HashMap<String, Invoice>) ois.readObject();
            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private Date convertToDate(String d)
    {
       Scanner scan = new Scanner(d);
       scan.useDelimiter("/");
       int m = scan.nextInt();
       int day = scan.nextInt();
       int y = scan.nextInt();
       Date date = new Date(y-1900,m-1,day);
       return date;
    }
    public String getSalesmanCheck(String stDate, String enDate) {
        
        String r = "";
        double salary=0;
        Date start = convertToDate(stDate);
        Date end = convertToDate(enDate);
        Iterator it = invoices.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            Invoice in = (Invoice) pair.getValue();
            
            if(in.getInvoiceDate().after(start) && in.getInvoiceDate().before(end))
            {
                salary += in.getTotal();
            }
            
            it.remove(); // avoids a ConcurrentModificationException
        }
        
        r+= "The total sales You made is "+ salary; 
        r+="\nYour salary (15%) is: "+(0.15 * salary);
        return r;
    }
}
