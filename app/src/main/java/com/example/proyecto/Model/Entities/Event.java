package com.example.proyecto.Model.Entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Event extends Activity {

    public Calendar DateStart;
    public Calendar DateEnd;



    public Event(String image, String title, String desc) {
        this.Image = image;
        this.Name = title;
        this.Description = desc;
    }

    public Event(){

    }


    public Event(String name, String location, String description, String phone, String state, Category category, Municipality municipality, Calendar dateStart, Calendar dateEnd){

        Name = name;
        Location = location;
        Description = description;
        Phone = phone;
        State = state;
        Municipality = municipality;
        Category = category;
        DateStart = dateStart;
        DateEnd = dateEnd;
    }

    @Override
    public String Availability() {

        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String dateStart = simpleDateFormat.format(DateStart);
        String dateEnd = simpleDateFormat.format(DateEnd);
        String formatHours = " HH:mm";
        SimpleDateFormat simpleDateHours = new SimpleDateFormat(formatHours);
        String hourStart = simpleDateHours.format(DateStart);
        String hourEnd = simpleDateHours.format(DateEnd);

        return  "El evento esta disponible desde el" + dateStart +"a las "+ hourStart + " hasta el " + dateEnd + "a las " + hourEnd;
    }
}
