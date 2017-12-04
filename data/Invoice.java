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

    public Invoice(String storeName, String storeOwner) {
        this.storeName = storeName;
        this.storeOwner = storeOwner;
        invoiceDate = new Date();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreOwner() {
        return storeOwner;
    }

    public void setStoreOwner(String storeOwner) {
        this.storeOwner = storeOwner;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public ArrayList<BikePart> getSoldParts() {
        return soldParts;
    }

    public void setSoldParts(ArrayList<BikePart> soldParts) {
        this.soldParts = soldParts;
    }

    public void addSoldPart(BikePart p) {
        soldParts.add(p);
    }

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
    public double getTotal()
    {
       double total = 0;
        for (BikePart p : soldParts) {
            total += p.getTotalPrice();
        } 
        return total;
    }
    
   

}
