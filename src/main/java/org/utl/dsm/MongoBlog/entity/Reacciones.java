package org.utl.dsm.MongoBlog.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reacciones {
    private Reaccion reaccion;
    @NotBlank
    private String usuario;
}
