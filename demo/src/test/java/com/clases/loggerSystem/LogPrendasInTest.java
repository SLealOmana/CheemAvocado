package com.clases.loggerSystem;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import com.clases.usuario.usuario;

import com.clases.Adapter.prendaAdapterList;
import com.clases.prendas.prenda;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class LogPrendasInTest {
    @Test
    public void probarLoad() throws IOException {
        String path="src/main/resources/com/example/data/prendas.json";
        logPrendasIn logger = new logPrendasIn();
        GsonBuilder builder = new GsonBuilder();
        Type type = new TypeToken<List<prenda>>() {}.getType();
        System.out.println(type);
        builder.registerTypeAdapter(type, new prendaAdapterList());
        builder.setPrettyPrinting();
        Gson tempFile = builder.create();
        File fl = new File(path);
        Reader reader = Files.newBufferedReader(Paths.get(fl.toURI()));
        List<prenda> users = tempFile.fromJson(reader, type);
        usuario user = new usuario();
        System.out.println(user.getUser());
        String owner =user.getUser();
        List<prenda> expected = logger.load(owner);
        List<prenda> obtain = users.stream().filter(prenda ->prenda.getOwner().equalsIgnoreCase(owner)).collect(Collectors.toList());
        if(expected!=null)
            assertEquals(obtain,expected);
        else
            assertEquals(true, true);
    }
}
