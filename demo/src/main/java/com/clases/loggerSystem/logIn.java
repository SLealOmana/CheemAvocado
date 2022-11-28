package com.clases.loggerSystem;
import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import com.clases.usuario.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
public class logIn implements logger{
    public Optional<usuario> load(String user,String password)
    {try
        {
            String path="demo/src/main/resources/com/example/data/userData.json";
            File fl = new File(path);        
            Reader reader = Files.newBufferedReader(Paths.get(fl.toURI()));
            GsonBuilder builder = new GsonBuilder(); 
            builder.registerTypeAdapter(usuario.class, new usuarioAdapter()); 
            builder.setPrettyPrinting(); 
            Gson tempFile = builder.create(); 
            List<usuario> users = tempFile.fromJson(reader, new TypeToken<List<usuario>>() {}.getType());
            return users.stream().filter(usuario ->usuario.getUser().equalsIgnoreCase(user)&&usuario.getPass().equalsIgnoreCase(password)).findFirst();
        }
     catch(Exception e)
        {
            System.out.println("ERROR(LogIn):"+e);
            return null;
        }
    }
}

