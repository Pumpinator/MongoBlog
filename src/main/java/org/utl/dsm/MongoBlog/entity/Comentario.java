package org.utl.dsm.MongoBlog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comentario {
    @Id
    @JsonIgnore
    private int id;
    @Indexed
    private String usuario;
    @NonNull
    private String contenido;
    @JsonIgnore
    private String fecha;
}