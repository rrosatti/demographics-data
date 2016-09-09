/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demosoft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONArray;

/**
 *
 * @author Luis
 */
public class JsonRemoteFetch {
    public static final String KEY = "11521db3f9e377bf";
    public static final String SEARCH_URL = "http://inqstatsapi.inqubu.com/?api_key=" + KEY;
    
    public JsonRemoteFetch() { }
    
    public JSONArray getJson(String topic,String countryCode,int startYear,int endYear) {
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
            
            JSONArray data = new JSONArray();
            data.add(json.toString());
            
            if (data == null) {
                return null;
            }
            
            return data;
            
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
                
    }
    
    
    
}
