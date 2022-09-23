package com.clases;

import java.io.Serializable;

public class usuario implements Serializable {
    private String user;
    private String pass;
    private String nombre;
    private String apellido;
    public usuario(String user,String pass,String nombre,String apellido)
    {
        this.user=user;
        this.pass=pass;
        this.nombre=nombre;
        this.apellido=apellido;
    }
    public String getUser()
    {
        return user;
    }
    public String getPass()
    {
        return pass;
    }
    public String getNombre()
    {
        return nombre;
    }
    public String getApellido()
    {
        return apellido;
    }
    public void setUser(String user){
        this.user=user;
    }
    public void setPass(String pass){
        this.pass=pass;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setApellido(String apellido)
    {
        this.apellido=apellido;
    }
    
}
