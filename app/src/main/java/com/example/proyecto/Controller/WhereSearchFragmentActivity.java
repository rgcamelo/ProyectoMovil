package com.example.proyecto.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.proyecto.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class WhereSearchFragmentActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    ArrayList<String> listaopciones = new ArrayList<String>();
    ListView listaWhen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_when_search_fragmet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listaWhen = (ListView) findViewById(R.id.listviewWhen);
        final Context context = this;
        cargarlista(context);
    }

    public void cargarlista(final Context context){
        mDatabase = FirebaseDatabase.getInstance().getReference("5");
        //mDatabase.child("data").addValueEventListener(valueEventListener);
        Query query = mDatabase.child("data").orderByChild("namemunicipality");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){

                    for ( DataSnapshot ds : dataSnapshot.getChildren()
                    ) {
                        String name = ds.child("namemunicipality").getValue().toString();
                        listaopciones.add(name);
                    }
                    AdapterlistOptionSearch adapterlistOptionSearch = new AdapterlistOptionSearch(context, listaopciones);
                    listaWhen.setAdapter(adapterlistOptionSearch);
                    //adapterlistOptionSearch.notifyDataSetChanged();
                    listaWhen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent i = getIntent();
                            i.putExtra("opcion", parent.getItemAtPosition(position).toString());
                            setResult(RESULT_OK,i);
                            finish();
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
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
}
