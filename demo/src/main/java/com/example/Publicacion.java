package com.example;

import javafx.scene.image.Image;
import lombok.Getter;
import lombok.Setter;

public class Publicacion {


    public String getUsuario() {
        return usuario;
    }

    public Image getImagenPublicacion() {
        return imagenPublicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }
    String usuario;
    Image imagenPublicacion;
    String descripcion;


}
