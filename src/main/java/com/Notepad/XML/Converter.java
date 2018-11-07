package main.java.com.Notepad.XML;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import org.w3c.dom.Node;

public class Converter {
    private XMLReader xmlReader;

    public void Converter(){
        setup();
    }

    public void setup(){
        xmlReader = new XMLReader("resources/saves.xml");
    }
    public void addNote(String user, String date, String start, String end, String content){
        NodeList users = xmlReader.getNodes("user");
        if(users != null) {
            for (int i = 0; i < user.length(); i++) {
                Node userNode = users.item(i);
                if (userNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) userNode;
                    if (element.getAttribute("id").equals(user)) {
                        Node note = xmlReader.setNode(userNode, "note");
                        xmlReader.setAtt(note, "date", date);
                        xmlReader.setAtt(note, "start", start);
                        xmlReader.setAtt(note, "end", end);
                        xmlReader.setContent(note, content);
                    }
                }
            }
        }
    }
}
