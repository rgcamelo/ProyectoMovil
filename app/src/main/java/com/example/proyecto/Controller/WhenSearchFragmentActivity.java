package com.example.proyecto.Controller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.proyecto.R;

import java.util.ArrayList;

public class WhenSearchFragmentActivity extends AppCompatActivity {

    ListView listaWhen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_when_search_fragmet);

        listaWhen = (ListView) findViewById(R.id.listviewWhen);
        ArrayList<String> lista = cargarLista();
        final Context context = this;
        AdapterlistOptionSearch adapterlistOptionSearch = new AdapterlistOptionSearch(context, lista);
        listaWhen.setAdapter(adapterlistOptionSearch);
        listaWhen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 5){
                    Intent i2 = new Intent(context,CalendarWhenSearch.class);
                    startActivityForResult(i2,0);
                }else {
                    Intent i = getIntent();
                    i.putExtra("opcion", parent.getItemAtPosition(position).toString());
                    setResult(RESULT_OK,i);
                    finish();
                }
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.topbar_when,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i = getIntent();
                i.putExtra("opcion", "Atras");
                setResult(RESULT_OK,i);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null){
            String opcion = data.getExtras().getString("fecha");

            if ( !opcion.equals("Atras") ){

                if (requestCode == 0){
                    Intent i = getIntent();
                    i.putExtra("opcion", opcion);
                    setResult(RESULT_OK,i);
                    finish();
                }
            }
        }
    }

    public ArrayList<String> cargarLista(){
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("Cuando Sea");
        lista.add("Hoy");
        lista.add("Mañana");
        lista.add("Este fin de semana");
        lista.add("El proximo mes");
        lista.add("Selecciona una fecha");

        return lista;
    }


}
