package com.example.interfaces;

import java.io.IOException;

import com.example.App;
import com.example.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.control.Alert;

public class registroUsuarioController {

    @FXML
    private CheckBox CHECKBOX_TC;

    @FXML
    private TextField TEXTFIELD_APELLIDO;

    @FXML
    private PasswordField TEXTFIELD_CONTRASEÑA1;

    @FXML
    private PasswordField TEXTFIELD_CONTRASEÑA2;

    @FXML
    private TextField TEXTFIELD_NAME;

    @FXML
    private TextField TEXTFIELD_USERNAME;

    @FXML
    void BOTON_CREAR_CUENTA(ActionEvent event) throws IOException{
        if(!CheckFields())
        {   
            String user = TEXTFIELD_USERNAME.getText();
            String pass = TEXTFIELD_CONTRASEÑA1.getText();
            String nombre = TEXTFIELD_NAME.getText();
            String apellido = TEXTFIELD_APELLIDO.getText();
            int state=0;
            if(!TEXTFIELD_CONTRASEÑA1.getText().equals(TEXTFIELD_CONTRASEÑA2.getText()))
                state=1;
            if(state!=404){
                if(state == 1){
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("Error en los datos");
                    errorAlert.setContentText("Las Contrasenas son distintas.");
                    errorAlert.showAndWait();
                }else{
                    if(!CHECKBOX_TC.isSelected())
                    {
                        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                        errorAlert.setHeaderText("Error");
                        errorAlert.setContentText("Porfavor acepte los terminos y condiciones.");
                        errorAlert.showAndWait();
                    }
                    else
                    {model.crear(user, pass, nombre, apellido);
                    App.setRoot("Inicio");   }    
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
            errorAlert.setContentText("La informacion esta vacia.");
            errorAlert.showAndWait();                             
        }
        
    }
    boolean CheckFields(){
        return TEXTFIELD_APELLIDO.getText().isEmpty()&&TEXTFIELD_CONTRASEÑA1.getText().isEmpty()&&TEXTFIELD_CONTRASEÑA2.getText().isEmpty()&&TEXTFIELD_NAME.getText().isEmpty()&&TEXTFIELD_USERNAME.getText().isEmpty();
    }
}


