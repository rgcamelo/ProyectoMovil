package com.example.proyecto.Model.Entities;


import java.io.Serializable;

public abstract class Activity implements Serializable {

    public String Image;
    public String Name;
    public String Location;
    public String Description;
    public String Phone;
    public String State;
    public String Type;
    public String Web;
    public Municipality Municipality;
    public Category Category;
    private int Like = 0;
    private int Assistant = 0;
    public int icon;
    public String id;

    public String getWeb() {
        return Web;
    }

    public void setWeb(String web) {
        Web = web;
    }

    public void Likes(){
        Like += 1;
    }

    public void Assistants(){
        Assistant += 1;
    }

    public abstract String Availability();

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
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
