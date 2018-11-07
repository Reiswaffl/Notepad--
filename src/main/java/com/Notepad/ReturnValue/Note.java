package main.java.com.Notepad.ReturnValue;

import java.util.ArrayList;

public class Note {
    private ArrayList<String> start;
    private ArrayList<String> end;
    private ArrayList<String> content;

    /**
     * @brief setup
     */
    public Note(){
        start = new ArrayList<>();
        end = new ArrayList<>();
        content = new ArrayList<>();
    }

    /**
     * @brief add new noteinformation
     * @param start start, the note has
     * @param end end, the note has
     * @param content content, the note has
     */
    public void addNote(String start, String end, String content){
        this.start.add(start);
        this.end.add(end);
        this.content.add(content);
    }

    /**
     * @return all startvalues
     */
    ArrayList<String> getStart(){
        return start;
    }

    /**
     * @return all endvalues
     */
    ArrayList<String> getEnd(){
        return end;
    }

    /**
     * @return all contentvalues
     */
    ArrayList<String> getContent(){
        return content;
    }
}
