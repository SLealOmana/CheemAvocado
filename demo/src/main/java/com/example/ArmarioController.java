package com.example;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.imageio.ImageIO;

import com.google.gson.Gson;

import java.awt.image.BufferedImage;
import javafx.scene.image.Image;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    void actualizarPantalla (int cont){
        Gson gson = new Gson();
/* 
            if (cont+1<productos.size()){
                cont++;
                p1_imagen.setImage(productos.get(cont).getImagenProducto());
                p1_name.setText(productos.get(cont).getNombreProducto());
                p1_descripcion.setText(productos.get(cont).getDescripcionProducto());
                p1_precio.setText((String.valueOf(productos.get(cont).getPrecioProducto())));
            }*/

    }
@FXML
    void add_prenda(ActionEvent event) throws IOException{
        FileChooser fil_chooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = 
                        new FileChooser.ExtensionFilter("Img files (*.png,, *.jpg...)", "*.png", "*.jpg", "*.jpeg");
                        fil_chooser.getExtensionFilters().add(extFilter);
        File file = fil_chooser.showOpenDialog(null);
                if (file != null) {
                    System.out.println(file.getAbsolutePath()+ "  selected");
                    byte[] fileContent = Files.readAllBytes(file.toPath());
                    ByteArrayInputStream inStreambj = new ByteArrayInputStream(fileContent);
                    BufferedImage newImage = ImageIO.read(inStreambj);
                    ImageIO.write(newImage, "jpg", new File("demo\\src\\main\\resources\\com\\example\\tmp\\outputImage.jpg"));
                    File fl = new File("demo\\src\\main\\resources\\com\\example\\tmp\\outputImage.jpg");
                    Image im = new Image(fl.toURI().toString());
                    display.setImage(im);;
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
