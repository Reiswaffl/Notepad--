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
            xmlReader.setAtt(user,"att","value");
            if(user.getNodeType() == Node.ELEMENT_NODE){
                Element euser = (Element) user;
                System.out.println("--" + euser.getTextContent());
            }
        }
    }
}
