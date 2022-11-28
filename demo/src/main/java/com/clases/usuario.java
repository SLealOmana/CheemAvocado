package com.clases;

import java.io.Serializable;
import com.clases.paySystem.*;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class usuario implements Serializable {

    private String user;
    private String pass;
    private String nombre;
    private String apellido;
    private CreditCard creditCard;
    private String PayMethod;

    public usuario(String user,String pass,String nombre,String apellido)
    {
        this.user=user;
        this.pass=pass;
        this.nombre=nombre;
        this.apellido=apellido;
        this.creditCard=null;
        this.PayMethod="PayByCash";
    }
    
    
}
