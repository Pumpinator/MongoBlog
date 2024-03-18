package org.utl.dsm.MongoBlog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Reaccion {
    ME_GUSTA("Me gusta"),
    ME_ENCANTA("Me encanta");

    private final String nombre;
}