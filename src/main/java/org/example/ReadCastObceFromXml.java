package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCastObceFromXml {

    public List<CastObce> readCastObceFromXml() {
        final String filePath = System.getProperty("user.dir") + "/src/main/files/kopidlno.xml";
        List<CastObce> listCastiObce = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(filePath));
            Element rootElement = document.getDocumentElement();
            NodeList vfCastObce = rootElement.getElementsByTagName("vf:CastObce");
            for (int i = 0; i < vfCastObce.getLength(); i++) {
                Node node = vfCastObce.item(i);
                Element element = (Element) node;
                Integer kod = Integer.valueOf(element.getElementsByTagName("coi:Kod").item(0).getTextContent());
                String nazev = element.getElementsByTagName("coi:Nazev").item(0).getTextContent();
                Integer kodObce = Integer.valueOf(element.getElementsByTagName("obi:Kod").item(0).getTextContent());
                CastObce castObce = new CastObce(kod, nazev, kodObce);
                listCastiObce.add(castObce);
                System.out.println("pridana cast obce: " + nazev + " do listu");
            }
        }catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return listCastiObce;
    }
}
