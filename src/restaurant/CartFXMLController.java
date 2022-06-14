/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

public class CartFXMLController implements Initializable {

    @FXML
    private TableView<Cart> cart;

    @FXML
    private TableColumn<Cart, String> item;

    @FXML
    private TableColumn<Cart, String> qty;

    @FXML
    private TableColumn<Cart, String> price;

    @FXML
    private Label ttl;

    @FXML
    private Button checkout;

    @FXML
    void check(ActionEvent event) {
        cart.getItems().clear();
        JOptionPane.showMessageDialog(null, "Thank you! Don't forget to leave feedback.");
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        item.setCellValueFactory(c -> new SimpleStringProperty("Item"));
//        qty.setCellValueFactory(c -> new SimpleStringProperty("qty"));
//        price.setCellValueFactory(c -> new SimpleStringProperty("price"));
//        
        item.setCellValueFactory(new PropertyValueFactory<Cart, String>("item"));
        qty.setCellValueFactory(new PropertyValueFactory<Cart, String>("qty"));
        price.setCellValueFactory(new PropertyValueFactory<Cart, String>("price"));
        
        ObservableList<Cart> items = FXCollections.observableArrayList();
        
        double total = 0;
        try {
            Scanner sc = new Scanner(new File("cart.txt"));
            while (sc.hasNext()){
                String[] misc = sc.nextLine().split(";");
                if (!"0".equals(misc[1]))
                    items.add(new Cart("Karahi", misc[1], String.valueOf(900 * Integer.parseInt(misc[1]))));
                if (!"0".equals(misc[3]))
                    items.add(new Cart("Spaghetti", misc[3], String.valueOf(130 * Integer.parseInt(misc[3]))));
                if (!"0".equals(misc[5]))
                    items.add(new Cart("Burger", misc[5], String.valueOf(100 * Integer.parseInt(misc[5]))));
                if (!"0".equals(misc[7]))
                    items.add(new Cart("Fries", misc[7], String.valueOf(70 * Integer.parseInt(misc[7]))));
                if (!"0".equals(misc[9]))
                    items.add(new Cart("Pizza", misc[9], String.valueOf(1000 * Integer.parseInt(misc[9]))));
                if (!"0".equals(misc[11]))
                    items.add(new Cart("Pasta", misc[11],String.valueOf(300 * Integer.parseInt(misc[11]))));
                
                total = 900 * Integer.parseInt(misc[1]) + 130 * Integer.parseInt(misc[3]) + 100 * Integer.parseInt(misc[5]) + 70 * Integer.parseInt(misc[7]) +
                        + 1000 * Integer.parseInt(misc[9])+300 * Integer.parseInt(misc[11]);
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CartFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ttl.setText("Total : " + total);
        cart.setItems(items);
       
    }

}
