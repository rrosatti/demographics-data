/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demosoft.ApplicationLogic;


import java.util.Iterator;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
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
        String pais;
        final CategoryAxis xvalues = new CategoryAxis();
        final NumberAxis yvalues = new NumberAxis();
        final BarChart<String, Number> graphbar = new BarChart<>(xvalues, yvalues);
        graphbar.setTitle("Dados Demográficos");
        xvalues.setLabel("Year");
        yvalues.setLabel("Value");

        XYChart.Series barra = new XYChart.Series();
        barra.setName(info.getTopic());
        HashMap<Integer, String> data = info.getAllData();
        for (int key : data.keySet()) {
            barra.getData().add(new XYChart.Data(key, data.get(key)));
        }
        
        graphbar.getData().addAll(barra);//teoricamente aqui formaria o gráfico, agora precisa alimentar o componente de barchart.
        
        
        
    }

    public void readFile() {
        // code here
    }

    public void exportToPDF() {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Luis\\Desktop\\PDFTest.pdf"));
            document.open();
            document.add(new Paragraph("textoaqui")); //using string
            /*Image image = Image.getInstance("caminho"); using image
            document.add(image)
             */
        } catch (DocumentException de) {
            System.out.println(de.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        document.close();
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

    private void createInfoObject() {
        JSONArray jsonArray = new JSONArray();

        json = remoteFetch.getJson();

        if (json != null) {
            info.setCountryName((String) json.get("countryName"));
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

                int year = Integer.valueOf((String) jsonObj.get("year"));
                String data = (String) jsonObj.get("data");
                System.out.println("year: " + year + " data: " + data);
                info.addData(year, data);
            }
            System.out.println("Everything's fine!");
        }

    }

    public HashMap<Integer, String> getAllData() {
        return info.getAllData();
    }

    public String getData(int year) {
        return info.getResult(year);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * Testing getJson() method
         */
        Demosoft demo = new Demosoft();
        Demosoft demo2 = new Demosoft();
        Demosoft demo3 = new Demosoft();

        demo.setProperties("population", "br", 2000, 2016);
        demo2.setProperties("population", "us", 2000, 2016);
        demo3.setProperties("population", "ca", 2000, 2016);

        demo.getData();
        demo3.getData();
        demo2.getData();

        /**
         * Testing getJson() method JSONArray json = new JSONArray();
         * JsonRemoteFetch remoteFetch = new JsonRemoteFetch(); json =
         * remoteFetch.getJson("population", "br", 1980, 2016);
         * System.out.println(json.toString());
         */
        /*
        * Testing exportToPDF method        
        * Demosoft demo = new Demosoft();
        * demo.exportToPDF();
         */
    }

}
