/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demosoft;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;

/**
 *
 * @author rodri
 */
public class Demosoft {

    private Info info;
    //private JsonRemoteFetch remoteFetch;    

    public void showGraph() {
        // code here
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
