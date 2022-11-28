package com.clases.loggerSystem;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.clases.Adapter.usuarioAdapter;
import com.clases.Adapter.usuarioAdapterList;
import com.clases.usuario.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
public class logOut implements logger{
    public boolean save(usuario u)
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
            if(users!=null)
                {
                users.add(u);
                GsonBuilder builder2 = new GsonBuilder();
                builder2.registerTypeAdapter(usuario.class, new usuarioAdapter());
                builder2.setPrettyPrinting();
                Gson tempFile2 = builder2.create();
                Writer writer = Files.newBufferedWriter(Paths.get(path));
                writer.write("[");
                int size = 0;
                for (usuario usuario : users) {
                    tempFile2.toJson(usuario, writer);
                    size++;
                    if(size<users.size())
                        writer.write(",");
                }
                writer.write("]");
                writer.close();
            }
            else
            {
                builder.registerTypeAdapter(usuario.class, new usuarioAdapter());
                Gson tempFile2 = builder.create();
                Writer writer = Files.newBufferedWriter(Paths.get(path));
                writer.write("[");
                tempFile2.toJson(u, writer);
                writer.write("]");
                writer.close();
            }
            return true;
        }
     catch(IOException e)
        {
            System.out.println("ERROR(LogOut):"+e);
            return false;
        }
    }
}
