package Entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Event extends Activity {

    private Date DateStart;
    private Date DateEnd;

    public Event(String name, String location, String description, String phone, String state, String type, Entities.Category category, Entities.Municipality municipality, Date dateStart, Date dateEnd){

        Name = name;
        Location = location;
        Description = description;
        Phone = phone;
        State = state;
        Type = type;
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
