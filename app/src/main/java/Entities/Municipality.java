package Entities;

import androidx.annotation.NonNull;

public class Municipality {

    public  String Nombre;
    public Department department;

    @Override
    public String toString() {
        return Nombre + department;
    }
}
