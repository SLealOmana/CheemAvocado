package com.clases.loggerSystem;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.clases.usuario;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
public class logIn implements logger{
    public Optional<usuario> load(String user,String password)
    {try
        {
            Reader reader = Files.newBufferedReader(Paths.get("data\\userData.json"));
            List<usuario> users = new Gson().fromJson(reader, new TypeToken<List<usuario>>() {}.getType());
            return users.stream().filter(usuario ->usuario.getUser().equalsIgnoreCase(user)&&usuario.getPass().equalsIgnoreCase(password)).findFirst();
        }
     catch(Exception e)
        {
            System.out.println("ERRROR "+ e.getStackTrace());
            return null;
        }
    }
}

