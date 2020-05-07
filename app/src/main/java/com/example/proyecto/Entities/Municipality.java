package com.example.proyecto.Entities;

public class Municipality {

    public  String Name;
    public Department department;

    public Municipality(){

    }

    @Override
    public String toString() {
        return Name + department;
    }
}
