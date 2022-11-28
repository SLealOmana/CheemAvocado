package com.clases.usuario;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@ToString
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
