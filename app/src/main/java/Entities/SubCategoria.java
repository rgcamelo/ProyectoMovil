package Entities;

import androidx.annotation.NonNull;

public class SubCategoria {

    public String Nombre;


    public SubCategoria(String nombre){
        Nombre = nombre;
    }

    @Override
    public String toString() {
        return Nombre;
    }
}
