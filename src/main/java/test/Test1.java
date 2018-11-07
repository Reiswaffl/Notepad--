package main.java.test;

import main.java.com.Notepad.XML.XMLReader;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test1 {
    public static void main(String[] args) {
        XMLReader xmlReader = new XMLReader("resources/saves.xml");
        NodeList users = xmlReader.getNodes("user");
        for(int i = 0; i < users.getLength(); i++){
            Node user = users.item(0);
            Node note = xmlReader.setNode(user,"note");
            xmlReader.setAtt(note,"date","dd.MM.yyyy");
            xmlReader.setAtt(note,"start","hh.mm");
            xmlReader.setAtt(note,"end","hh.mm");
            xmlReader.setContent(note,"content");
        }
    }
}
