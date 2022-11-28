package com.clases.loggerSystem;
import java.io.File;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.clases.usuario.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
public class logOut implements logger{
    public boolean save(usuario u)
    {try
        {
            String path="demo/src/main/resources/com/example/data/userData.json";
            GsonBuilder builder = new GsonBuilder(); 
            builder.registerTypeAdapter(usuario.class, new usuarioAdapter()); 
            builder.setPrettyPrinting(); 
            Gson tempFile = builder.create(); 
            File fl = new File(path);
            Reader reader = Files.newBufferedReader(Paths.get(fl.toURI()));
            List<usuario> users = new Gson().fromJson(reader, new TypeToken<List<usuario>>() {}.getType());
            if(users!=null)
                {users.add(u);
                System.out.println("INNNNNNNNNNNNNNNN");
                Writer writer = Files.newBufferedWriter(Paths.get(path));
                for (usuario us : users)
                {
                    tempFile.toJson(us, writer);
                }
                writer.close();
            }
            else
            {
                Writer writer = Files.newBufferedWriter(Paths.get(path));
                tempFile.toJson(u, writer);
                writer.close();
            }
            return true;
        }
     catch(Exception e)
        {
            System.out.println("ERROR(LogOut):"+e);
            return false;
        }
    }
}
