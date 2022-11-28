package com.example;
import java.io.*;
import java.util.Optional;

import com.clases.loggerSystem.*;
import com.clases.usuario.usuario;;
public class model {
    static private model singleton = null;
    private model() { }
    static public model getSingleton() {

        if (singleton == null) {
            singleton = new model();
        }
        return singleton;
    }
    public String metodo() {
        return "Singleton instanciado bajo demanda";
    }
    private static usuario userActive = null;
    public static void setUsuario(usuario user){
       userActive=user;
    }
    public static int login(String user,String pass)
    {
        System.out.println(user);
        Optional<usuario> u= cargar(user, pass);
        if(u!=null)
            {
                setUsuario(u.get());
                return 0;
            }
        return 1;
    }
    public static void guardar(usuario user)
    {
        logger logger = new logOut();
        ((logOut)logger).save(user);
    }
    public static Optional<usuario> cargar (String user,String pass)
    {
        logger logger = new logIn();
        return ((logIn)logger).load(user, pass);
    }
    public static void crear(String user, String pass, String nombre, String apellido)
    {
        usuario u = new usuario(user, pass, nombre, apellido);
        setUsuario(u);
        guardar(u);
    }
    public static void printInfo()
    {
        System.out.println(userActive.getNombre());
    }
}
