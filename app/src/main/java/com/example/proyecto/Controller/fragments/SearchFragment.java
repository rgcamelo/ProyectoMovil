package com.example.proyecto.Controller.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.proyecto.Controller.InterestSearchFragmentActivity;
import com.example.proyecto.Controller.ResultsSearchActivity;
import com.example.proyecto.Controller.WhenSearchFragmentActivity;
import com.example.proyecto.Controller.WhereSearchFragmentActivity;
import com.example.proyecto.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    public SearchFragment() {
        // Required empty public constructor
    }

    Button btnsearch;
    EditText cuando,donde,interes, buscar;
    CheckBox cblugar, cbevento;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        btnsearch = view.findViewById(R.id.btn_search_searchfragment);
        cargarActivitiesET(view);
        checkedboxes(view);
        return view;
    }

    public void cargarActivitiesET(View view){
        cuando = (EditText) view.findViewById(R.id.cuandoet);
        donde = (EditText) view.findViewById(R.id.dondeet);
        interes = (EditText) view.findViewById(R.id.intereset);
        buscar = (EditText) view.findViewById(R.id.etbuscar);

        cuando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WhenSearchFragmentActivity.class);
                startActivityForResult(intent,0);
            }
        });

        donde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getActivity(), WhereSearchFragmentActivity.class);
                startActivityForResult(intent2,1);
            }
        });

        interes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getActivity(), InterestSearchFragmentActivity.class);
                startActivityForResult(intent3,2);
            }
        });

        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Lugar="";
                if (cblugar.isChecked()){
                    Lugar = "Lugar";
                }
                else{
                    Lugar = "No";
                }

                String Evento = "";
                if (cbevento.isChecked()){
                    Evento = "Evento";
                }
                else{
                    Evento = "No";
                }


                Intent intent4 = new Intent(getActivity(), ResultsSearchActivity.class);
                intent4.putExtra("textobuscar", buscar.getText().toString() );
                intent4.putExtra("cuando", cuando.getText().toString());
                intent4.putExtra("donde", donde.getText().toString());
                intent4.putExtra("interes", interes.getText().toString());
                intent4.putExtra("Lugar", Lugar);
                intent4.putExtra("Evento", Evento);
                startActivity(intent4);
            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null){
            String opcion = data.getExtras().getString("opcion");

            if ( !opcion.equals("Atras") ){

                if (requestCode == 0){
                    cuando.setText(opcion);
                }
                if (requestCode == 1){
                    donde.setText(opcion);
                }
                if (requestCode == 2){
                    interes.setText(opcion);
                }
            }
        }
    }

    public void checkedboxes(final View view){
        cblugar = (CheckBox) view.findViewById(R.id.rb_lugar);
        cbevento = (CheckBox) view.findViewById(R.id.rb_evento);
        final LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.cuando_SearchPanel);
        final LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.checkboxpanel);
        linearLayout.setVisibility(View.GONE);
        linearLayout2.setVisibility(View.GONE);
        cbevento.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if( isChecked ){
                    linearLayout.setVisibility(View.VISIBLE);
                }
                else{
                    linearLayout.setVisibility(View.GONE);
                }
            }
        });

    }





}
