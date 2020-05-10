package com.example.proyecto.Entities;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Place extends Activity {

    public ArrayList<Day> Schedule;

    public Place(int image, String title, String desc) {
        this.Image = image;
        this.Name = title;
        this.Description = desc;
    }

    public Place(String name, String location, String description, String phone, String state, String type,Category category, Municipality municipality){

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
        if(Schedule != null)
        {
            for (Day day:Schedule)
            {
                if(day.NumDay == numDay)
                {
                    dayExist = true;

                }
            }
        }
        if(numDay>0 && numDay<=7 && dayExist==false)
        {
            Day day = new Day(numDay, hourOpen, hourEnd);
            Schedule.add(day);
            return "Se añadio exitosamente";
        }
        else{
            return "dia invalido";
        }
    }

    @Override
    public String Availability() {
        StringBuilder response = new StringBuilder("El Sitio de interes: " + Name + " esta disponible los:\n" );
        for (Day day:Schedule) {
            String schedule = day.NumDay + " desde las "+ day.HourOpen + " hasta las " + day.HourClose + "\n";
            response.append(schedule);
        }
        return response.toString();
    }

    @NonNull
    @Override
    public String toString() {
        return Name + "," + Location + "," + Description + "," + Type;
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
