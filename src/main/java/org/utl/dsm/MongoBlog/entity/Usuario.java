package org.utl.dsm.MongoBlog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "usuarios")
public class Usuario {
    @Id
    private String id;
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
    @Indexed(unique = true)
    @Email(message = "El formato del email es inválido")
    private String email;
    @Indexed(unique = true)
    private String usuario;
    private String password;
    @JsonIgnore
    private List<Publicacion> publicaciones = new ArrayList<>();
}
