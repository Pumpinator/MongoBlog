package org.utl.dsm.MongoBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.utl.dsm.MongoBlog.entity.Usuario;
import org.utl.dsm.MongoBlog.repository.UsuarioRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/usuario")
@Tag(name = "Usuario", description = "Operaciones relacionadas con usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository userRepository;

    @GetMapping("/all")
    @Operation(summary = "Obtener todos los usuarios")
    public List<Usuario> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/findByEmail/{email}")
    @Operation(summary = "Obtener usuario por email")
    public Usuario getUserByEmail(@PathVariable String email) {
        return userRepository.findByEmail(email);
    }

    @GetMapping("/findByUser/{user}")
    @Operation(summary = "Obtener usuario por usuario")
    public Usuario getUserByUser(@PathVariable String user) {
        return userRepository.findByUsuario(user);
    }

    @PostMapping("/")
    @Operation(summary = "Crear un nuevo usuario")
    public Usuario createUser(@RequestBody Usuario user) {
        // Obtener todos los usuarios de la base de datos
        List<Usuario> usuarios = userRepository.findAll();
        user.setUsuario(Instant.parse(user.getFechaNacimiento()+"T00:00:00.000Z").toString());

        // Verificar si existen usuarios en la base de datos
        boolean existenUsuarios = !usuarios.isEmpty();

        // Obtener el último ID de la lista de usuarios
        int nuevoId = existenUsuarios ? usuarios.stream().mapToInt(u -> Integer.parseInt(u.getId())).max().getAsInt() + 1 : 0;

        // Asignar el nuevo ID al usuario
        user.setId(String.valueOf(nuevoId));

        // Guardar el usuario en la base de datos
        return userRepository.save(user);
    }

    @PutMapping("/{email}")
    @Operation(summary = "Actualizar usuario por email")
    public Usuario updateUser(@PathVariable String email, @RequestBody Usuario userDetails) {
        Usuario usuario = userRepository.findByEmail(email);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado con email: " + email);
        }

        usuario.setNombre(userDetails.getNombre());
        usuario.setApellidos(userDetails.getApellidos());
        usuario.setUsuario(userDetails.getUsuario());
        usuario.setPassword(userDetails.getPassword());

        // Convertir String a Date
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            Date fechaNacimiento = sdf.parse(userDetails.getFechaNacimiento());
            usuario.setFechaNacimiento(fechaNacimiento.toString());
        } catch (ParseException e) {
            e.printStackTrace();
            // Manejar la excepción en caso de que ocurra un error al parsear la fecha
        }

        return userRepository.save(usuario);
    }

    @DeleteMapping("/{email}")
    @Operation(summary = "Eliminar usuario por email")
    public void deleteUser(@PathVariable String email) {
        Usuario usuario = userRepository.findByEmail(email);
        if (usuario != null) {
            userRepository.delete(usuario);
        }
    }
}