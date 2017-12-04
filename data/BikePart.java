package data;

import java.io.Serializable;
import java.util.ArrayList;

//implements the intereface Comparator to compare between bikeparts. 
public class BikePart implements Comparable<BikePart>, Serializable {

    //date members
    private String Pname;
    private String PNumber;
    private double LPrice;
    private double SPrice;
    private boolean IsSale;
    private int quantity;
    public static int sortType = 0;
    private ArrayList<PartLocation> locationList;// ID of the wareHouse having the part

    public BikePart(String Pname, String PNumber, double LPrice, double SPrice, boolean IsSale, int quantity) {
        this.Pname = Pname;
        this.PNumber = PNumber;
        this.LPrice = LPrice;
        this.SPrice = SPrice;
        this.IsSale = IsSale;
        this.quantity = quantity;
        locationList = new ArrayList();
        locationList.add(new PartLocation(Pname, quantity, "mainwh"));// 0 is the id of the main WAREhOUSE
    }

    public BikePart(BikePart part, int qty) {
        this.Pname = part.Pname;
        this.PNumber = part.PNumber;
        this.LPrice = part.LPrice;
        this.SPrice = part.SPrice;
        this.IsSale = part.IsSale;
        this.quantity = qty;
    }

    public void setLocation(int qty, String location1, String location2) {
        PartLocation first = null, second = null;
        for (PartLocation loc : locationList) {
            if (loc.getLocation().equalsIgnoreCase(location1)) {
                first = loc;
            }
            if (loc.getLocation().equalsIgnoreCase(location2)) {
                second = loc;
            }
            if (first != null && second != null) {
                break;
            }

        }
        if (first == null)
            ;
        if (second == null) {
            locationList.add(new PartLocation(Pname, qty, location2));
        }
        if (location1.equalsIgnoreCase("mainwh")) {
            this.quantity -= qty;
        }
        int q = first.decreaseQty(qty);
        if (second != null)
            second.addQty(q);
    }

    public String getPname() {
        return Pname;
    }

    public String getPNumber() {
        return PNumber;
    }

    public double getLPrice() {
        return LPrice;
    }

    public double getSPrice() {
        return SPrice;
    }

    public boolean isIsSale() {
        return IsSale;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPname(String Pname) {
        this.Pname = Pname;
    }

    public void setPNumber(String PNumber) {
        this.PNumber = PNumber;
    }

    public void setLPrice(double LPrice) {
        this.LPrice = LPrice;
    }

    public void setSPrice(double SPrice) {
        this.SPrice = SPrice;
    }

    public void setIsSale(boolean IsSale) {
        this.IsSale = IsSale;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public String toString() {
        String t = "";
        if (Pname.length() < 9) {
            t = "\t";
        }
       // String r = String.format("%-50s\t%-35s\t%-10f\t%-10f\t%b\t%d", Pname + t, PNumber, LPrice, SPrice, IsSale, quantity);
       String r = String.format("%-50s\t%-35s\t%-15.2f\t%-12.2f\t%-10d", Pname + t, PNumber, LPrice, SPrice, quantity);
        return r;

    }

    public String toStringInvoice() {
        String t = "";
        if (Pname.length() < 9) {
            t = "\t";
        }

        String r = String.format("%-50s\t%-35s\t%-15.2f\t%-12.2f\t%-10d\t%.2f", Pname + t, PNumber, LPrice, SPrice, quantity, getTotalPrice());
        return r;

    }

    public double getTotalPrice() {
        double total;
        if (IsSale) {
            total = quantity * SPrice;
        } else {
            total = quantity * LPrice;
        }
        return total;
    }

    public void decreaseQTY() {

        quantity--;
    }

    @Override
    public int compareTo(BikePart o) {
        if (sortType == 1) {
            return this.PNumber.compareTo(o.PNumber);
        } else {
            return this.Pname.compareToIgnoreCase(o.Pname);
        }
    }

    public boolean isSoldOut() {
        if (this.quantity > 0) {
            return false;
        }
        int i = 0;
        for (PartLocation loc : locationList) {
            if (i == 0) {
                i++;
                continue;
            }
            if (loc.getQty() > 0) {
                return false;
            }
        }
        return true;
    }

    public void decreaseQty(int qty) {
        this.quantity -= qty;
    }
     public int decreaseQty(int qty, String location) {
        for (PartLocation loc : locationList) {
            if (loc.getLocation().equalsIgnoreCase(location)) {
                return loc.decreaseQty(qty);
            }
        }
        return -1;
     }

    public void addLocation(String id, int q) {
        locationList.add(new PartLocation(Pname, q, id));
    }

    public int getQuantity(String id) {
        for (PartLocation loc : locationList) {
            if (loc.getLocation().equals(id)) {
                return loc.getQty();
            }
        }
        return 0;
    }

    public int getAllQuantity() {
        int sum = 0;
        for (PartLocation loc : locationList) {
            sum += loc.getQty();
        }
        return sum;
    }

    public String getVanInfo(String loc) {
        String t = "";
        if (Pname.length() < 9) {
            t = "\t";
        }
        String r = String.format("%-50s\t%-35s\t%-10f\t%-10f\t%b\t%d", Pname + t, PNumber, LPrice, SPrice, IsSale, getQuantity(loc));
        return r;
    }

    public String getAllInfo() {
        String t = "";
        if (Pname.length() < 9) {
            t = "\t";
        }
        String r = String.format("%-50s\t%-35s\t%-10f\t%-10f\t%b\t%d", Pname + t, PNumber, LPrice, SPrice, IsSale, getAllQuantity());
        return r;
    }

}
