/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MenuFXMLController implements Initializable {

    @FXML
    private Button addPi;

    @FXML
    private Label quantityPi;

    @FXML
    private Button addB;

    @FXML
    private Label quantityB;

    @FXML
    private Button addF;

    @FXML
    private Button addS;

    @FXML
    private Button addPa;

    @FXML
    private Button addK;

    @FXML
    private Label quantityF;

    @FXML
    private Label quantityS;

    @FXML
    private Label quantityPa;

    @FXML
    private Label quantityK;
    
    @FXML
    private Button rB;

    @FXML
    private Button rPi;

    @FXML
    private Button rF;

    @FXML
    private Button rPa;

    @FXML
    private Button rS;

    @FXML
    private Button rK;


    int qk, qf, qs, qb, qpi, qpa;

    BufferedWriter out;

    @FXML
    void handleAction(ActionEvent event) throws IOException {
        try {
           out = new BufferedWriter(new FileWriter("cart.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MenuFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MenuFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (event.getSource() == addK) {
            qk++;
            quantityK.setText("Quantity: " + qk);
        }
        if (event.getSource() == addS) {
            qs++;
            quantityS.setText("Quantity: " + qs);
        }
        if (event.getSource() == addB) {
            qb++;
            quantityB.setText("Quantity: " + qb);
        }
        if (event.getSource() == addF) {
            qf++;
            quantityF.setText("Quantity: " + qf);
        }
        if (event.getSource() == addPi) {
            qpi++;
            quantityPi.setText("Quantity: " + qpi);
        }
        if (event.getSource() == addPa) {
            qpa++;
            quantityPa.setText("Quantity: " + qpa);
        }
        
        if (event.getSource() == rK) {
            if (qk > 0)
                qk--;
            quantityK.setText("Quantity: " + qk);
        }
        if (event.getSource() == rS) {
            if (qs > 0)
                qs--;
            quantityS.setText("Quantity: " + qs);
        }
        if (event.getSource() == rB) {
            if (qb > 0)
                qb--;
            quantityB.setText("Quantity: " + qb);
        }
        if (event.getSource() == rF) {
            if (qf > 0)
                qf--;
            quantityF.setText("Quantity: " + qf);
        }
        if (event.getSource() == rPi) {
             if (qpi > 0)
                qpi--;
            quantityPi.setText("Quantity: " + qpi);
        }
        if (event.getSource() == rPa) {
             if (qpa > 0)
                qpa--;
            quantityPa.setText("Quantity: " + qpa);
        }
        
        out.write("k;" + qk + ";s;" + qs + ";b;" + qb + ";f;" + qf + ";pi;" + qpi + ";pa;" + qpa);
        out.close();
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

}
