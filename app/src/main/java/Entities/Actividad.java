package Entities;


public class Actividad{

    private String Nombre;
    private String Ubicacion;
    private String Descripcion;
    private String Telefono;
    private String Estado;
    private String Tipo;
    private Municipio Municipio;
    private Categoria Categoria;
    private int Megusta = 0;
    private int Asistire = 0;

    public Actividad(String nombre, String ubicacion, String descripcion, String telefono, String estado,String tipo, Categoria categoria, Disponibilidad disponibilidad, Municipio municipio){
        Nombre = nombre;
        Ubicacion = ubicacion;
        Descripcion = descripcion;
        Telefono = telefono;
        Estado = estado;
        Tipo = tipo;
        Municipio = municipio;
        Categoria = categoria;
    }

    public void Megusta(){
        Megusta += 1;
    }

    public void Asistire(){
        Asistire += 1;
    }

}
