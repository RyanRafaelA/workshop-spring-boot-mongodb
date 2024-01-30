package com.ryanrafael.workshopmongo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ryanrafael.workshopmongo.dominio.Publicar;

@Repository
public interface RepositorioPublicar extends MongoRepository<Publicar, String>{

}
