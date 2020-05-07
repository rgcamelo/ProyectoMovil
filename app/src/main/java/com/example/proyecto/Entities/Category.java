package com.example.proyecto.Entities;

public class Category {

    public String Name;
    public SubCategory SubCategory;

    public Category(String name, SubCategory subCategory){
        Name = name;
        SubCategory = subCategory;
    }

    @Override
    public String toString() {
        return Name + SubCategory.toString();
    }
}
