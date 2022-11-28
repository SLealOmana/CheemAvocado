package com.clases.prendas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class prenda implements vendible{

    private String estilo;
    private String owner;
    private String descripcion;
    private byte[] photo;

    @Override
    public void vender(String owner) {
        this.setOwner(owner);
    }
}
