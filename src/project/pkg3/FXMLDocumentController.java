/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author shamsadeanmirghani
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Tab welcome;
    @FXML
    private TextArea wOutput;
    @FXML
    private Button start;
    @FXML
    private Button exit;
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
    private Button enter;
    @FXML
    private TextField pQuan;
    @FXML
    private Button read;
    @FXML
    private Button check;
    @FXML
    private TextField salesmanField;
    @FXML
    private Button paySalesman;
    @FXML
    private TextArea oOutput;
    @FXML
    private Button oExit;
    @FXML
    private Tab Salesman;
    @FXML
    private TextField vantoVan;
    @FXML
    private Button vanButton;
    @FXML
    private TextField whtoVan;
    @FXML
    private Button WHtoVanButton;
    @FXML
    private TextField salesmanName;
    @FXML
    private Button displayButton;
    @FXML
    private TextField pNumberField;
    @FXML
    private Button sellButton;
    @FXML
    private TextArea salesmanOutput;
    @FXML
    private Button sExit;
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
    private Button whEnter;
    @FXML
    private TextArea whOutput;
    @FXML
    private Button whExit;
    @FXML
    private Tab systemAdmin;
    @FXML
    private TextField managerField;
    @FXML
    private TextField salesman;
    @FXML
    private TextField warhouseField;
    @FXML
    private TextField salesVan;
    @FXML
    private TextField addSalesman;
    @FXML
    private Button OfficeManager;
    @FXML
    private Button SalesmanButton;
    @FXML
    private Button addWHmanager;
    @FXML
    private Button salesvanButton;
    @FXML
    private Button salesManButton;
    @FXML
    private Button exitAdmin;
    @FXML
    private AnchorPane outputSystemAdmin;
    private ArrayList<BikePart> bpa = new ArrayList();
    private File wareHouse = new File(System.getProperty("user.dir") + "\\warehouseDB.txt");
    private ArrayList<WareHouse> fleet = new ArrayList<>();

    private void handleButtonAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Update file");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        //fileChooser.showOpenDialog(stage);
    }

    @FXML
    private void handlestartAction(ActionEvent event) throws FileNotFoundException {
        wOutput.appendText("Welcome to the Bicycle Parts Distributorship database \n");
        //Will create a file calle "warehouseDB.txt" in the user's current 
        //directory
        File wareHouse = new File(System.getProperty("user.dir") + "\\warehouseDB.txt");
        //If statement that will test if the file already exisits or not
        //If not, it will be created
        if (wareHouse.exists()) {
            wOutput.appendText("The File Exists \n");
            Scanner fileScanner = new Scanner(wareHouse);
            //A while loop is used to contiue to read the file until there is
            //nothing left to read
            while (fileScanner.hasNext()) {
                String next = fileScanner.nextLine();
                String[] elements = next.split(",");
                bpa.add(new BikePart(elements[0],
                        Integer.parseInt(elements[1]),
                        Double.parseDouble(elements[2]),
                        Double.parseDouble(elements[3]),
                        Boolean.parseBoolean(elements[4]),
                        Integer.parseInt(elements[5])));
            }
        } else {
            wOutput.appendText("The warehouseDB.txt file has been created \n");
            try {
                wareHouse.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void handleExitAction(ActionEvent event) throws IOException {
        writeText(wareHouse, bpa);
        Platform.exit();

    }

    private void handleOfficeAction(ActionEvent event) throws IOException {
        Parent passwordWindow = FXMLLoader.load(getClass().getResource("Password.fxml"));
        Scene scene = new Scene(passwordWindow);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    private void handleSalesAction(Event event) {
    }

    @FXML
    private void handleWHAction(Event event) {
    }

    @FXML
    private void handleAdminAction(Event event) {
    }

    /**
     * This program will operate when a user tries to enter in a new part
     *
     * @param event
     */
    @FXML
    private void handleWHEnterAction(Event event) {
        //grabs all the information that was entered into the text fields
        String partName = name.getText();
        String partNum = number.getText();
        String listPrice = list.getText();
        String sale = salesPrice.getText();
        String cheap = onSale.getText();
        String quantity = quant.getText();
        ArrayList<BikePart> temp = new ArrayList();
        int num = Integer.parseInt(partNum);
        double price = Double.parseDouble(listPrice);
        double salePrice = Double.parseDouble(sale);
        boolean buy = Boolean.parseBoolean(cheap);
        int rQuantity = Integer.parseInt(quantity);
        BikePart ePart = new BikePart(partName, num, price, salePrice, buy, rQuantity);
        bpa.add(ePart);
        whOutput.appendText("Part was added! \n");

    }

    /**
     * This program will operate when a user tries to enter in a new part
     *
     * @param event
     */
    @FXML
    private void handleOMEnterAction(Event event) {
        //grabs all the information that was entered into the text fields
        String partName = pName.getText();
        String partNum = pNum.getText();
        String listPrice = pList.getText();
        String sale = pSales.getText();
        String cheap = pOnsale.getText();
        String quantity = pQuan.getText();
        ArrayList<BikePart> temp = new ArrayList();
        int num = Integer.parseInt(partNum);
        double price = Double.parseDouble(listPrice);
        double salePrice = Double.parseDouble(sale);
        boolean buy = Boolean.parseBoolean(cheap);
        int rQuantity = Integer.parseInt(quantity);
        BikePart qPart = new BikePart(partName, num, price, salePrice, buy, rQuantity);
        bpa.add(qPart);
        oOutput.appendText("Part was added! \n");

    }

    /**
     * Reads a file
     *
     * @param fileName
     * @return retList
     */
    public static ArrayList readText(String fileName) {
        ArrayList<BikePart> retList = null;
        if (fileName == null || fileName.equals("")) {
            return retList;
        }
        File file = new File(fileName);
        return null;
    }

    /**
     * Writes to a file
     *
     * @param fileName the name of a file that will be written into
     * @param bpa ArrayList that will be saved into the file
     * @throws IOException
     */
    public static void writeText(File fileName, ArrayList<BikePart> bpa) throws IOException {
        FileWriter fWriter = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(fWriter);
        for (int i = 0; i < bpa.size(); i++) {
            bw.write(bpa.get(i).getpartName() + "," + bpa.get(i).getpartNumber()
                    + ","
                    + bpa.get(i).getlistPrice()
                    + ","
                    + bpa.get(i).getsalesPrice()
                    + ","
                    + bpa.get(i).getonSale()
                    + ","
                    + bpa.get(i).getquantity());
            bw.newLine();
        }
        bw.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
