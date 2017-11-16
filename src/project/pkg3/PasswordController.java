/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author shamsadeanmirghani
 */
public class PasswordController implements Initializable {

    @FXML
    private Button passwordExit;
    @FXML
    private TextArea passwordOutput;
    @FXML
    private TextField passwordField;
    @FXML
    private Button passwordEnter;
    @FXML
    private AnchorPane pane;

    @FXML
    private void handleEnterAction(ActionEvent event) {
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleExitAction(ActionEvent event) {
    }
    
}
