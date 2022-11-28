package com.clases.usuario;

import java.io.IOException;
import java.io.Serializable;
import com.clases.paySystem.*;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class usuario {

    private String user;
    private String pass;
    private String nombre;
    private String apellido;
    private String PayMethod;

    public usuario(String user,String pass,String nombre,String apellido)
    {
        this.user=user;
        this.pass=pass;
        this.nombre=nombre;
        this.apellido=apellido;
        this.PayMethod="PayByCash";
    } 
}
