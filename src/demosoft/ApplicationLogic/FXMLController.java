/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demosoft.ApplicationLogic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
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
    @FXML
    ComboBox cmb_topics;
    @FXML
    ComboBox cmb_start_year; 
    @FXML
    ComboBox cmb_end_year;
    @FXML
    Button bt_getData;
    @FXML
    BarChart barchart;
    
    private Demosoft demo1;
    private Demosoft demo2; // it will be used to get the data for the second country (compare)
    private HashMap<Integer, String> data1;
    private HashMap<Integer, String> data2; // // it will be used to store the data from the second country (compare)
    private List<String> topics = new ArrayList<>(); // it will contain all the avaiable topics
    private LinkedHashMap<String, String> countries = new LinkedHashMap<>(); // it will contain all the countries and their code(br, us, ca)
    private List<Integer> years = new ArrayList<>(); // it will contain all the avaiable years
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Testing 
        getYearsFile();
        
        //initialize cmb_country
        List<KeyValuePair> cmbCountryList = new ArrayList<>();
        cmbCountryList.add(new KeyValuePair("br","Brasil"));
        cmbCountryList.add(new KeyValuePair("us","Estados Unidos"));
        cmbCountryList.add(new KeyValuePair("ca","Canada"));
        
        ObservableList obCoutry_list = FXCollections.observableList(cmbCountryList);
        cmb_pais.getItems().clear();
        cmb_pais.setItems(obCoutry_list);

        
        //initialize cmb_topics
        List<String> cmbTopicsList = new ArrayList<>();
        cmbTopicsList.add(new String("population"));
        cmbTopicsList.add(new String("something else"));
        cmbTopicsList.add(new String("something else"));
        
        ObservableList obTopics_list = FXCollections.observableList(cmbTopicsList);
        cmb_topics.getItems().clear();
        cmb_topics.setItems(obTopics_list);
        
        //initialize cmb_start_year
        List<Integer> cmbStartYearList = new ArrayList<>();
        for(int i = 1980 ; i < 2015; i++){
           cmbStartYearList.add(i); 
        }
        
        ObservableList obStartYear_list = FXCollections.observableList(cmbStartYearList);
        cmb_start_year.getItems().clear();
        cmb_start_year.setItems(obStartYear_list);
        
        //initialize cmb_end_year
        List<Integer> cmbEndYear = new ArrayList<>();
        for(int i = 1980 ; i < 2015; i++){
           cmbEndYear.add(i); 
        }

        
        ObservableList obEndYear_list = FXCollections.observableList(cmbEndYear);
        cmb_end_year.getItems().clear();
        cmb_end_year.setItems(obEndYear_list);
        
        /** This is just a test. I don't know if it will work like that */
        // btGetData onClick() event
        /*
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
        */
    }
    

    @FXML
     private void gerarButtonAction(ActionEvent event) {
         System.out.println("Botao clicado");
         
          // These values will be caught through the interface objects
          
            //Get the object that contains the value for the selected key
            //Ex. Brasil -> br     
            KeyValuePair countryCodeObject =(KeyValuePair) cmb_pais.getSelectionModel().getSelectedItem();
            String countryCode = countryCodeObject.getKey();
                    
            String topic = cmb_topics.getSelectionModel().getSelectedItem().toString();
            
            System.out.println("selecionados->"+countryCode+" "+topic);
            
            //get selected years
            int startYear = Integer.parseInt(cmb_start_year.getSelectionModel().getSelectedItem().toString());;
            int endYear = Integer.parseInt(cmb_end_year.getSelectionModel().getSelectedItem().toString());
            
            
            //Process the selected information
            demo1 = new Demosoft();
            demo1.setProperties(topic, countryCode, startYear, endYear);
            demo1.getData();
            
            data1 = new HashMap<>();
            data1 = demo1.getAllData();
            
            barchart = demo1.showGraph();
     }
     
     private void getCountriesFile() {
         File dir = new File(new File("").getAbsolutePath() +"/data/");
         try {
             FileReader fr = new FileReader(new File(dir, "countries.txt"));
             BufferedReader br = new BufferedReader(fr);
             String line = br.readLine();
             while (line != null) {
                 String[] countryCode = line.split(",");
                 countries.put(countryCode[1], countryCode[0]);
                 line = br.readLine();
             }
             br.close();
         } catch (Exception e) {
            e.printStackTrace();
         }
         
     }
     
     private void getTopicsFile() {
         File dir = new File(new File("").getAbsolutePath() +"/data/");
         try {
             FileReader fr = new FileReader(new File(dir, "topics.txt"));
             BufferedReader br = new BufferedReader(fr);
             String line = br.readLine();
             String[] topicsFile = line.split(";");
             for (int i=0; i<topicsFile.length; i++) {
                 topics.add(topicsFile[i]);
             }
             br.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
         
     }
     
     private void getYearsFile() {
         File dir = new File(new File("").getAbsolutePath() + "/data/");
         try {
             FileReader fr = new FileReader(new File(dir, "years.txt"));
             BufferedReader br = new BufferedReader(fr);
             String line = br.readLine();
             String[] yearsFile = line.split(";");
             for (int i=0; i<yearsFile.length; i++){
                 years.add(Integer.parseInt(yearsFile[i]));
             }
             br.close();
         } catch(Exception e) {
             e.printStackTrace();
         }
         
     }
    
}
