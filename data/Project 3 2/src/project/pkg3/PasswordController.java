/**
 * This class will handle all possible events in the password pop-up window
 * @author Shamsadean Mirghani
 */
package project.pkg3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *This class handles the second pop-up window that is for the password
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
/**
 * This method will test the password that was entered by the user and then 
 * display the correct output
 * @param event 
 */
    @FXML
    private void handleEnterAction(ActionEvent event) {
        String password = passwordField.getText();
        if(password.equalsIgnoreCase("office")) {
            Stage stage = (Stage) passwordEnter.getScene().getWindow();
            stage.close();
        }
        else if(password.equalsIgnoreCase("sales")) {
            Stage stage = (Stage) passwordEnter.getScene().getWindow();
            stage.close();
        }
        else if(password.equalsIgnoreCase("wh")) {
            Stage stage = (Stage) passwordEnter.getScene().getWindow();
            stage.close();
        }
        else if(password.equalsIgnoreCase("system")) {
            Stage stage = (Stage) passwordEnter.getScene().getWindow();
            stage.close();
        }
        else{
            passwordOutput.appendText("Password is incorrect! \n");
        }
    }
/**
* Initializes the controller class.
*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
/**
 * This method will handle the exit button
 * @param event 
 */
    @FXML
    private void handleExitAction(ActionEvent event) {
        Platform.exit();
    }
    
}
