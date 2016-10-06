/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demosoft;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author rogerio
 */
public class FXMLController implements Initializable {

    @FXML
    ComboBox cmb_pais;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        List<String> list = new ArrayList<>();
        list.add("Brasil");
        list.add("Estados Unidos");
        list.add("Japão");
        ObservableList obList = FXCollections.observableList(list);
        cmb_pais.getItems().clear();
        cmb_pais.setItems(obList);
    }    
    
}
