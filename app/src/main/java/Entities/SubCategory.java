package Entities;

import androidx.annotation.NonNull;

public class SubCategory {

    public String Name;


    public SubCategory(String name){
        Name = name;
    }

    @Override
    public String toString() {
        return Name;
    }
}
