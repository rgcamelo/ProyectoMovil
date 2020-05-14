package com.example.proyecto.Model.Entities;


import java.io.Serializable;

public abstract class Activity implements Serializable {

    public int Image;
    public String Name;
    public String Location;
    public String Description;
    public String Phone;
    public String State;
    public String Type;
    public Municipality Municipality;
    public Category Category;
    private int Like = 0;
    private int Assistant = 0;

    public void Likes(){
        Like += 1;
    }

    public void Assistants(){
        Assistant += 1;
    }

    public abstract String Availability();

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Municipality getMunicipality() {
        return Municipality;
    }

    public void setMunicipality(Municipality municipality) {
        Municipality = municipality;
    }

    public Category getCategory() {
        return Category;
    }

    public void setCategory(Category category) {
        Category = category;
    }

    public int getLike() {
        return Like;
    }

    public void setLike(int like) {
        Like = like;
    }

    public int getAssistant() {
        return Assistant;
    }

    public void setAssistant(int assistant) {
        Assistant = assistant;
    }
}
