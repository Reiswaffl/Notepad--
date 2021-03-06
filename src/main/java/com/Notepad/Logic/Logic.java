package main.java.com.Notepad.Logic;

import main.java.com.Notepad.XML.Converter;
import main.java.com.Notepad.ReturnValue.Note;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public final class Logic {
    public static Converter converter = new Converter();

    public Logic(){}
    public static void setup(){}

    /**
     * @brief adds Note
     * @param date date of Note
     * @param start start of Note
     * @param end end of Note
     * @param content content of Note
     */
    public static void addNote(String date, String start, String end, String content){
        converter.addNote(converter.getCurrentUser(),date,start,end,content);
    }

    public String selectUser(String name){
        if(switchUser(name) != null){
            addUser(name);
            return "Nutzer " + name + "wurde eingetragen";
        }
        return null;
    }
    /**
     * @brief adds user, if the name doesn't exist yet
     * @param name name the user is supposed to have
     * @return possible Errormessage
     */
    public static String addUser(String name){
        ArrayList<String> users = converter.getUserNames();
        for(int i = 0; i < users.size(); i++){
            if(converter.getCurrentUser().equals(name)) return "Name exestiert bereits";
        }
        converter.addUser(name);
        return null;
    }

    /**
     * @brief switch to a existing user
     * @param name name of the user to switch to
     * @return
     */
    public static String switchUser(String name){
        ArrayList<String> users = converter.getUserNames();
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).equals(name)) {
                converter.setUser(name);
                return null;
            }
        }
        return "Nutzer noch nicht eingetragen";
    }

    /**
     * @brief collects the Notes of a day an brings them in a form that is good to show
     * @return String
     */
    public static String getNotes(){
        Date date = new Date();
        DateFormat dayFormat = new SimpleDateFormat("dd.MM.yyyy");
        Note notes = converter.getNotes(converter.getCurrentUser(),dayFormat.format(date));
        String noteReturn = "";
        for(int i = 0; i < notes.getStart().size(); i++){

            noteReturn = noteReturn + "-> " + notes.getStart().get(i) + " - " + notes.getEnd().get(i) + " : "  + notes.getContent().get(i) + "\n";
        }
        return noteReturn;
    }

    /**
     * @brief returns the name of the current user
     * @return String
     */
    public static String getCurrentUser(){
        return converter.getCurrentUser();
    }
}
