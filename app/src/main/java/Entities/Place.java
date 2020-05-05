package Entities;

import java.util.ArrayList;

public class Place extends Activity {

    public ArrayList<Day> Schedule;

    public Place(String name, String location, String description, String phone, String state, String type, Entities.Category category, Entities.Municipality municipality){

        Name = name;
        Location = location;
        Description = description;
        Phone = phone;
        State = state;
        Type = type;
        Municipality = municipality;
        Category = category;
        Schedule = new ArrayList<>();
    }

    public String AddDays(int numDay,String hourOpen, String hourEnd){
        boolean dayExist = false;
        for (Day day:Schedule)
        {
            if(day.NumDay == numDay)
            {
                dayExist = true;
            }
        }
        if(numDay>0 && numDay<=7 && !dayExist)
        {
            Day day = new Day(numDay, hourOpen, hourEnd);
            return "Se añadio exitosamente";
        }
        else{
            return "dia invalido";
        }
    }

    @Override
    public String Availability() {
        return null;
    }

    public static class Day{
        
        public int NumDay;
        public String HourOpen;
        public String HourClose;
        
        public Day(int numDay, String open,String close){
            NumDay = numDay;
            HourOpen = open;
            HourClose = close;
        }
    }

}
