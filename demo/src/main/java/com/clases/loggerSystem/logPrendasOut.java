package com.clases.loggerSystem;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.clases.Adapter.prendaAdapter;
import com.clases.Adapter.prendaAdapterList;
import com.clases.prendas.prenda;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
public class logPrendasOut implements logger{
    public boolean save(List<prenda> u)
    {try
        {
            String path="demo/src/main/resources/com/example/data/prendas.json";
            GsonBuilder builder = new GsonBuilder();
            Type type = new TypeToken<List<prenda>>() {}.getType();
            System.out.println(type);
            builder.registerTypeAdapter(type, new prendaAdapterList());
            builder.setPrettyPrinting();
            Gson tempFile = builder.create(); 
            File fl = new File(path);
            Reader reader = Files.newBufferedReader(Paths.get(fl.toURI()));
            List<prenda> users = tempFile.fromJson(reader, type);
            if(users!=null)
                {
                for (prenda prenda : u) {
                    users.add(prenda);
                } 
                GsonBuilder builder2 = new GsonBuilder();
                builder2.registerTypeAdapter(prenda.class, new prendaAdapter());
                builder2.setPrettyPrinting();
                Gson tempFile2 = builder2.create();
                Writer writer = Files.newBufferedWriter(Paths.get(path));
                //writer.write("[");
                int size = 0;
                for (prenda prenda : users) {
                    tempFile2.toJson(prenda, writer);
                    size++;
                    if(size<users.size())
                        writer.write(",");
                }
                //writer.write("]");
                writer.close();
            }
            else
            {
                builder.registerTypeAdapter(prenda.class, new prendaAdapter());
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
