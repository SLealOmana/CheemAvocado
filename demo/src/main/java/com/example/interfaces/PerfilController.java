package com.example.interfaces;


import java.io.IOException;

import com.example.App;
import com.example.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PerfilController {
    @FXML
    private TextField apellido;
    @FXML
    private TextField nombre;

    @FXML
    private Button nombreButton;

    @FXML
    private Button nombreButton1;

    @FXML
    private Label usuario;
    @FXML
    private Button button_Armario;

    @FXML
    private Button button_Tienda;

    @FXML
    private Button button_Inicio;

    @FXML
    private Button button_Perfil;
    @FXML
    private Button updateButton;
    private model modelo = model.getSingleton();
    
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
    @FXML
    void onloadUpdate()
    {
        usuario.setText(modelo.getUsuario().getUser());
        nombre.setText(modelo.getUsuario().getNombre());
        apellido.setText(modelo.getUsuario().getApellido());
    }
    

}
