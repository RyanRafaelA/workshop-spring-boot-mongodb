package com.ryanrafael.workshopmongo.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ryanrafael.workshopmongo.dominio.Publicar;

@Repository
public interface RepositorioPublicar extends MongoRepository<Publicar, String>{
	
	List<Publicar> findByTituloContainingIgnoreCase(String texto);

}