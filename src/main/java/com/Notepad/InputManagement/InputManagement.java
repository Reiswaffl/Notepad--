package main.java.com.Notepad.InputManagement;

public class InputManagement {

    public InputManagement(){

    }
    public String filterDay(String day){
        day.replace(" ", "");
        day = day.replaceAll("[^0-9]","");
        if(day.length() > 2) return null;
        return day;
    }
    public String filterStartEnd(String startEnd){
        startEnd.replace(" ","");
        startEnd = startEnd.replaceAll("[^0-9:]","");
        if(startEnd.length() > 2) return null;
        return startEnd;
    }
}
