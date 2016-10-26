/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demosoft;

import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author rodri
 */
public class Demosoft {
    
    private Info info;
    private JSONObject json;
    private JsonRemoteFetch remoteFetch;

    public Demosoft() {
        this.info = new Info();
        this.json = new JSONObject();
        this.remoteFetch = new JsonRemoteFetch();
    }
    
    public void setProperties(String topic, String countryCode, int startYear, int endYear) {
        info.setTopic(topic);
        info.setCountryCode(countryCode);
        info.setStartYear(startYear);
        info.setEndYear(endYear);
        remoteFetch.setProperties(topic, countryCode, startYear, endYear);
    }
    
    public JSONObject getJsonArray() {
        return json;
    }
    
    public JsonRemoteFetch getRemoteFetch() {
        return remoteFetch;
    }
    
    public void showGraph() {
        // code here
    }
    
    public void readFile() {
        // code here
    }
    
    public void exportToPDF() {
        // code here
    }
    
    public void newData() {
        // code here
    }
    
    public void compare() {
        // code here
    }
    
    public void getData() {
        Thread t = new Thread(getRemoteFetch());
        
        try {
            t.start();
            t.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        createInfoObject();
    }
    
    public void createInfoObject() {
        JSONArray jsonArray = new JSONArray();

        json = remoteFetch.getJson();
        
        if (json != null) {
            info.setCountryName( (String) json.get("countryName"));
            jsonArray = (JSONArray) json.get(info.getTopic());
            //Iterator<JSONObject> iterator = jsonArray.iterator();
            for (int i = 0; i < jsonArray.size(); i++) {
                
                JSONObject jsonObj = new JSONObject();
                try {
                    JSONParser parser = new JSONParser();
                    Object obj = parser.parse(jsonArray.get(i).toString());
                    jsonObj = (JSONObject) obj;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                int year = Integer.valueOf( (String) jsonObj.get("year"));
                String data = (String) jsonObj.get("data");
                System.out.println("year: " + year + " data: " + data);
                info.addData(year, data);
            }
            System.out.println("Everything's fine!");
        }
            
                    
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /** Testing getJson() method */
        Demosoft demo = new Demosoft();
        Demosoft demo2 = new Demosoft();
        Demosoft demo3 = new Demosoft();
        
        demo.setProperties("population", "br", 2000, 2016);
        demo2.setProperties("population", "us", 2000, 2016);
        demo3.setProperties("population", "ca", 2000, 2016);
        
        demo.getData();
        demo3.getData();
        demo2.getData();
        
    }
    
}
