package main.java.com.Notepad.XML;

import main.java.com.Notepad.ReturnValue.Note;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import sun.misc.Unsafe;

import java.util.ArrayList;

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
        xmlReader.Update();
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

    /**
     * @brief allows it to add a new user
     * @param name name (id) of the user
     */
    public void addUser(String name){
        xmlReader.Update();
        Node currentUser = xmlReader.getNodes("currentUser").item(0);
        Node parent = xmlReader.getNodes("saves").item(0);
        Node user =  xmlReader.setNode(parent,"user");
        xmlReader.setAtt(user,"id",name);
        xmlReader.setAtt(currentUser,"id",name);
    }

    /**
     * @brief changes currentUser
     * @param name new currentUser
     */
    public void setUser(String name){
        xmlReader.Update();
        Node currentUser = xmlReader.getNodes("currentUser").item(0);
        xmlReader.setAtt(currentUser,"id",name);
    }

    /**
     * @brief allows to get the whole information from one day
     * @param userID id, of the user the notes should be from
     * @param date date, the notes should be from
     * @return Notes  = multible ArrayLists
     */
    public Note getNotes(String userID,String date){
        xmlReader.Update();
        Note noteReturn = new Note();
        NodeList users = xmlReader.getNodes("user");
        Node user = null;
        for(int i = 0; i < users.getLength();i++){
            if(users.item(i).getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) users.item(i);
                if(element.getAttribute("id").equals(userID)){
                    user = users.item(i);
                    break;
                }
            }
        }
        if(user != null){
            NodeList notes = user.getChildNodes();
            for(int i = 0; i < notes.getLength();i++){
                Node note = notes.item(i);
                if(note.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) note;
                    if(element.getAttribute("date").equals(date)) noteReturn.addNote(element.getAttribute("start"),element.getAttribute("end"),element.getTextContent());
                }
            }
        }
        return noteReturn;
    }

    /**
     * @brief returns currentUser as a String
     * @return String, currentUser
     */
    public String getCurrentUser(){
        Node currentUser = xmlReader.getNodes("currentUser").item(0);
        if(currentUser.getNodeType() == Node.ELEMENT_NODE){
            Element element = (Element) currentUser;
            return element.getAttribute("id");
        }
        return null;
    }

    /**
     * @brief returns all usernames
     * @return ArrayList: usersnames
     */
    public ArrayList<String > getUserNames(){
        xmlReader.Update();
        ArrayList<String> userNames = new ArrayList<>();
        NodeList users = xmlReader.getNodes("user");
        for(int i = 0; i <  users.getLength();i++){
            Node user = users.item(i);
            if(user.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) user;
                userNames.add(element.getAttribute("id"));
            }
        }
        return userNames;
    }
}
