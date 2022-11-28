package com.example.interfaces;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import javax.imageio.ImageIO;

import com.clases.prendas.prenda;
import com.example.App;
import com.example.model;

import java.awt.image.BufferedImage;
import javafx.scene.image.Image;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class ArmarioController
{
    @FXML
    void  boton_anterior(ActionEvent event) throws IOException{
        actualizarPantalla(1);
    }

    @FXML
    void  boton_siguiente (ActionEvent event) throws  IOException{
        actualizarPantalla(-1);
    }
    @FXML
    private ImageView display;
    
    @FXML
    private Button button_Armario;

    @FXML
    private Button button_Inicio;

    @FXML
    private Button button_Perfil;
    @FXML
    private Button button_add;
    @FXML
    private Button button_search;
    @FXML
    private Label displayText;
    @FXML
    private Label indXid;
    void actualizarPantalla (int cont) throws IOException{
        model modelo = model.getSingleton();
        int indexed= modelo.getPindex();
        List<prenda> p = modelo.getPrendas();
        if(indexed+cont<0)
            model.editPindex(p.size()-1);
        else if (indexed+cont>p.size()-1)
            model.editPindex(0);
        else
            model.editPindex(modelo.getPindex()+cont);
        ByteArrayInputStream inStreambj = new ByteArrayInputStream(p.get(modelo.getPindex()).getPhoto());
        BufferedImage newImage = ImageIO.read(inStreambj);
        ImageIO.write(newImage, "jpg", new File("demo\\src\\main\\resources\\com\\example\\tmp\\outputImage.jpg"));
        File fl = new File("demo\\src\\main\\resources\\com\\example\\tmp\\outputImage.jpg");
        Image im = new Image(fl.toURI().toString());
        display.setImage(im);
        indXid.setText(String.valueOf(modelo.getPindex()));
        displayText.setText(p.get(modelo.getPindex()).getDescripcion());
    }
@FXML
    void add_prenda(ActionEvent event) throws IOException{
        model modelo = model.getSingleton();
        FileChooser fil_chooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = 
                        new FileChooser.ExtensionFilter("Img files (*.png,, *.jpg...)", "*.png", "*.jpg", "*.jpeg");
                        fil_chooser.getExtensionFilters().add(extFilter);
        File file = fil_chooser.showOpenDialog(null);
                if (file != null) {
                    System.out.println(file.getAbsolutePath()+ "  selected");
                    byte[] fileContent = Files.readAllBytes(file.toPath());
                    prenda p = new prenda("", modelo.getUsuario().getUser(), file.getName(), fileContent);
                    modelo.getPrendas().add(p);
                    modelo.savePrendas();
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
