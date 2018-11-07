package main.java.test;

import main.java.com.Notepad.XML.Converter;
import main.java.com.Notepad.XML.XMLReader;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test1 {
    public static void main(String[] args) {
        Converter converter = new Converter();
        converter.addNote("User", "tt.mm.jjjj","ss.mm","ss.mm","myContent");
    }
}
