package data;


public class PartLocation {
    private String partName;
    private int qty;
    private String location;
    /**
     * Constructor for PartLocation object.
     * @param partName String: name of part.
     * @param qty int: quantity of part in its location
     * @param location String: name of WareHouse object where to find part.
     */
    public PartLocation(String partName, int qty, String location) {
        this.partName = partName;
        this.qty = qty;
        this.location = location;
    }
    /**
     * Getter for partName.
     * @return partName string.
     */
    public String getPartName() {
        return partName;
    }
    /**
     * Setter for partName.
     * @param partName String: gets assigned to PartLocation's partName.
     */
    public void setPartName(String partName) {
        this.partName = partName;
    }
    /**
     * Getter for quantity of the part.
     * @return qty int.
     */
    public int getQty() {
        return qty;
    }
    /**
     * Adds a certain amount to the part's current quantity.
     * @param qty int: amount to be added.
     */
    public void addQty(int qty) {
        this.qty += qty;
    }
    /**
     * Getter for the location of a part.
     * @return location String.
     */
    public String getLocation() {
        return location;
    }
    /**
     * Sets a new location to the part.
     * @param location String: name of location.
     */
    public void setLocation(String location) {
        this.location = location;
    }
    /**
     * Subtracts a certain amount from quantity.
     * @param qty int: amount to be subtracted.
     * @return decremented qty int.
     */
    int decreaseQty(int qty) {
        if(this.qty>=qty){
            this.qty-=qty;
            return qty;
        }
        else
        {
            qty= this.qty;
            this.qty=0;
            return qty;
        }
        
    }
    
    
}
