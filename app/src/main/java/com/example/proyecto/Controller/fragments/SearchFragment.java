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

import com.example.proyecto.Controller.WhenSearchFragmentActivity;
import com.example.proyecto.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    public SearchFragment() {
        // Required empty public constructor
    }

    Button btnsearch;
    EditText cuando;
    CheckBox cblugar, cbevento;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        btnsearch = view.findViewById(R.id.btn_search_searchfragment);
        cuando = (EditText) view.findViewById(R.id.cuandoet);
        checkedboxes(view);
        cuando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WhenSearchFragmentActivity.class);
                startActivityForResult(intent,0);
            }
        });

        return view;

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
            }
        }
    }

    public void checkedboxes(final View view){
        cblugar = (CheckBox) view.findViewById(R.id.rb_lugar);
        cbevento = (CheckBox) view.findViewById(R.id.rb_evento);
        final LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.cuando_SearchPanel);
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
