package com.clases.loggerSystem;

import com.clases.Adapter.usuarioAdapterList;
import com.clases.usuario.usuario;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import static org.junit.Assert.*;
public class logIntest {

    @Test
    public void probarLoad() throws IOException {

        logIn logger = new logIn();
        GsonBuilder builder = new GsonBuilder();
        Type type = new TypeToken<List<usuario>>() {}.getType();
        builder.registerTypeAdapter(type, new usuarioAdapterList());
        builder.setPrettyPrinting();
        usuario cliente  = new usuario();
        String user =cliente.getUser();
        String password = cliente.getPass();
        assertEquals(user,logger.load(user, password));
    }
}
