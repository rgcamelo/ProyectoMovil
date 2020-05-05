package Entities;


public abstract class Activity {

    public String Name;
    public String Location;
    public String Description;
    public String Phone;
    public String State;
    public String Type;
    public Municipio Municipality;
    public Categoria Category;
    private int Like = 0;
    private int Assistant = 0;

    public void Likes(){
        Like += 1;
    }

    public void Assistants(){
        Assistant += 1;
    }

    public abstract String Availability();

}
