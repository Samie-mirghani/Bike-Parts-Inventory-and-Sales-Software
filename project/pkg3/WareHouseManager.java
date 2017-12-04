package project.pkg3;

import data.Invoice;
import data.BikePart;
import data.Account;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class WareHouseManager {

    private WareHouse mainWH;
    private ArrayList<MobileWareHouse> vans = new ArrayList<>();
    private ArrayList<Account> accounts = new ArrayList<>();
    public static final String DATABASE = "warehouseDB.txt";
    private int numberOfVans;
    public static WareHouseManager manager;
    private ArrayList<Account> salesmanList = new ArrayList<>();

    public WareHouseManager() {
        mainWH = new MainWareHouse("mainwh");
        readVans(0);
        readAccounts();
    }

    public ArrayList<Account> getAccounts() {
        for(Account ac: accounts)
        {
            if(ac.getType()==3)
               salesmanList.add(ac);
        }
        return accounts;
    }

    public ArrayList<MobileWareHouse> getVans() {
        return vans;
    }

    public boolean readFile(String file) {
        return mainWH.readFile(file);

    }

   

    public void save() {
        mainWH.save();
        
        try {
            for (MobileWareHouse mwh : vans) {
                String f = mwh.getID() + ".txt";

                PrintWriter pWriter = new PrintWriter(new File(f));
                for (BikePart p : mwh.inventory) {
                    String line = p.getPname() + "," + p.getPNumber() + "," + p.getLPrice() + "," + p.getSPrice() + "," + p.isIsSale() + "," + p.getQuantity(mwh.getID()) + "\n";
                    pWriter.print(line);
                }
                pWriter.close();
                mwh.saveInvocies();
            }
        } catch (FileNotFoundException ex) {
        }

    }

    public void addPart(BikePart part) {
        mainWH.addPart(part);
    }

    /**
     * this method is to sell parts and updates the part quantity.
     *
     * @param pNum represents the part number the user wants to sell.
     * @return String that represents the part information.
     * @throws IOException
     */
    public String sellPartByNum(Account ac,String store,String owner, String pNum, int qty) {

        String result = "";
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        MobileWareHouse vwh = this.findVan(ac);
        String time = sdf.format(d);
        BikePart part = vwh.findPartByNumberInVan(pNum);
        if (part == null || part.getQuantity() == 0) {
            return "Part is undfined or sold out";
        } else {
            if (part.isIsSale()) {
                result = "     " + part.getPname() + "   \t " + part.getSPrice() + "      \t  " + time;

            } else {
                result = "     " + part.getPname() + "   \t " + part.getLPrice() + "      \t  " + time;

            }
          int r =  part.decreaseQty(qty,vwh.getID());
          result += " \nActual qty sold is: "+ r;
            Invoice in = vwh.getInvoice(store+owner);
            if(in==null)
                in = new Invoice(store,owner);
            in.addSoldPart(new BikePart(part, qty));
            vwh.addInvoice(store+owner, in);
        }

        return result;
    }
    
     public String sellPartByName(Account ac,String store,String owner, String pName, int qty) {

        String result = "";
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");

        String time = sdf.format(d);
        MobileWareHouse vwh = this.findVan(ac);
        BikePart part = vwh.findPartByNameinVan(pName);
        if (part == null || part.getQuantity() == 0) {
            return "Part is undfined or sold out";
        } else {
            // System.out.println("\tPart Name\tPart Cost\t On Sale\tTime Sold");
            if (part.isIsSale()) {
                result = "     " + part.getPname() + "   \t " + part.getSPrice() + "      \t  " + time;

            } else {
                result = "     " + part.getPname() + "   \t " + part.getLPrice() + "      \t  " + time;

            }
            int r =  part.decreaseQty(qty,vwh.getID());
          result += " \nActual qty sold is: "+ r;
            Invoice in = vwh.getInvoice(store+owner);
            if(in==null)
                in = new Invoice(store,owner);
            in.addSoldPart(new BikePart(part, qty));
            vwh.addInvoice(store+owner, in);
        }

        return result;
    }

    public String display(String st) {
        return mainWH.display(st);
    }
    public String displayPartByNumber(String st) {
        return mainWH.displayPartByNum(st);
    }

    public String displayByName() {
        return mainWH.displayByName();
    }

    public String displayByNumber() {
        return mainWH.displayByNumber();
    }

    public String displayAllByName() {
        return mainWH.displayAllByName();
    }

    public String displayAllByNum() {
        return mainWH.displayAllByNum();
    }

    public String addVan() {
        MobileWareHouse van = new MobileWareHouse(numberOfVans);
        van.readFile(van.getID() + ".txt");
        van.readInvocies();
        vans.add(van);
        numberOfVans++;
        return van.getID();

    }

    public void readVans(int i) {

        String f = "salesVan" + (char) ('A' + i);
        File file = new File(f + ".txt");

        if (file.exists()) {
            addVan();
            
            readVans(++i);
        }

    }

    public boolean move(String file, String vanName) {
        try {
            File f = new File(file);
            if (!f.exists()) {
                return false;
            }
            Scanner scan = new Scanner(f);
            scan.useDelimiter(",|\\n|\\r\\n");
            String from = scan.next();
            String to = scan.next();
            if(!to.equals(vanName))
                return false;
            //  scan.next();
            while (scan.hasNext()) {
                //scan.next();
                String name = scan.next();
                if (name.equals("")) {
                    continue;
                }
                int qty = scan.nextInt();

                BikePart part;
                WareHouse fwh;
                if (from.equalsIgnoreCase("mainwh")) {
                    fwh = mainWH;
                } else {
                    fwh = findWHByID(from);
                }
                part = fwh.findPartByName(name);
                if (part != null) {
                    part.setLocation(qty, from, to);
                    WareHouse wh = findWHByID(to);

                    wh.addPart(part);
                    // part.decreaseQty(qty);

                } else {

                }

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

    public WareHouse findWHByID(String to) {
        for (MobileWareHouse mwh : vans) {
            if (mwh.getID().equalsIgnoreCase(to)) {
                return mwh;
            }
        }
        return null;
    }

    public WareHouse getMainWareHouse() {
        return mainWH;
    }

    public String displayVansByName() {
        String res = "";
        for (MobileWareHouse mwh : vans) {
            res += mwh.getID() + "\n";
            res += mwh.displayByName(mwh.getID());
            res += "\n--------------------------------\n";
        }
        return res;
    }

    public String displayVansByNumber() {
        String res = "";
        for (MobileWareHouse mwh : vans) {
            res += mwh.getID() + "\n";
            res += mwh.displayByNumber(mwh.getID());
            res += "\n--------------------------------\n";
        }
        return res;
    }

    public void readAccounts() {
        File accFile = new File("Accounts.txt");
        if (!accFile.exists()) {
            return;
        }
        try {
            Scanner scan = new Scanner(accFile);
            while (scan.hasNext()) {
                Account ac = new Account(scan.next(), scan.next(), scan.next(), scan.next(), scan.next(), scan.nextInt());
                accounts.add(ac);
                
                if (ac.getType()==3) {
                    String van = scan.next();
                    for (MobileWareHouse v : vans) {
                        if (v.getID().equals(van)) {
                            v.associate(ac);
                            break;
                        }
                    }
                }

            }
            scan.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void writeAccounts() {
        File accFile = new File("Accounts.txt");

        try {
            PrintWriter pw = new PrintWriter(accFile);
            for (Account ac : accounts) {
                pw.print(ac.toFileString());
                if(ac.getType()==3)
                    pw.println(" "+this.findVan(ac).getID());
            }
            pw.close();
        } catch (Exception ex) {

        }

    }

    public void writeAccounts(Account a, String van) {
        File accFile = new File("Accounts.txt");

        try {
            PrintWriter pw = new PrintWriter(accFile);
            for (Account ac : accounts) {
                if (a == ac) {
                    pw.println(ac.toFileString() + " " + van);
                } else {
                    pw.println(ac.toFileString() + " null");
                }

            }
            pw.close();
        } catch (Exception ex) {

        }

    }

    public void addAcount(String fName, String lName, String email, String uName, String password, int type) {
        accounts.add(new Account(fName, lName, email, uName, password, type));
        writeAccounts();
    }

    public Account findAccount(String username, String password) {

        for (Account ac : accounts) {
            if (ac.getuName().equals(username) && ac.getPassword().equals(password)) {
                return ac;
            }
        }
        return null;
    }

    public MobileWareHouse findVan(Account ac) {
        for (MobileWareHouse v : vans) {
            if (v.getSalesPerson()==ac) {
                return v;
            }
        }
        return null;
    }

   public  String generateInvoice(Account currentAccount, String inID) {
        MobileWareHouse van = this.findVan(currentAccount);
        return van.generateInvoice(inID);
    }

    public String checInventory(int qty) {
        String r = "";
        r = mainWH.getPartsCloseTo(qty);
        return r;
    }

    public ArrayList<Account> getSalesman() {
        
        return salesmanList;
    }

    public String getSalesmanCheck(Account ac, String stDate, String enDate) {
       MobileWareHouse van = this.findVan(ac);
       return van.getSalesmanCheck( stDate,  enDate);
    }
}
