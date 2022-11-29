package com.clases.loggerSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.clases.prendas.prenda;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class logPrendasOuttest {
    @Test
    public void probarLoad() throws IOException {
        boolean ams=false;
        logPrendasOut loggers= new logPrendasOut();
        List<prenda> prendas= new ArrayList<prenda>();
        boolean asm= loggers.save(prendas);
        assertEquals(ams,asm);

    }
}
