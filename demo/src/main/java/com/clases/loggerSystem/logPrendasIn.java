package com.clases.loggerSystem;
import java.io.File;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import com.clases.Adapter.prendaAdapterList;
import com.clases.prendas.prenda;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class logPrendasIn implements logger{
    public List<prenda> load(String owner)
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
            try {
                return users.stream().filter(prenda ->prenda.getOwner().equalsIgnoreCase(owner)).collect(Collectors.toList());
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
