package com.example.proyecto.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.proyecto.R;

import java.util.ArrayList;

public class AdapterlistOptionSearch extends BaseAdapter {
    private Context context;
    private ArrayList<String> listaopcion;

    public AdapterlistOptionSearch(Context context, ArrayList<String> listaopcion) {
        this.context = context;
        this.listaopcion = listaopcion;
    }


    @Override
    public int getCount() {
        return listaopcion.size();
    }

    @Override
    public Object getItem(int position) {
        return listaopcion.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String string = (String) getItem(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.item_list_option_search,null);
        TextView option = (TextView) convertView.findViewById(R.id.optionitem);

        option.setText(string);

        return  convertView;
    }
}
