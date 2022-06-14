/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class RegisterController implements Initializable {

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button signup;

    BufferedWriter out;

    @FXML
    void handleAction(ActionEvent event) throws IOException {
        
            
        try {
            out = new BufferedWriter(new FileWriter("cred.txt", true));
            out.write("\n" + emailField.getText() + ";" + passwordField.getText());
            System.out.print("\n" + emailField.getText() + ";" + passwordField.getText());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MenuFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MenuFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        out.close();
        final Stage stage = (Stage) emailField.getScene().getWindow();
        stage.close();
         
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
