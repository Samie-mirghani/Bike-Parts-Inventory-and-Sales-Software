package data;

public class Account {

    private String fName;
    private String lName;
    private String email;
    private String uName;
    private String password;
    private int type; //0=admin, 1=officeManager, 2=whmanager, 3=salesMan
    /**
     * Constructor for new Account object.
     */
    public Account(String fName, String lName, String email, String uName, String password, int type) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.uName = uName;
        this.password = password;
        this.type = type;
    }
    /**
     * Getter for first name assigned to account.
     * @return fName String.
     */
    public String getfName() {
        return fName;
    }
    /**
     * Sets new first name.
     * @param fName String.
     */
    public void setfName(String fName) {
        this.fName = fName;
    }
    /**
     * Getter for last name assigned to account.
     * @return lName String.
     */
    public String getlName() {
        return lName;
    }
    /**
     * Sets new last name.
     * @param lName String.
     */
    public void setlName(String lName) {
        this.lName = lName;
    }
    /**
     * Getter for email.
     * @return email Sting.
     */
    public String getEmail() {
        return email;
    }
    /**
     * Sets new email.
     * @param email String.
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Getter for user name.
     * @return uName String.
     */
    public String getuName() {
        return uName;
    }
    /**
     * Sets new user name.
     * @param uName String.
     */
    public void setuName(String uName) {
        this.uName = uName;
    }
    /**
     * Getter for password.
     * @return password String.
     */
    public String getPassword() {
        return password;
    }
    /**
     * Sets new password.
     * @param password String.
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Getter for type of account.
     * @return type int.
     */
    public int getType() {
        return type;
    }
    /**
     * Sets a new account type.
     * @param type int.
     */
    public void setType(int type) {
        this.type = type;
    }
    /**
     * Generates Account object in string format.
     * @return Account values in string.
     */
    public String toFileString() {
        return fName + " " + lName + " " + email + " " + uName + " " + password + " " + type;
    }

    public String toString() {

        return uName;
    }
}
