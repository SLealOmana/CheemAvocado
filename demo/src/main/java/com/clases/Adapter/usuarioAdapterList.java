package com.clases.Adapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.clases.usuario.usuario;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class usuarioAdapterList extends TypeAdapter<List<usuario>> {
   @Override 
   public List<usuario> read(JsonReader reader) throws IOException {
      List<usuario> usuario = new ArrayList<usuario>();
      reader.beginArray();
      while (reader.hasNext()) {
         usuario.add(readUsuarios(reader));
      }
      reader.endArray();
      return usuario;
    }
    
    public usuario readUsuarios(JsonReader reader) throws IOException {
        
{      usuario usuario = new usuario(); 
       reader.beginObject();
       String fieldname = null; 
       
       while (reader.hasNext()) { 
          JsonToken token = reader.peek();            
          
          if (token.equals(JsonToken.NAME)) {     
             //get the current token 
             fieldname = reader.nextName(); 
          } 
          if ("user".equals(fieldname)) {       
             //move to next token 
             token = reader.peek(); 
             usuario.setUser(reader.nextString()); 
          } 
          if("pass".equals(fieldname)) { 
             //move to next token 
             token = reader.peek(); 
             usuario.setPass(reader.nextString()); 
          }
          if("nombre".equals(fieldname)) { 
            //move to next token 
            token = reader.peek(); 
            usuario.setNombre(reader.nextString()); 
         }
         if("apellido".equals(fieldname)) { 
            //move to next token 
            token = reader.peek(); 
            usuario.setApellido(reader.nextString()); 
         }
         if("PayMethod".equals(fieldname)) { 
            //move to next token 
            token = reader.peek(); 
            usuario.setPayMethod(reader.nextString()); 
         } 
       } 
       reader.endObject(); 
       return usuario; 
    }
   }  
   @Override 
   public void write(JsonWriter writer, List<usuario> usuarios) throws IOException {
      System.out.println("ENTEWEEEEADSADKLASDASLD");
      writer.beginArray();
      writer.setIndent("    ");
      for (usuario usuario : usuarios) {
        writeUsuarios(writer, usuario);
      }
      writer.endArray();
    }
    
    public void writeUsuarios(JsonWriter writer, usuario usuario) throws IOException { 
       writer.beginObject();
       writer.name("user"); 
       writer.value(usuario.getUser()); 
       writer.name("pass"); 
       writer.value(usuario.getPass()); 
       writer.name("nombre"); 
       writer.value(usuario.getNombre());
       writer.name("apellido"); 
       writer.value(usuario.getApellido());
       writer.name("PayMethod"); 
       writer.value(usuario.getPayMethod());
       writer.endObject();
    }
 }