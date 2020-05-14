package com.example.proyecto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.proyecto.Data.ConnectionSQLiteHelper;
import com.example.proyecto.Data.Contract;
import com.example.proyecto.Entities.Activity;
import com.example.proyecto.Entities.Category;
import com.example.proyecto.Entities.Event;
import com.example.proyecto.Entities.Municipality;
import com.example.proyecto.Entities.SubCategory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class DataBaseTest {
    private  ConnectionSQLiteHelper dbHelper;

    @Before
    public void createDb(){
        Context context = ApplicationProvider.getApplicationContext();
        dbHelper = new ConnectionSQLiteHelper(context);
    }

    @After
    public void closeDb() throws IOException{
        dbHelper.close();
    }

    @Test
    public void SelectDepartmentTables(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] projection = {
                Contract.DepartmentEntry.DEPARTMENT_ID,
                Contract.DepartmentEntry.COLUMN_DEPARTMENT_NAME
        };

        Cursor cursor = db.query(
                Contract.DepartmentEntry.TABLE_NAME,   // The table to query
                projection,            // The columns to return
                null,                  // The columns for the WHERE clause
                null,                  // The values for the WHERE clause
                null,                  // Don't group the rows
                null,                  // Don't filter by row groups
                null);
        String currentName=null;
        int idColumnIndex = cursor.getColumnIndex(Contract.DepartmentEntry.DEPARTMENT_ID);
        int nameColumnIndex = cursor.getColumnIndex(Contract.DepartmentEntry.COLUMN_DEPARTMENT_NAME);
        while (cursor.moveToNext()) {
            // Use that index to extract the String or Int value of the word
            // at the current row the cursor is on.
            int currentID = cursor.getInt(idColumnIndex);
            currentName = cursor.getString(nameColumnIndex);
        }
        assertEquals("Cesar", currentName);
    }

    @Test
    public void SelectMunicipalityTables(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ArrayList<String> queryResult = new ArrayList<>();

        String[] projection = {
                Contract.MunicipalityEntry.MUNICIPALITY_ID,
                Contract.MunicipalityEntry.COLUMN_MUNICIPALITY_NAME,
                Contract.MunicipalityEntry.COLUMN_DEPARTMENT_ID

        };

        Cursor cursor = db.query(
                Contract.MunicipalityEntry.TABLE_NAME,   // The table to query
                projection,            // The columns to return
                null,                  // The columns for the WHERE clause
                null,                  // The values for the WHERE clause
                null,                  // Don't group the rows
                null,                  // Don't filter by row groups
                null);

        int idColumnIndex = cursor.getColumnIndex(Contract.MunicipalityEntry.MUNICIPALITY_ID);
        int nameColumnIndex = cursor.getColumnIndex(Contract.MunicipalityEntry.COLUMN_MUNICIPALITY_NAME);
        int departmentColumnIndex = cursor.getColumnIndex(Contract.MunicipalityEntry.COLUMN_DEPARTMENT_ID);

        while (cursor.moveToNext()) {
            // Use that index to extract the String or Int value of the word
            // at the current row the cursor is on.
            int currentID = cursor.getInt(idColumnIndex);
            String currentName = cursor.getString(nameColumnIndex);
            int currentDepartment = cursor.getInt(departmentColumnIndex);

            queryResult.add(currentID + ","+ currentName + "," + currentDepartment);

        }
        ArrayList<String> queryExpectect = new ArrayList<>();
        queryExpectect.add("1,Valledupar,1");
        queryExpectect.add("2,Chiriguana,1");
        queryExpectect.add("3,La Jagua de Ibirico,1");
        queryExpectect.add("4,Agustin Codazzi,1");
        queryExpectect.add("5,Aguachica,1");
        queryExpectect.add("6,El paso,1");
        queryExpectect.add("7,Curumani,1");
        queryExpectect.add("8,Chimichagua,1");
        queryExpectect.add("9,Bosconia,1");
        queryExpectect.add("10,La Paz,1");
        queryExpectect.add("11,Rio de Oro,1");
        queryExpectect.add("12,Becerril,1");
        queryExpectect.add("13,El Copey,1");
        queryExpectect.add("14,Pueblo Bello,1");
        queryExpectect.add("15,Astrea,1");
        queryExpectect.add("16,Pailitas,1");
        queryExpectect.add("17,Tamalameque,1");
        queryExpectect.add("18,San Diego,1");
        queryExpectect.add("19,Pelaya,1");
        queryExpectect.add("20,La Gloria,1");
        queryExpectect.add("21,San Alberto,1");
        queryExpectect.add("22,San Martin,1");
        queryExpectect.add("23,Gamarra,1");
        queryExpectect.add("24,Gonzalez,1");
        queryExpectect.add("25,Manaure Balcon del Cesar,1");

        assertEquals("Consulta realizada exitosamente",queryExpectect, queryResult);

    }

    @Test
    public void SelectMunicipalityValledupar(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                Contract.MunicipalityEntry.MUNICIPALITY_ID,
                Contract.MunicipalityEntry.COLUMN_MUNICIPALITY_NAME,
                Contract.MunicipalityEntry.COLUMN_DEPARTMENT_ID

        };

        Cursor cursor = db.query(
                Contract.MunicipalityEntry.TABLE_NAME,   // The table to query
                projection,            // The columns to return
                Contract.MunicipalityEntry.COLUMN_MUNICIPALITY_NAME + "= 'Valledupar'",                  // The columns for the WHERE clause
                null,                  // The values for the WHERE clause
                null,                  // Don't group the rows
                null,                  // Don't filter by row groups
                null);

        int idColumnIndex = cursor.getColumnIndex(Contract.MunicipalityEntry.MUNICIPALITY_ID);
        int nameColumnIndex = cursor.getColumnIndex(Contract.MunicipalityEntry.COLUMN_MUNICIPALITY_NAME);
        int departmentColumnIndex = cursor.getColumnIndex(Contract.MunicipalityEntry.COLUMN_DEPARTMENT_ID);
        String currentName = null;
        while (cursor.moveToNext()) {
            // Use that index to extract the String or Int value of the word
            // at the current row the cursor is on.
            int currentID = cursor.getInt(idColumnIndex);
            currentName = cursor.getString(nameColumnIndex);
            int currentDepartment = cursor.getInt(departmentColumnIndex);

        }
        assertEquals("Consulta realizada exitosamente","Valledupar",currentName);

    }
    /*
    @Test
    public void InsertEvent(){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        SubCategory subCategory = new SubCategory("civica");

        Category category = new Category("Deportes",subCategory);

        Municipality municipality = new Municipality();
        municipality.Name = "Valledupar";

        Calendar dateStart = new GregorianCalendar(2020, Calendar.MAY, 8, 8, 10);
        Calendar dateEnd = new GregorianCalendar(2020, Calendar.MAY, 8, 12, 10);

        Activity event = new Event("Marcha por la paz","123213","Esta marcha se realiza para...",null,"Activo",category,municipality, dateStart,dateEnd);

        ContentValues values = new ContentValues();
        values.put(Contract.EventEntry.COLUMN_EVENT_NAME, event.Name);
        values.put(Contract.EventEntry.COLUMN_EVENT_LOCATION, event.Location);
        values.put(Contract.EventEntry.COLUMN_EVENT_DESCRIPTION, event.Description);
        values.put(Contract.EventEntry.COLUMN_EVENT_PHONE, event.Phone);
        values.put(Contract.EventEntry.COLUMN_EVENT_STATE, event.State);
        values.put(Contract.EventEntry.COLUMN_CATEGORY_ID, event.Category.toString());
        values.put(Contract.EventEntry.COLUMN_MUNICIPALITY_ID, 1);
        values.put(Contract.EventEntry.COLUMN_EVENT_START, String.valueOf(dateStart));
        values.put(Contract.EventEntry.COLUMN_EVENT_END, String.valueOf(dateEnd));

        db.insert(Contract.EventEntry.TABLE_NAME,null,values);
        SQLiteDatabase dbS = dbHelper.getReadableDatabase();

        String[] projection = {
                Contract.EventEntry.EVENT_ID,
                Contract.EventEntry.COLUMN_EVENT_NAME,
                Contract.EventEntry.COLUMN_EVENT_DESCRIPTION,
                Contract.EventEntry.COLUMN_MUNICIPALITY_ID,


        };

        Cursor cursor = dbS.query(
                Contract.EventEntry.TABLE_NAME,   // The table to query
                projection,            // The columns to return
                Contract.EventEntry.COLUMN_MUNICIPALITY_ID+ "= 1",                  // The columns for the WHERE clause
                null,                  // The values for the WHERE clause
                null,                  // Don't group the rows
                null,                  // Don't filter by row groups
                null);

        int idColumnIndex = cursor.getColumnIndex(Contract.EventEntry.EVENT_ID);
        int nameColumnIndex = cursor.getColumnIndex(Contract.EventEntry.COLUMN_EVENT_NAME);
        int descriptionColumnIndex = cursor.getColumnIndex(Contract.EventEntry.COLUMN_EVENT_DESCRIPTION);

        int currentID = cursor.getInt(idColumnIndex);
        String currentName = cursor.getString(nameColumnIndex);
        int currentDescription = cursor.getInt(descriptionColumnIndex);

        String queryResult = currentID +","+ currentName+","+currentDescription;

        assertEquals("1,Marcha por la paz,Esta marcha se realiza para...",queryResult);
    }*/



}
