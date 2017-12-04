package data;


public class PartLocation {
    private String partName;
    private int qty;
    private String location;

    public PartLocation(String partName, int qty, String location) {
        this.partName = partName;
        this.qty = qty;
        this.location = location;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public int getQty() {
        return qty;
    }

    public void addQty(int qty) {
        this.qty += qty;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

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
