package com.example.proyecto.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CalendarView;

import com.example.proyecto.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarWhenSearch extends AppCompatActivity {

    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_when_search);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        calendarView = (CalendarView) findViewById(R.id.calendaWhen);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = dayOfMonth + "/"+ (month+1) + "/"+ year;

                Intent i = getIntent();
                i.putExtra("fecha", date);
                setResult(RESULT_OK,i);
                finish();
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i = getIntent();
                i.putExtra("fecha", "Atras");
                setResult(RESULT_OK,i);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
