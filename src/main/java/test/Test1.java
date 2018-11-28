package main.java.test;

import main.java.com.Notepad.Logic.Logic;
import main.java.com.Notepad.ReturnValue.Note;
import main.java.com.Notepad.XML.Converter;
import main.java.com.Notepad.XML.XMLReader;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Test1 {
    public static void main(String[] args) {

        String string = "13:00";
        string = string.replaceAll("[^0-9]","");
        System.out.println("String:  " + string);
        System.out.println(filterStartEnd(string));
    }
    static public String filterStartEnd(String startEnd){
        startEnd.replace(" ","");
        startEnd = startEnd.replaceAll("[^0-9]","");
        if(startEnd.length() > 4) return null;
        return startEnd;
    }
}
