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
import java.util.List;

public class InterestSearchFragmentActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    ListView listaWhen;
    ArrayList<String> lista = new ArrayList<String>();

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
        mDatabase = FirebaseDatabase.getInstance().getReference("2");
        Query query = mDatabase.child("data").orderByChild("nameCategory");
        //query.addValueEventListener(valueEventListener);

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    for ( DataSnapshot ds : dataSnapshot.getChildren()
                    ) {
                        String name = ds.child("nameCategory").getValue().toString();
                        lista.add(name);
                    }

                    AdapterlistOptionSearch adapterlistOptionSearch = new AdapterlistOptionSearch(context, lista);
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
