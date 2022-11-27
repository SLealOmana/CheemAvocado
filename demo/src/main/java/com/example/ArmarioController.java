package com.example;

import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;


public class ArmarioController
{
    FileChooser fil_chooser = new FileChooser();
    @FXML
    private Button button_Armario;

    @FXML
    private Button button_Camara;

    @FXML
    private Button button_Inicio;

    @FXML
    private Button button_Perfil;
    @FXML
    private Button button_add;
    @FXML
    private Button button_search;
    @FXML
    void add_prenda(ActionEvent event) throws IOException{
        File file = fil_chooser.showOpenDialog(null);
                if (file != null) {
                    System.out.println(file.getAbsolutePath()+ "  selected");
                }
    }
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