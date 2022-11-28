package com.example.interfaces;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.clases.Publicacion;
import com.example.App;

public class InicioController {
    List<Publicacion> publicaciones = new ArrayList<>();
    int cont =0;

    @FXML
    private Button botonAnterior;

    @FXML
    private Button botonSiguiente;

    @FXML
    private Button button_armario;

    @FXML
    private Button button_inicio;

    @FXML
    private Button button_perfil;

    @FXML
    private Button button_tienda;

    @FXML
    private Label descripcion;

    @FXML
    private ImageView imagenPublicacion;

    @FXML
    private Label usuario;

    @FXML
    void ir_Armario(ActionEvent event) throws IOException{
        App.setRoot("Armario");
    }

    @FXML
    void ir_Tienda(ActionEvent event) throws IOException{
        App.setRoot("Tienda");
    }

    @FXML
    void ir_Inicio(ActionEvent event) throws IOException{
        App.setRoot("Inicio");
    }

    @FXML
    void ir_Perfil(ActionEvent event) throws IOException{
        App.setRoot("Perfil");
    }

    void botonSiguiente (ActionEvent event) throws IOException {
        if (cont < publicaciones.size()-1){
            cont++;
            actualizar(cont);
        }
    }

    void botonAnterior (ActionEvent event) throws IOException{
        if (cont>0){
            cont--;
            actualizar(cont);
        }
    }
    void actualizar (int posicion){
        usuario.setText(publicaciones.get(posicion).getUsuario());
        descripcion.setText(publicaciones.get(posicion).getDescripcion());
        imagenPublicacion.setImage(publicaciones.get(posicion).getImagenPublicacion());
    }
}

