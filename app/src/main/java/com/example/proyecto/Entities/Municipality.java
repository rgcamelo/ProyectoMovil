package com.example.proyecto.Entities;

public class Municipality {

    public  String Nombre;
    public Department department;

    @Override
    public String toString() {
        return Nombre + department;
    }
}
