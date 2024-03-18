package org.utl.dsm.MongoBlog.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.utl.dsm.MongoBlog.entity.Publicacion;
import org.utl.dsm.MongoBlog.entity.Usuario;

import java.util.List;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, Integer> {
    Usuario findByEmail(String email);
    Usuario findByUsuario(String usuario);
}