package com.example.interfaces;

import java.io.IOException;

import com.example.App;
import com.example.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class inicioSesionController {

    @FXML
    private PasswordField PASSWORDFIELD_CONTRASEÑA;

    @FXML
    private TextField TEXTFIELD_USUARIO;

    @FXML
    void BOTON_CREAR(ActionEvent event) throws IOException{
        App.setRoot("registroUsuario");
    }

    @FXML
    void BOTON_INICIO(ActionEvent event) throws IOException{
        if(!TEXTFIELD_USUARIO.getText().isEmpty() && !PASSWORDFIELD_CONTRASEÑA.getText().isEmpty())
        {   
            String user = TEXTFIELD_USUARIO.getText();
            String pass = PASSWORDFIELD_CONTRASEÑA.getText();

            int state = model.login(user, pass);
            System.out.println(state);
            if(state!=404){

                if(state == 1){
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("Error en los datos");
                    errorAlert.setContentText("La informacion de inicio de sesion es invalida.");
                    errorAlert.showAndWait();
                }else{
                    App.setRoot("Inicio");       
                }
            }
            else{            
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Error en los datos");
                errorAlert.setContentText("No se encuentra esa informacion en el sistema.");
                errorAlert.showAndWait();                 
        }}
        else{            
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Error en los datos");
            errorAlert.setContentText("La informacion de inicio de sesion esta vacia.");
            errorAlert.showAndWait();                             
        }
        
    }

}
