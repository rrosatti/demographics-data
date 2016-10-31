/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demosoft;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author rogerio
 */
public class FXMLController implements Initializable {

    @FXML
    ComboBox cmb_pais;
    ComboBox cmb_topics;
    ComboBox cmb_start_year; // we need to create it
    ComboBox cmb_end_year; // we need to create it
    Button bt_getData;
    
    private Demosoft demo1;
    private Demosoft demo2; // it will be used to get the data for the second country (compare)
    private HashMap<Integer, String> data1;
    private HashMap<Integer, String> data2; // // it will be used to store the data from the second country (compare)
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        List<String> list = new ArrayList<>();
        list.add("Brasil");
        list.add("Estados Unidos");
        list.add("Japão");
        ObservableList obList = FXCollections.observableList(list);
        cmb_pais.getItems().clear();
        cmb_pais.setItems(obList);
        
        /** This is just a test. I don't know if it will work like that */
        // btGetData onClick() event
        {
            // These values will be caught through the interface objects
            String countryCode = "";
            String topic = "";
            int startYear = 0;
            int endYear = 0;
            
            demo1 = new Demosoft();
            demo1.setProperties(topic, countryCode, startYear, endYear);
            demo1.getData();
            
            data1 = new HashMap<>();
            data1 = demo1.getAllData();
        }
        
    }    
    
}
