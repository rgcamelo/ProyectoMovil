package com.example.proyecto.Controller;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.proyecto.Model.Entities.Activity;
import com.example.proyecto.R;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

public class AdapterResultList extends RecyclerView.Adapter<AdapterResultList.ResultViewHolder> {

    private List<Activity> actividades;
    private Context context;

    public AdapterResultList( List<Activity> act, Context co){
        super();
        actividades = act;
        context = co;
    }

    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_result,parent,false);
        return new ResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder holder, int position) {
        Activity actividad = actividades.get(position);

        Log.i("AQUI2",actividad.getName());
        Log.i("AQUI2", actividad.getDescription());
        Log.i( "AQUI2",actividad.getImage());

        holder.titulo.setText(actividad.getName());
        holder.description.setText(actividad.getDescription());
        Glide.with(context).
                load(actividad.getImage()).
                centerCrop().
                diskCacheStrategy(DiskCacheStrategy.ALL).
                into(holder.imagen);

    }

    @Override
    public int getItemCount() {
        return actividades.size();
    }

    class ResultViewHolder extends RecyclerView.ViewHolder{

        private TextView titulo;
        private TextView description;
        private ImageView imagen;

        public ResultViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = (TextView) itemView.findViewById(R.id.tituloresul);
            description = (TextView) itemView.findViewById(R.id.descriptionresul);
            imagen = (ImageView) itemView.findViewById(R.id.imageresult);
        }
    }
}
