package main.java.test;

import main.java.com.Notepad.InputManagement.InputManagement;
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
        InputManagement inputManagement = new InputManagement();
        System.out.println(inputManagement.filterYear("200020"));
    }
}
