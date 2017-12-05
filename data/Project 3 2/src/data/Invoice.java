package data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Invoice implements Serializable{

    private String storeName;
    private String storeOwner;
    private Date invoiceDate;
    private ArrayList<BikePart> soldParts = new ArrayList<>();
    /**
     * Constructor for Invoice object.
     * @param storeName String.
     * @param storeOwner String.
     */
    public Invoice(String storeName, String storeOwner) {
        this.storeName = storeName;
        this.storeOwner = storeOwner;
        invoiceDate = new Date();
    }
    /**
     * Getter for storeName.
     * @return storeName String.
     */
    public String getStoreName() {
        return storeName;
    }
    /**
     * Setter for a new storeName.
     * @param storeName String: gets assigned to Invoice's storeName.
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    /**
     * Getter for storeOwner.
     * @return storeOwner String.
     */
    public String getStoreOwner() {
        return storeOwner;
    }
    /**
     * Sets new storeOwner
     * @param storeOwner String: gets assigned to Invoice's storeOwner.
     */
    public void setStoreOwner(String storeOwner) {
        this.storeOwner = storeOwner;
    }
    /**
     * Getter for invoiceDate object.
     * @return Date object.
     */
    public Date getInvoiceDate() {
        return invoiceDate;
    }
    /**
     * Sets a new invoiceDate.
     * @param invoiceDate Date: assigned to invoiceDate.
     */
    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
    /**
     * Getter for ArrayList of parts sold.
     * @return soldParts ArrayList.
     */
    public ArrayList<BikePart> getSoldParts() {
        return soldParts;
    }
    /**
     * Sets new ArrayList for soldParts.
     * @param soldParts ArrayList.
     */
    public void setSoldParts(ArrayList<BikePart> soldParts) {
        this.soldParts = soldParts;
    }
    /**
     * Adds a part to ArrayList.
     * @param p BikePart: added to soldParts ArrayList.
     */
    public void addSoldPart(BikePart p) {
        soldParts.add(p);
    }
    /**
     * Creates an invoice for the sale.
     * @return res String: contains part sold, where it was sold, date it was
     * sold, and store owner receiving it.
     */
    public String generateInvoice() {
        String res = "";
        String dateFormat1, dateFormat2;
        SimpleDateFormat sdf = new SimpleDateFormat("MMMMM dd, yyyy");
        dateFormat1 = sdf.format(invoiceDate);

        sdf = new SimpleDateFormat("hh:mm a");
        dateFormat2 = sdf.format(invoiceDate);
        res = "Sales Invoice for " + this.storeName + ", " + dateFormat1 + " at " + dateFormat2 + "\n";
        String r = String.format("%-50s\t%-35s\t%-10s\t%-15s\t%-10s\t%s", "Part Name", "Part Number", "Price", "Sales Price", "Qnty", "Total Cost");
        res += r + "\n";
        double total = 0;
        for (BikePart p : soldParts) {
            res += p.toStringInvoice() + "\n";
            total += p.getTotalPrice();
        }
        r = String.format("Total\t\t%150.2f", total);
        res += r + "\n\n";
        res += "Received By Signature: " + this.storeOwner + " the Owner\n";

        return res;
    }
    /**
     * Getter for total amount of sales.
     * @return total double: sum of all prices for which items were sold.
     */
    public double getTotal()
    {
       double total = 0;
        for (BikePart p : soldParts) {
            total += p.getTotalPrice();
        } 
        return total;
    }
    
   

}
