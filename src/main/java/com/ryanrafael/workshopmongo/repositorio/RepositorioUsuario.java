package com.ryanrafael.workshopmongo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ryanrafael.workshopmongo.dominio.Usuario;

@Repository
public interface RepositorioUsuario extends MongoRepository<Usuario, String>{

}
