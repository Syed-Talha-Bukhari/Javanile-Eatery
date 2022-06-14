/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class HomeController implements Initializable {

    @FXML
    private Button menu;
    
    @FXML
    private Button cart;
    
    @FXML
    private Button feed;
    
    @FXML
    private BorderPane pane;
    
        @FXML
    private Label top;
    @FXML
    void onHandleAction(ActionEvent event) throws IOException {
        if (event.getSource() == menu){
            top.setText("                                                           Menu");
            FxmlLoader object = new FxmlLoader(); 
            Pane view = object.getPage("MenuFXML");
            pane.setCenter(view);
        }
        if (event.getSource() == cart){
            top.setText("                                                         Cart");
            FxmlLoader object = new FxmlLoader();
            Pane view = object.getPage("CartFXML");
            pane.setCenter(view);
        }
        if (event.getSource() == feed){
            top.setText("                                                         Feedback");
            FxmlLoader object = new FxmlLoader();
            Pane view = object.getPage("Feedback");
            pane.setCenter(view);
        }
    }
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
