package Communication;

import com.google.gson.*;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonTest {
    public static void maxin(String[] args){


        return;
    }


    public static void ReadJson(){
        try {

            JsonParser jp = new JsonParser();
            JsonObject jo = jp.parse(new FileReader("...")).getAsJsonObject();
            int e1 = jo.get("...keyvalue").getAsInt(); // cast
            JsonArray a1 = jo.get("...key val of map").getAsJsonArray();
            int[] arrayint = new int[a1.size()];
            for(int i = 0; i< a1.size(); i++){
                arrayint[i] = a1.get(i).getAsInt();
            }
        }catch (FileNotFoundException e){e.printStackTrace();}
        // 本来JSON就是一个大object
    }

    public static void ReadXML(){
        // Everything in XML is valid kind of node
        // Element represents specific kinds of node enclosed by tags
        try{DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document droot = builder.parse(new File("filepath"));
            NodeList nodeList1 =  droot.getElementsByTagName("...");
            String input1 = droot.getElementById("").getTextContent();
        }catch (ParserConfigurationException e){e.printStackTrace();}
        catch (SAXException e){e.printStackTrace();}
        catch (IOException e){e.printStackTrace();}
    }
}
