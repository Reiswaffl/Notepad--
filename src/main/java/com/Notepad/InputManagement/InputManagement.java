package main.java.com.Notepad.InputManagement;

public class InputManagement {

    public InputManagement(){

    }

    /**
     * @brief filters the day-input
     * @param day day-input (from user)
     * @return filtered day
     */
    public String filterDay(String day){
        day = day.replace(" ", "");
        day = day.replaceAll("[^0-9]","");
        if(day.length() > 2 || day.length() == 0) return null;
        return day;
    }

    /**
     * @brief filters the end- and start-input
     * @param startEnd start- or end-input
     * @return filtered input
     */
    public String filterStartEnd(String startEnd){
        startEnd = startEnd.replace(" ","");
        startEnd = startEnd.replaceAll("[^0-9]","");
        if(startEnd.length() == 4){
            startEnd = startEnd.substring(0,2) + ":" + startEnd.substring(2,4);
        }else{
            return null;
        }
        if(startEnd.length() > 5) return null;
        return startEnd;
    }

    public String filterYear(String year){
        year = year.replace(" ","");
        year = year.replaceAll("[^0-9]","");
        if(year.length() > 4 || year.length() < 4) return null;
        return year;
    }

}
