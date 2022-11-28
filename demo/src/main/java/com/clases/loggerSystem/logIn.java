package com.clases.loggerSystem;
import java.io.File;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.clases.Adapter.usuarioAdapterList;
import com.clases.usuario.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
public class logIn implements logger{
    public usuario load(String user,String password)
    {try
        {
            String path="demo/src/main/resources/com/example/data/userData.json";
            GsonBuilder builder = new GsonBuilder();
            Type type = new TypeToken<List<usuario>>() {}.getType();
            System.out.println(type);
            builder.registerTypeAdapter(type, new usuarioAdapterList());
            builder.setPrettyPrinting();
            Gson tempFile = builder.create(); 
            File fl = new File(path);
            Reader reader = Files.newBufferedReader(Paths.get(fl.toURI()));
            List<usuario> users = tempFile.fromJson(reader, type);
            try {
                return users.stream().
                filter(usuario ->usuario.getUser().equalsIgnoreCase(user)&&usuario.getPass().
                equalsIgnoreCase(password)).findFirst().
                orElseThrow(() -> new IllegalArgumentException());
            }

             catch (IllegalArgumentException e) {
                return null;
            }
        }
     catch(Exception e)
        {
            System.out.println("ERROR(LogIn):"+e);
            return null;
        }
    }
}

