package com.clases.loggerSystem;
import com.clases.usuario.usuario;
import org.junit.Test;
import java.io.IOException;

import static org.junit.Assert.*;

public class logouttest {
    @Test
    public void probarLoad() throws IOException {
        boolean ans= false;
        logOut logger= new logOut();
        usuario u= new usuario();
        boolean ass= logger.save(u);
        assertEquals(ans,ass);
    }
}
