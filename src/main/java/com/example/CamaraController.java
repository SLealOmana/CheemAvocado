package com.example;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CamaraController {

    @FXML
    private Button button_Armario;

    @FXML
    private Button button_Camara;

    @FXML
    private Button button_Inicio;

    @FXML
    private Button button_Perfil;

    @FXML
    void ir_Armario(ActionEvent event) throws IOException{
        App.setRoot("Armario");
    }

    @FXML
    void ir_Camara(ActionEvent event) throws IOException{
        App.setRoot("Camara");
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
