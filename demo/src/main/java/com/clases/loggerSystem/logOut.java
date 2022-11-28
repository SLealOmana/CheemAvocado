package com.clases.loggerSystem;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.clases.usuario;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
public class logOut implements logger{
    public boolean save(usuario u)
    {try
        {
            Gson tempFile = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("data\\userData.json"));
            List<usuario> users = new Gson().fromJson(reader, new TypeToken<List<usuario>>() {}.getType());
            users.add(u);
            Writer writer = Files.newBufferedWriter(Paths.get("data\\userData.json"));
            tempFile.toJson(users, writer);
            writer.close();
            return true;
        }
     catch(Exception e)
        {
            return false;
        }
    }
}
