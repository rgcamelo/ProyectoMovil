package Entities;

import androidx.annotation.NonNull;

public class Categoria {

    public String Nombre;
    public  SubCategoria subCategoria;

    @Override
    public String toString() {
        return Nombre + subCategoria.toString();
    }
}
