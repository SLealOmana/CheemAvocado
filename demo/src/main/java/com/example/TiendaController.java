package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TiendaController {

    List<Producto> productos = new ArrayList<>();
    int cont=-1;

    //Atualizo con los primeros 4 productos
    public TiendaController(List <Producto> productosEntry){
        productos= new ArrayList<Producto>(productosEntry);
        actualizarPantalla(cont, true);
    }

    @FXML
    void  boton_anterior(ActionEvent event) throws IOException{
        actualizarPantalla(cont,false);
    }

    @FXML
    void  boton_siguiente (ActionEvent event) throws  IOException{
        actualizarPantalla(cont, true);
    }
    @FXML
    private Button button_Armario;

    @FXML
    private Button button_Inicio;

    @FXML
    private Button button_Perfil;

    @FXML
    private Button button_Tienda;

    @FXML
    private Label p1_descripcion;

    @FXML
    private ImageView p1_imagen;

    @FXML
    private Label p1_name;

    @FXML
    private Label p1_precio;

    @FXML
    private Label p2_descripcion;
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

    @FXML
    private ImageView p2_imagen;

    @FXML
    private Label p2_name;

    @FXML
    private Label p2_precio;

    @FXML
    private Label p3_descripcion;

    @FXML
    private ImageView p3_imagen;

    @FXML
    private Label p3_name;

    @FXML
    private Label p3_precio;

    @FXML
    private Label p4_descripcion;

    @FXML
    private ImageView p4_imagen;

    @FXML
    private Label p4_name;

    @FXML
    private Label p4_precio;

    //movimiento es cuando nos vamos a mover a la derecha del arreglo productos (boton siguiente) y !movimiento es cuando nos movemos a la izquierda (boton anterior)
    void actualizarPantalla (int cont, boolean movimiento){
        if (movimiento ){

            if (cont+1<productos.size()){
                cont++;
                p1_imagen.setImage(productos.get(cont).getImagenProducto());
                p1_name.setText(productos.get(cont).getNombreProducto());
                p1_descripcion.setText(productos.get(cont).getDescripcionProducto());
                p1_precio.setText((String.valueOf(productos.get(cont).getPrecioProducto())));
            }
            if (cont+1<productos.size()){
                cont++;
                p2_imagen.setImage(productos.get(cont).getImagenProducto());
                p2_name.setText(productos.get(cont).getNombreProducto());
                p2_descripcion.setText(productos.get(cont).getDescripcionProducto());
                p2_precio.setText((String.valueOf(productos.get(cont).getPrecioProducto())));
            }
            if (cont+1<productos.size()){
                cont++;
                p3_imagen.setImage(productos.get(cont).getImagenProducto());
                p3_name.setText(productos.get(cont).getNombreProducto());
                p3_descripcion.setText(productos.get(cont).getDescripcionProducto());
                p3_precio.setText((String.valueOf(productos.get(cont).getPrecioProducto())));
            }
            if (cont+1<productos.size()){
                cont++;
                p4_imagen.setImage(productos.get(cont).getImagenProducto());
                p4_name.setText(productos.get(cont).getNombreProducto());
                p4_descripcion.setText(productos.get(cont).getDescripcionProducto());
                p4_precio.setText((String.valueOf(productos.get(cont).getPrecioProducto())));
            }

        }

        else{
            if (cont-1>=0){
                cont--;
                p1_imagen.setImage(productos.get(cont).getImagenProducto());
                p1_name.setText(productos.get(cont).getNombreProducto());
                p1_descripcion.setText(productos.get(cont).getDescripcionProducto());
                p1_precio.setText((String.valueOf(productos.get(cont).getPrecioProducto())));
            }
            if (cont-1>=0){
                cont--;
                p2_imagen.setImage(productos.get(cont).getImagenProducto());
                p2_name.setText(productos.get(cont).getNombreProducto());
                p2_descripcion.setText(productos.get(cont).getDescripcionProducto());
                p2_precio.setText((String.valueOf(productos.get(cont).getPrecioProducto())));
            }
            if (cont-1>=0){
                cont--;
                p3_imagen.setImage(productos.get(cont).getImagenProducto());
                p3_name.setText(productos.get(cont).getNombreProducto());
                p3_descripcion.setText(productos.get(cont).getDescripcionProducto());
                p3_precio.setText((String.valueOf(productos.get(cont).getPrecioProducto())));
            }
            if (cont-1>=0){
                cont--;
                p4_imagen.setImage(productos.get(cont).getImagenProducto());
                p4_name.setText(productos.get(cont).getNombreProducto());
                p4_descripcion.setText(productos.get(cont).getDescripcionProducto());
                p4_precio.setText((String.valueOf(productos.get(cont).getPrecioProducto())));
            }
        }
    }
}


