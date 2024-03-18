package org.utl.dsm.MongoBlog.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.utl.dsm.MongoBlog.entity.Publicacion;

public interface PublicacionRepository extends MongoRepository<Publicacion, String> {
}