/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demosoft.ApplicationLogic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Luis
 */
public class JsonRemoteFetch implements Runnable {
    public static final String KEY = "11521db3f9e377bf";
    public static final String SEARCH_URL = "http://inqstatsapi.inqubu.com/?api_key=" + KEY;
    
    private String topic;
    private String countryCode;
    private int startYear;
    private int endYear;
    private JSONObject result;
    
    public JsonRemoteFetch() { }
    
    public void setProperties(String topic, String countryCode, int startYear, int endYear) {
        this.topic = topic;
        this.countryCode = countryCode;
        this.startYear = startYear;
        this.endYear = endYear;
    }
    
    private JSONObject getData() {
        String stringURL = SEARCH_URL;
        stringURL += "&data=" + topic + "&countries=" + countryCode + "&years=" + startYear + ":" + endYear;
        
        try {
            URL url = new URL(stringURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
            StringBuffer json = new StringBuffer(1024);
            String temp = "";
            while ((temp = reader.readLine()) != null) {
                json.append(temp).append("\n");
            }
            reader.close();
            
            JSONParser parser = new JSONParser();
            
            json.deleteCharAt(0); // remove the first [
            json.deleteCharAt(json.length()-2); // remove the last ]
            
            // Use a try catch here??
            Object obj = parser.parse(json.toString());
            result = (JSONObject) obj;
            
            
            if (result == null) {
                return null;
            }
            
            return result;
            
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
                
    }
    
    public void run() {
        getData();
    }
    
    public JSONObject getJson() {
        return result;
    }
    
    
    
}
