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

public class ReadObecFromXml {

    public List<Obec> readObecFromXml() {
        final String filePath = System.getProperty("user.dir") + "/src/main/files/kopidlno.xml";
        List<Obec> listObci = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(filePath));
            Element rootElement = document.getDocumentElement();
            NodeList vfObec = rootElement.getElementsByTagName("vf:Obec");
            for (int i = 0; i < vfObec.getLength(); i++) {
                Node node = vfObec.item(i);
                Element element = (Element) node;
                Integer kod = Integer.valueOf(element.getElementsByTagName("obi:Kod").item(0).getTextContent());
                String nazev = element.getElementsByTagName("obi:Nazev").item(0).getTextContent();
                Obec obec = new Obec(nazev, kod);
                listObci.add(obec);
                System.out.println("pridana obec: " + nazev + " do listu");
            }
        }catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return listObci;
    }
}
