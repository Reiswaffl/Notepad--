package main.java.com.Notepad.XML;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class Converter {
    private XMLReader xmlReader;

    public Converter(){
        setup();
    }

    public void setup(){
        xmlReader = new XMLReader("resources/saves.xml");
    }

    /**
     * @brief allows to add a note
     * @param user user, the note is from
     * @param date date, the appointment is at
     * @param start start, the note has
     * @param end end, the note has
     * @param content content, the note has
     */
    public void addNote(String user, String date, String start, String end, String content){
        NodeList users = xmlReader.getNodes("user");
        if(users != null) {
            for (int i = 0; i < users.getLength(); i++) {
                Node userNode = users.item(i);
                if (userNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) userNode;
                    if (element.getAttribute("id").equals(user)) {
                        Node note = xmlReader.setNode(userNode, "note");
                        xmlReader.setAtt(note, "date", date);
                        if(start != null) xmlReader.setAtt(note, "start", start);
                        if(end != null) xmlReader.setAtt(note, "end", end);
                        xmlReader.setContent(note, content);
                    }
                }
            }
        }
    }
}
