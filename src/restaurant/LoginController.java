/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class LoginController implements Initializable {
    

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;
    @FXML
    private Button signupBtn;

    @FXML
    private Button loginBtn;
    

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == loginBtn){
            boolean log = false;
            try {
            Scanner sc = new Scanner(new File("cred.txt"));
            while (sc.hasNext()){
                String[] misc = sc.nextLine().split(";");
                System.out.print(misc[1]);
               if (misc[0].equals(emailField.getText()) && misc[1].equals(passwordField.getText()) ){
                   log = true;
               }
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CartFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
            if (log){
                final Stage stagec = (Stage) emailField.getScene().getWindow();
        stagec.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomeFXML.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));

            stage.show();
            }
            else{
            JOptionPane.showMessageDialog(null, "Wrong Password");
            }
        }
        else if (event.getSource() == signupBtn){
             
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Register.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));

            stage.show();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
