/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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

    @FXML
    private void handleButtonAction(ActionEvent event) throws FileNotFoundException, IOException {
        Node node = (Node) event.getSource();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Update file");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(node.getScene().getWindow());

        if (file != null) {
            file.getPath();
        }
        ArrayList<BikePart> delivery = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(wareHouse));
        reader = new BufferedReader(new FileReader(file.getPath()));
        int num = 0;
        while (reader.readLine() != null) {
            num++;
        }
        reader.close();
        reader = new BufferedReader(new FileReader(file.getPath()));
        for (int i = 0; i < num; i++) {
            String line = reader.readLine();
            String[] elements = line.split(",");
            BikePart bp = new BikePart(elements[0],
                    Integer.parseInt(elements[1]),
                    Double.parseDouble(elements[2]),
                    Double.parseDouble(elements[3]),
                    Boolean.parseBoolean(elements[4]),
                    Integer.parseInt(elements[5]));
            boolean g = false;
            for (BikePart f : bpa) {
                if (f.getpartNumber() == bp.getpartNumber()) {
                    f.addQuantity(bp.getquantity());
                    g = true;
                    break;
                }
            }
            if (!g) {
                bpa.add(bp);
            }
        }
        // Loops through ArrayList and deterimines if there are any of
        // The same parts in the delivery file. If so, the quantity will
        // be adjusted
        boolean found;
        int index;
        for (int i = 0; i < delivery.size(); i++) {
            found = false;
            index = -1;
            for (int j = 0; i < bpa.size(); j++) {
                BikePart b1 = delivery.get(i);
                BikePart b2 = bpa.get(j);
                if (b1.getpartName().equalsIgnoreCase(b2.getpartName())) {
                    found = true;
                    index = j;
                    break;
                }
            }
            if (found) {
                int b1 = delivery.get(i).getquantity();
                int b2 = bpa.get(index).getquantity();
                bpa.get(index).setQuantity(b1 + b2);
            } else {
                bpa.add(delivery.get(i));
            }
        }

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

    @FXML
        private void handleSalesAction(Event event) throws IOException {
        Parent passwordWindow = FXMLLoader.load(getClass().getResource("Password.fxml"));
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Login Window");
        stage.setScene(new Scene(passwordWindow));
        stage.show();
    }

    @FXML
        private void handleWHAction(Event event) throws IOException {
        Parent passwordWindow = FXMLLoader.load(getClass().getResource("Password.fxml"));
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Login Window");
        stage.setScene(new Scene(passwordWindow));
        stage.show();
    }

    @FXML
        private void handleAdminAction(Event event) throws IOException {
        Parent passwordWindow = FXMLLoader.load(getClass().getResource("Password.fxml"));
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Login Window");
        stage.setScene(new Scene(passwordWindow));
        stage.show();
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
        for(int i = 0; i < bpa.size(); i++){
           if(partName.equalsIgnoreCase(bpa.get(i).getpartName())){
               int quant = rQuantity;
               int real = bpa.get(i).getquantity() + quant;
               BikePart ePart = new BikePart(partName, num, price, salePrice, buy, real);
               bpa.add(ePart);
           }
           else{
               BikePart ePart = new BikePart(partName, num, price, salePrice, buy, rQuantity);
               bpa.add(ePart);
           }
           
               
               }
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

    private void handleOfficeAction(Event event) throws IOException {
        Parent passwordWindow = FXMLLoader.load(getClass().getResource("Password.fxml"));
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Login Window");
        stage.setScene(new Scene(passwordWindow));
        stage.show();
    }
}
