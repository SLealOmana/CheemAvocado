package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InicioController {
    List<Publicacion> publicaciones = new ArrayList<>();
    int cont =0;

    public InicioController(List <Publicacion> publiEntrada){
        publicaciones= new ArrayList<Publicacion>(publiEntrada);

    }

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
    void ir_Armario(ActionEvent event) {

    }

    @FXML
    void ir_Inicio(ActionEvent event) {

    }

    @FXML
    void ir_Perfil(ActionEvent event) {

    }

    @FXML
    void ir_Tienda(ActionEvent event) {

    }

    void botonSiguiente (ActionEvent event) throws IOException {
        if (cont< publicaciones.size()-1){
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

