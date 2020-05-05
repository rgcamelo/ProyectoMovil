package Entities;

public class Category {

    public String Name;
    public SubCategory subCategory;

    @Override
    public String toString() {
        return Name + subCategory.toString();
    }
}
