
package project.pkg3;

import data.BikePart;
import data.Account;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author shamsadeanmirghani
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TabPane tabPane;

    @FXML
    private TextArea wOutput;

    @FXML
    private Tab officeManager;
    @FXML
    private TextField pName;
    @FXML
    private TextField pNum;
    @FXML
    private TextField pList;
    @FXML
    private TextField pSales;
    @FXML
    private TextField pOnsale;

    @FXML
    private TextField pQuan;

    @FXML
    private Tab Salesman;
    @FXML
    private TextField moveTF;

    @FXML
    private Tab WHmanager;
    @FXML
    private TextField name;
    @FXML
    private TextField number;
    @FXML
    private TextField list;
    @FXML
    private TextField salesPrice;
    @FXML
    private TextField onSale;
    @FXML
    private TextField quant;

    @FXML
    private TextArea whOutput;
    @FXML

    private Tab systemAdmin;

    private ArrayList<BikePart> bpa = new ArrayList();
    private File wareHouse = new File(System.getProperty("user.dir") + "\\warehouseDB.txt");
    private ArrayList<WareHouse> fleet = new ArrayList<>();
    @FXML
    private TextArea sOutput;
    @FXML
    private TextArea saOutput;
    @FXML
    private TextArea omOutput;

    @FXML
    private TextField usernameTF;
    @FXML
    private TextField shopNTF;
    @FXML
    private TextField shopOTF;

    @FXML
    private PasswordField passwordTF;
    @FXML
    private Button generateInvB;

    @FXML
    private Button sellNB;
    @FXML
    private Button sellNumB;

    ObservableList<String> options
            = FXCollections.observableArrayList(
                    "Admin",
                    "Office Manager",
                    "WareHouse Manager",
                    "Saleman"
            );

    @FXML
    private ComboBox accountTypeCB;

    @FXML
    private TextField fNameTF;

    @FXML
    private TextField lNameTF;

    @FXML
    private TextField emailTF;
    @FXML
    private TextField pNameTF;
    @FXML
    private TextField pNumTF;
    @FXML
    private TextField qtyTF;

    @FXML
    private TextField uNameTF;

    @FXML
    private TextField passTF;

    @FXML
    private Label msgL;

    @FXML
    private ListView accountsList;
    @FXML
    private ListView vansList;

    @FXML
    private TextArea adminMsgTA;

    @FXML
    private TextArea whmOutput;

    @FXML
    private Button addAccountB;
    @FXML
    private Button updateAccountB;

    @FXML
    private TextField pNameETF;

    @FXML
    private TextField pNumETF;

     @FXML
    private TextField pNameETF1;

    @FXML
    private TextField pNumETF1;
    
    @FXML
    private TextField startDateTF;

    @FXML
    private TextField endDateTF;

    @FXML
    private ListView salesmanList;

    Account currentAccount;

    @FXML
    private void paySalesmanAction(ActionEvent event) {
        int index = salesmanList.getSelectionModel().getSelectedIndex();
        if (index < 0) {
            omOutput.setText("You have to select a salesman first");
            return;
        }
        String stDate = startDateTF.getText();
        String enDate = endDateTF.getText();
        if (stDate.equals("") || enDate.equals("")) {
            omOutput.setText("You have to input start and end  dates");
            return;
        }
        Account ac = WareHouseManager.manager.getSalesman().get(index);
        String s = WareHouseManager.manager.getSalesmanCheck(ac, stDate, enDate);
        omOutput.setText(s);

    }

    @FXML
    private void checkInvAction(ActionEvent event) {
        String s = WareHouseManager.manager.checInventory(10);
        omOutput.setText(s);
    }

    @FXML
    private void examineNAction(ActionEvent event) {
        String part = pNameETF.getText();
        String r = String.format("%-50s\t%-35s\t%-10s\t%-15s\t%-10s", "Part Name", "Part Number", "Price", "Sales Price", "Qnty");
        String s = r + "\n" + WareHouseManager.manager.display(part);
        omOutput.setText(s);
    }

    @FXML
    private void examineNumAction(ActionEvent event) {
        String part = pNumETF.getText();
        String r = String.format("%-50s\t%-35s\t%-10s\t%-15s\t%-10s", "Part Name", "Part Number", "Price", "Sales Price", "Qnty");
        String s = r + "\n" + WareHouseManager.manager.displayPartByNumber(part);
        omOutput.setText(s);
    }

    @FXML
    private void examineNWHAction(ActionEvent event) {
        String part = pNameETF1.getText();
        String r = String.format("%-50s\t%-35s\t%-10s\t%-15s\t%-10s", "Part Name", "Part Number", "Price", "Sales Price", "Qnty");
        String s = r + "\n" + WareHouseManager.manager.display(part);
        whmOutput.setText(s);
    }

    @FXML
    private void examineNumWHAction(ActionEvent event) {
        String part = pNumETF1.getText();
        String r = String.format("%-50s\t%-35s\t%-10s\t%-15s\t%-10s", "Part Name", "Part Number", "Price", "Sales Price", "Qnty");
        String s = r + "\n" + WareHouseManager.manager.displayPartByNumber(part);
        whmOutput.setText(s);
    }

    @FXML
    private void addVanAction(ActionEvent event) {
        String s = WareHouseManager.manager.addVan();
        vansList.getItems().add(s);
        adminMsgTA.setText("the sales van " + s + " has been \nadded to the fleet succesfully");

    }

    @FXML
    private void addOrderAction(ActionEvent event) {
        Node node = (Node) event.getSource();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Update file");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(node.getScene().getWindow());
        if (file == null) {
            return;
        }
        if (WareHouseManager.manager.readFile(file.getPath())) {
            omOutput.setText("Order added to inventory \n");
        } else {
            omOutput.setText("Error reading file \n");
        }
    }

    @FXML
    private void updateInventoryAction(ActionEvent event) {
        Node node = (Node) event.getSource();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Update file");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(node.getScene().getWindow());
        if (file == null) {
            return;
        }
        if (WareHouseManager.manager.readFile(file.getPath())) {
            whmOutput.setText("inventory updated \n");
        } else {
            whmOutput.setText("Error reading file \n");
        }

        
    }

    @FXML
    private void enterShopAction(ActionEvent event) {
        String shopN = shopNTF.getText().trim();
        String shopO = shopOTF.getText().trim();
        if (shopN.equals("") || shopO.equals("")) {
            sOutput.setText("shop name/owner cannot be empty");
            return;
        }
        shopNTF.setDisable(true);
        shopOTF.setDisable(true);

        sellNB.setDisable(false);
        sellNumB.setDisable(false);
    }

    @FXML
    private void sellNAction(ActionEvent event) {
        String q = qtyTF.getText().trim();
        String shopN = shopNTF.getText().trim();
        String shopO = shopOTF.getText().trim();
        if (q.equals("")) {
            sOutput.setText("Qty cannot be empty");
            return;
        }
        int qty = Integer.parseInt(q);
        String partN = pNameTF.getText();
        if (partN.equals("")) {
            sOutput.setText("Part name cannot be empty");
            return;
        }
        String s = WareHouseManager.manager.sellPartByName(currentAccount, shopN, shopO, partN, qty);
        sOutput.setText("Part sold \n" + s);
        generateInvB.setDisable(false);
    }

    @FXML
    private void sellNumAction(ActionEvent event) {
        String q = qtyTF.getText().trim();
        String shopN = shopNTF.getText().trim();
        String shopO = shopOTF.getText().trim();
        if (q.equals("")) {
            sOutput.setText("Qty cannot be empty");
            return;
        }
        int qty = Integer.parseInt(q);
        String partN = pNumTF.getText();
        if (partN.equals("")) {
            sOutput.setText("Part number cannot be empty");
            return;
        }
        String s = WareHouseManager.manager.sellPartByNum(currentAccount, shopN, shopO, partN, qty);
        sOutput.setText("Part sold \n" + s);
        generateInvB.setDisable(false);

    }

    @FXML
    private void generateInvAction(ActionEvent event) {
        String shopN = shopNTF.getText().trim();
        String shopO = shopOTF.getText().trim();
        String s = WareHouseManager.manager.generateInvoice(currentAccount, shopN + shopO);
        sOutput.setText(s);
        generateInvB.setDisable(true);
        shopNTF.setDisable(false);
        shopOTF.setDisable(false);

        sellNB.setDisable(true);
        sellNumB.setDisable(true);
    }

    @FXML
    private void moveAction(ActionEvent event) {
        String userInput = moveTF.getText();
        String vanName = WareHouseManager.manager.findVan(currentAccount).getID();
        if (WareHouseManager.manager.move(userInput, vanName)) {
            sOutput.setText("Parts moved succesfully");
        } else {
            sOutput.setText("Error .. Parts failed to move.. You are not allowed to move to a van not associted with you");
        }
    }

    @FXML
    private void loginAction(ActionEvent event) {
        // wOutput.appendText("Welcome to the Bicycle Parts Distributorship database \n");
        //Will create a file calle "warehouseDB.txt" in the user's current 
        //directory
        wOutput.setText("");
        String username = usernameTF.getText().trim();
        String password = passwordTF.getText().trim();
        if (username.equals("")) {
            wOutput.appendText("Username cannot be empty\n");
            return;
        }
        if (password.equals("")) {
            wOutput.appendText("Password cannot be empty\n");
            return;
        }

        if (username.equals("admin") && password.equals("admin")) {
            systemAdmin.setDisable(false);
            wOutput.setText("Login is successful. \nYou can now go to the System Admin Tab");
            return;
        }

        currentAccount = WareHouseManager.manager.findAccount(username, password);
        if (currentAccount == null) {
            wOutput.setText("username and/or password are inccorrect");
            return;
        }
        switch (currentAccount.getType()) {
            case 0: //admin
                systemAdmin.setDisable(false);

                break;
            case 1: //office manager
                officeManager.setDisable(false);
                break;

            case 2: //warehouse manager

                WHmanager.setDisable(false);
                break;

            case 3: //saleman
                Salesman.setDisable(false);
                break;

        }
        wOutput.setText("Login is successful.");
        

    }

    @FXML
    private void handleExitAction(ActionEvent event) throws IOException {
     //   WareHouseManager.manager.save();
        Platform.exit();

    }

    @FXML
    private void associateAction(ActionEvent event) {
        String s = WareHouseManager.manager.addVan();
        vansList.getItems().add(s);
        adminMsgTA.setText("the sales van " + s + " has been \nadded to the fleet succesfully");
        int index1 = accountsList.getSelectionModel().getSelectedIndex();
        if (index1 < 0) {
            adminMsgTA.setText("You have to select a salesman account first");
            return;
        }
        currentAccount = WareHouseManager.manager.getAccounts().get(index1);
        if (currentAccount.getType() != 3) {
            adminMsgTA.setText("The account is not a salesman account\nYou have to select a sale person account first");
            return;
        }

        int index2 = vansList.getSelectionModel().getSelectedIndex();
        if (index2 < 0) {
            adminMsgTA.setText("You have to select a sales van first");
            return;
        }
        MobileWareHouse salesVan = WareHouseManager.manager.getVans().get(index2);
        salesVan.associate(currentAccount);
        adminMsgTA.setText(currentAccount.getuName() + " is now associated with the van " + salesVan.getID());
        WareHouseManager.manager.writeAccounts(currentAccount, salesVan.getID());
    }

    @FXML
    private void editAccountAction(ActionEvent event) throws IOException {
        int index = accountsList.getSelectionModel().getSelectedIndex();
        if (index < 0) {
            adminMsgTA.setText("You have to select an account first");
        } else {
            currentAccount = WareHouseManager.manager.getAccounts().get(index);
            fNameTF.setText(currentAccount.getfName());
            lNameTF.setText(currentAccount.getlName());
            emailTF.setText(currentAccount.getEmail());
            uNameTF.setText(currentAccount.getuName());
            passTF.setText(currentAccount.getPassword());
            int type = currentAccount.getType();
            accountTypeCB.getSelectionModel().select(type);
            addAccountB.setDisable(true);
            updateAccountB.setDisable(false);

        }
    }

    @FXML
    private void deleteAccountAction(ActionEvent event) throws IOException {

        int index = accountsList.getSelectionModel().getSelectedIndex();
        if (index < 0) {
            adminMsgTA.setText("You have to select an account first");
        } else {

            WareHouseManager.manager.getAccounts().remove(index);
            accountsList.getItems().remove(index);
            WareHouseManager.manager.writeAccounts();
            adminMsgTA.setText("Account Deleted");
        }
    }

    @FXML
    private void updateAccountAction(ActionEvent event) throws IOException {
        String fName, lName, email, uName, password;
        fName = fNameTF.getText();
        lName = lNameTF.getText();
        email = emailTF.getText();
        uName = uNameTF.getText().trim();
        password = passTF.getText().trim();
        int type = accountTypeCB.getSelectionModel().getSelectedIndex();

        currentAccount.setfName(fName);
        currentAccount.setlName(lName);
        currentAccount.setEmail(email);
        currentAccount.setuName(uName);
        currentAccount.setPassword(password);
        currentAccount.setType(type);
        WareHouseManager.manager.writeAccounts();
        accountsList.getItems().clear();
        accountsList.getItems().addAll(WareHouseManager.manager.getAccounts());
        addAccountB.setDisable(false);
        updateAccountB.setDisable(true);
        fNameTF.setText("");
        lNameTF.setText("");
        emailTF.setText("");
        uNameTF.setText("");
        passTF.setText("");
        accountTypeCB.getSelectionModel().clearSelection();
        adminMsgTA.setText("Account has been updated");
    }

    @FXML
    private void logoutAction(ActionEvent event) throws IOException {
        //   WareHouseManager.manager.save();
        //    Platform.exit();
        systemAdmin.setDisable(true);
        officeManager.setDisable(true);
        WHmanager.setDisable(true);
        Salesman.setDisable(true);
        passwordTF.setText("");
        tabPane.getSelectionModel().select(0);
        WareHouseManager.manager.save();
    }

   


   
    
    @FXML
    private void handleWHEnterAction(Event event) {
        //grabs all the information that was entered into the text fields

        String partName = name.getText();
        String partNum = number.getText();
        String listPrice = list.getText();
        String sale = salesPrice.getText();
        String cheap = onSale.getText();
        String quantity = quant.getText();
        double price = Double.parseDouble(listPrice);
        double salePrice = Double.parseDouble(sale);
        boolean buy = Boolean.parseBoolean(cheap);
        int rQuantity = Integer.parseInt(quantity);
        
        BikePart part = new BikePart(partName, partNum, price, salePrice, buy, rQuantity);
        WareHouseManager.manager.addPart(part);
        whOutput.appendText("Part was added! \n");

    }

    @FXML
    private void handleOMEnterAction(Event event) {
        //grabs all the information that was entered into the text fields
        String partName = pName.getText();
        String partNum = pNum.getText();
        String listPrice = pList.getText();
        String sale = pSales.getText();
        String cheap = pOnsale.getText();
        String quantity = pQuan.getText();
        double price = Double.parseDouble(listPrice);
        double salePrice = Double.parseDouble(sale);
        boolean buy = Boolean.parseBoolean(cheap);
        int rQuantity = Integer.parseInt(quantity);
        BikePart part = new BikePart(partName, partNum, price, salePrice, buy, rQuantity);
        WareHouseManager.manager.addPart(part);
        whOutput.appendText("Part was added! \n");

    }

 


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        accountTypeCB.setItems(options);
        WareHouseManager.manager = new WareHouseManager();
        wOutput.appendText("Welcome to the Bicycle Parts Distributorship database \n");
        accountsList.getItems().addAll(WareHouseManager.manager.getAccounts());
        vansList.getItems().addAll(WareHouseManager.manager.getVans());
        accountsList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Account>() {
            @Override
            public void changed(ObservableValue<? extends Account> observable, Account oldValue, Account newValue) {
                int index = accountsList.getSelectionModel().getSelectedIndex();
                currentAccount = WareHouseManager.manager.getAccounts().get(index);
                if (currentAccount.getType() == 3) {
                    MobileWareHouse van = WareHouseManager.manager.findVan(currentAccount);
                    if (van != null) {
                        adminMsgTA.setText(currentAccount.getuName() + " is  associated with \nthe van " + van.getID());
                    } else {
                        adminMsgTA.setText(currentAccount.getuName() + " is not associated with any the van ");
                    }
                }
            }
        });

        salesmanList.getItems().addAll(WareHouseManager.manager.getSalesman());
    }



    
   


    @FXML
    private void addAccountActon(Event event) throws IOException {

        String fName, lName, email, uName, password;
        fName = fNameTF.getText();
        lName = lNameTF.getText();
        email = emailTF.getText();
        uName = uNameTF.getText().trim();
        password = passTF.getText().trim();
        int type = accountTypeCB.getSelectionModel().getSelectedIndex();
        if (uName.equals("") || password.equals("")) {
            msgL.setText("username and/or password cannot be empty");
            return;
        }
        if (type < 0) {
            msgL.setText("type needs to be selecteted");
            return;
        }

        WareHouseManager.manager.addAcount(fName, lName, email, uName, password, type);
        accountsList.getItems().add(WareHouseManager.manager.getAccounts().get(WareHouseManager.manager.getAccounts().size() - 1));
    }

}
