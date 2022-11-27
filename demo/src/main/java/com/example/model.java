package com.example;
import java.io.*;
import com.clases.usuario;

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
    public static int login      (String user,String pass)
    {
        System.out.println(user);
        usuario u= cargar(user, pass);
        if(u!=null)
            {
                setUsuario(u);
                return 0;
            }
        return 1;
    }
    public static void guardar(usuario user)
    {
        try{
        FileOutputStream fout=new FileOutputStream("data.txt",true);    
        ObjectOutputStream out=new ObjectOutputStream(fout);    
        out.writeObject(user); 
        out.flush();     
        out.close();    
        }catch(Exception e){System.out.println(e);}  
    }
    public static usuario cargar (String user,String pass)
    {
        try{
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("data.txt"));  
            try{
                usuario s = (usuario)in.readObject();
                while(s != null) {
                  
                    if(s.getUser().equals(user)&&s.getPass().equals(pass)){
                        in.close();
                        return s;}
                    else
                    s = (usuario)in.readObject();  
                }
            
            }catch(EOFException e){System.out.println(e);}
            return null;
        }catch(Exception e){System.out.println(e);
        e.printStackTrace();}  
        return null;
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
