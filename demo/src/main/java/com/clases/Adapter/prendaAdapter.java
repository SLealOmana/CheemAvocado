package com.clases.Adapter;

import java.io.IOException;
import java.util.Base64;

import com.clases.prendas.prenda;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class prendaAdapter extends TypeAdapter<prenda> {

    @Override 
    public prenda read(JsonReader reader) throws IOException {
      
{      prenda prenda = new prenda(); 
       reader.beginObject();
       String fieldname = null; 
       
       while (reader.hasNext()) { 
          JsonToken token = reader.peek();            
          
          if (token.equals(JsonToken.NAME)) { 
             fieldname = reader.nextName(); 
          } 
          if ("estilo".equals(fieldname)) {    
             token = reader.peek(); 
             prenda.setEstilo(reader.nextString()); 
          } 
          if("owner".equals(fieldname)) { 
             token = reader.peek(); 
             prenda.setOwner(reader.nextString()); 
          }
         if("descripcion".equals(fieldname)) { 
            token = reader.peek(); 
            prenda.setDescripcion(reader.nextString()); 
         }
         if("photo".equals(fieldname)) { 
            token = reader.peek();
            String s = reader.nextString(); 
            byte[] decode = Base64.getDecoder().decode(s);
            prenda.setPhoto(decode);
         } 
       } 
       reader.endObject(); 
       return prenda; 
    }
   }  
    
    @Override 
    public void write(JsonWriter writer, prenda prenda) throws IOException {
       writer.beginObject();
       writer.name("estilo"); 
       writer.value(prenda.getEstilo()); 
       writer.name("owner"); 
       writer.value(prenda.getOwner());
       writer.name("descripcion"); 
       writer.value(prenda.getDescripcion());
       writer.name("photo"); 
       writer.value(Base64.getEncoder().encodeToString(prenda.getPhoto()));
       writer.endObject();
    }
 }