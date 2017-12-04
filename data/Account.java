package data;

public class Account {

    private String fName;
    private String lName;
    private String email;
    private String uName;
    private String password;
    private int type; //0=admin, 1=officeManager, 2=whmanager, 3=salesMan

    public Account(String fName, String lName, String email, String uName, String password, int type) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.uName = uName;
        this.password = password;
        this.type = type;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String toFileString() {
        return fName + " " + lName + " " + email + " " + uName + " " + password + " " + type;
    }

    public String toString() {

        return uName;
    }
}
