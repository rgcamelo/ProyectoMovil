package com.example.proyecto;

import com.example.proyecto.Data.ConnectionSQLiteHelper;
import com.example.proyecto.Entities.Activity;
import com.example.proyecto.Entities.Category;
import com.example.proyecto.Entities.Department;
import com.example.proyecto.Entities.Event;
import com.example.proyecto.Entities.Municipality;
import com.example.proyecto.Entities.Place;
import com.example.proyecto.Entities.SubCategory;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class DomainTest {


    @Test
    public void CreateCategory(){
        SubCategory subCategory = new SubCategory("Marcha");
        Category category = new Category("Deportes",subCategory);
        assertEquals("Deportes,Marcha",category.toString());
    }

    @Test
    public void CreateMunicipality(){
        Department department = new Department();
        department.Name = "Cesar";
        Municipality municipality = new Municipality();
        municipality.department = department;
        municipality.Name = "Valledupar";
        assertEquals("Valledupar/Cesar",municipality.toString());
    }

    @Test
    public void CreateEvent(){
        Calendar dateStart = new GregorianCalendar(2020, Calendar.MAY, 8, 8, 10);
        Calendar dateEnd = new GregorianCalendar(2020, Calendar.MAY, 8, 12, 10);

        Department department = new Department();
        department.Name = "Cesar";
        Municipality municipality = new Municipality();
        municipality.department = department;
        municipality.Name = "Valledupar";

        SubCategory subCategory = new SubCategory("Marcha");
        Category category = new Category("Deportes",subCategory);

        Event event = new Event("Marcha por la paz","123213","Esta marcha se realiza para...",null,"Activo",category,municipality,dateStart,dateEnd);
        event.Image = 1;
        event.State = "Activo";

        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String dateStar = simpleDateFormat.format(dateStart.getTime());
        String dateEn = simpleDateFormat.format(dateEnd.getTime());

        String formatHours = " HH:mm";
        SimpleDateFormat simpleDateHours = new SimpleDateFormat(formatHours);
        String hourStart = simpleDateHours.format(dateStart.getTime());
        String hourEnd = simpleDateHours.format(dateEnd.getTime());
        assertEquals("El evento esta disponible desde el " + dateStar +" a las "+ hourStart + " hasta el " + dateEn + " a las " + hourEnd,event.Availability());
    }

    @Test
    public void CreatePlace(){

        Department department = new Department();
        department.Name = "Cesar";
        Municipality municipality = new Municipality();
        municipality.department = department;
        municipality.Name = "Valledupar";

        SubCategory subCategory = new SubCategory("");
        Category category = new Category("Monumento",subCategory);

        Activity place = new Place("Pedazo de acordeon","123213","Monumento en conmemoracion a...",null,"Activo","Monumento",category,municipality);
        place.Image = 1;
        place.State = "Activo";

        assertEquals("Pedazo de acordeon,123213,Monumento en conmemoracion a...,Monumento",place.toString());
    }

    @Test
    public void AddDaysToSchedulePlaceCorrect(){

        Department department = new Department();
        department.Name = "Cesar";
        Municipality municipality = new Municipality();
        municipality.department = department;
        municipality.Name = "Valledupar";

        SubCategory subCategory = new SubCategory("Marcha");
        Category category = new Category("Deportes",subCategory);

        Place place = new Place("Pedazo de acordeon","123213","Monumento en conmemoracion a...",null,"Activo","Monumento",category,municipality);
        place.Image = 1;
        place.State = "Activo";

        String day = place.AddDays(1,"8:00 AM","6:00PM");

        assertEquals("Se añadio exitosamente",day);
    }

    @Test
    public void AddDaysToSchedulePlaceHigherTo7(){

        Department department = new Department();
        department.Name = "Cesar";
        Municipality municipality = new Municipality();
        municipality.department = department;
        municipality.Name = "Valledupar";

        SubCategory subCategory = new SubCategory("Marcha");
        Category category = new Category("Deportes",subCategory);

        Place place = new Place("Pedazo de acordeon","123213","Monumento en conmemoracion a...",null,"Activo","Monumento",category,municipality);
        place.Image = 1;
        place.State = "Activo";
        String day = place.AddDays(8,"8:00 AM","6:00PM");

        assertEquals("dia invalido",day);
    }

    @Test
    public void AddDaysToSchedulePlaceLessThan0(){

        Department department = new Department();
        department.Name = "Cesar";
        Municipality municipality = new Municipality();
        municipality.department = department;
        municipality.Name = "Valledupar";

        SubCategory subCategory = new SubCategory("Marcha");
        Category category = new Category("Deportes",subCategory);

        Place place = new Place("Pedazo de acordeon","123213","Monumento en conmemoracion a...",null,"Activo","Monumento",category,municipality);
        place.Image = 0;
        place.State = "Activo";
        String day = place.AddDays(8,"8:00 AM","6:00PM");

        assertEquals("dia invalido",day);
    }

    @Test
    public void AddDaysToSchedulePlaceRepeated(){

        Department department = new Department();
        department.Name = "Cesar";
        Municipality municipality = new Municipality();
        municipality.department = department;
        municipality.Name = "Valledupar";

        SubCategory subCategory = new SubCategory("Marcha");
        Category category = new Category("Deportes",subCategory);

        Place place = new Place("Pedazo de acordeon","123213","Monumento en conmemoracion a...",null,"Activo","Monumento",category,municipality);
        place.Image = 0;
        place.State = "Activo";
        place.AddDays(1,"8:00 AM","6:00PM");
        String day = place.AddDays(1,"8:00 AM","6:00PM");

        String responseExpected = "El Sitio de interes: Pedazo de acordeon esta disponible los: \n"
                + "1  desde las 8:00 AM hasta las 6:00PM\n"
                + "2  desde las 8:00 AM hasta las 6:00PM\n"
                + "3  desde las 8:00 AM hasta las 6:00PM\n"
                + "4  desde las 8:00 AM hasta las 6:00PM\n";

        assertEquals("dia invalido",day);
    }

    @Test
    public void PlaceAvailability(){

        Department department = new Department();
        department.Name = "Cesar";
        Municipality municipality = new Municipality();
        municipality.department = department;
        municipality.Name = "Valledupar";

        SubCategory subCategory = new SubCategory("Marcha");
        Category category = new Category("Deportes",subCategory);

        Place place = new Place("Pedazo de acordeon","123213","Monumento en conmemoracion a...",null,"Activo","Monumento",category,municipality);
        place.Image = 0;
        place.State = "Activo";
        place.AddDays(1,"8:00 AM","6:00PM");
        place.AddDays(2,"8:00 AM","6:00PM");
        place.AddDays(3,"8:00 AM","6:00PM");
        place.AddDays(4,"8:00 AM","6:00PM");

        String responseExpected = "El Sitio de interes: Pedazo de acordeon esta disponible los:\n"
                + "1 desde las 8:00 AM hasta las 6:00PM\n"
                + "2 desde las 8:00 AM hasta las 6:00PM\n"
                + "3 desde las 8:00 AM hasta las 6:00PM\n"
                + "4 desde las 8:00 AM hasta las 6:00PM\n";

        assertEquals(responseExpected,place.Availability());
    }

}