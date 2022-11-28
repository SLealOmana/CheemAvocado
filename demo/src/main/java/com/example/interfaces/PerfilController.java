package com.example.interfaces;


import java.io.IOException;

import com.example.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PerfilController {

    @FXML
    private Button button_Armario;

    @FXML
    private Button button_Tienda;

    @FXML
    private Button button_Inicio;

    @FXML
    private Button button_Perfil;

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

}