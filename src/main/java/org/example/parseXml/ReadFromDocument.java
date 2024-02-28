package org.example.parseXml;

import org.example.entity.Village;
import org.example.entity.VillagePart;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class ReadFromDocument {

    private static NodeList getNodeList(Document document, String name) {
        Element rootElement = document.getDocumentElement();
        NodeList nodeList = rootElement.getElementsByTagName(name);
        return nodeList;
    }

    private static String getTextContentFromElementByTagName(Element element, String tagName) {
        return element.getElementsByTagName(tagName).item(0).getTextContent();
    }

    private static Integer getIntegerValueFromElementByTagName(Element element, String tagName) {
        return Integer.valueOf(element.getElementsByTagName(tagName).item(0).getTextContent());
    }

    public List<Village> readVillagesFromDocument(Document document) {
        List<Village> listVillages = new ArrayList<>();
        NodeList nodeList = getNodeList(document, "vf:Obec");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            Integer code = getIntegerValueFromElementByTagName(element, "obi:Kod");
            String name = getTextContentFromElementByTagName(element, "obi:Nazev");
            Village village = new Village(name, code);
            listVillages.add(village);
            System.out.println("pridana obec: " + name + " do listu");
        }
        return listVillages;
    }

    public List<VillagePart> readVillagesPartsFromDocument(Document document) {
        List<VillagePart> listVillagesParts = new ArrayList<>();
        NodeList nodeList = getNodeList(document, "vf:CastObce");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            Integer code = getIntegerValueFromElementByTagName(element, "coi:Kod");
            String name = getTextContentFromElementByTagName(element, "coi:Nazev");
            Integer villageCode = getIntegerValueFromElementByTagName(element, "obi:Kod");
            VillagePart villagePart = new VillagePart(code, name, villageCode);
            listVillagesParts.add(villagePart);
            System.out.println("pridana cast obce: " + name + " do listu");
        }
        return listVillagesParts;
    }
}
