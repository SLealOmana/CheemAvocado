package com.example;

import java.util.ArrayList;
import java.util.List;

import com.clases.loggerSystem.*;
import com.clases.prendas.prenda;
import com.clases.usuario.usuario;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class model {
    private static model singleton = null;
    private static usuario userActive = null;
    private static List<prenda> prendas =null;
    private static int pIndex=0;

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
    public int getPindex(){
        return pIndex;
    }
    public static int editPindex(int cant){
        pIndex=cant;
        return cant;
    }
    public usuario getUsuario(){
        return userActive;
    }
    public List<prenda> getPrendas(){
        if(prendas==null)
            prendas= new ArrayList<prenda>();
        return prendas;
    }
    public static void setUsuario(usuario user){
       userActive=user;
    }
    public static void loadPrendas()
    {
        logger logger = new logPrendasIn();
        System.out.println(userActive.getUser());
        prendas = ((logPrendasIn)logger).load(userActive.getUser());;
    }
    public void savePrendas()
    {
        logger logger = new logPrendasOut();
        ((logPrendasOut)logger).save(prendas);;
    }

    public static int login(String user,String pass)
    {
        System.out.println(user);
        usuario u= cargar(user, pass);
        if(u!=null)
            {
                setUsuario(u);
                loadPrendas();
                return 0;
            }
        return 1;
    }
    public static void guardar(usuario user)
    {
        logger logger = new logOut();
        ((logOut)logger).save(user);
    }
    public static usuario cargar (String user,String pass)
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
