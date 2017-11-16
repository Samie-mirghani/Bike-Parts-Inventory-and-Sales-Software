package project.pkg3;

/**
 * This class will create a bike part and use different gets and sets
 * in order for other classes to operate on.
 * @author Shamsadean Mirghani
 */

public class BikePart {

    private String partName;
    private int partNumber;
    private double listPrice;
    private double salesPrice;
    private int quantity;
    private boolean onSale;

    /**
     * This constructor will create a bike part and will give it all the
     * attributes of a bike part
     *
     * @param partName
     * @param partNumber
     * @param listPrice
     * @param salesPrice
     * @param onSale
     * @param quantity
     */
    public BikePart(String partName, int partNumber, double listPrice, double salesPrice, boolean onSale, int quantity) {
        this.partName = partName;
        this.partNumber = partNumber;
        this.listPrice = listPrice;
        this.salesPrice = salesPrice;
        this.onSale = onSale;
        this.quantity = quantity;
    }

    /**
     * This method will get the partName
     *
     * @return partName
     */
    public String getpartName() {
        return partName;
    }

    /**
     * This method will get the partNumber
     *
     * @return partNumber
     */
    public int getpartNumber() {
        return partNumber;
    }

    /**
     * This method will get the listPrice
     *
     * @return listPrice
     */
    public double getlistPrice() {
        return listPrice;
    }

    /**
     * This method will get the sales price
     *
     * @return salesPrice
     */
    public double getsalesPrice() {
        return salesPrice;
    }

    /**
     * This method will get onSale
     *
     * @return onSale
     */
    public boolean getonSale() {
        return onSale;
    }

    /**
     * This method will get the quantity
     *
     * @return quantity
     */
    public int getquantity() {
        return quantity;
    }

    /**
     * This method will set the quantity
     *
     * @param q
     */
    public void setQuantity(int q) {
        this.quantity = q;
    }

    /**
     * This method will increment or decrement the quantity
     *
     * @param d
     */
    public void addQuantity(int d) {
        this.quantity += d;
    }

}
