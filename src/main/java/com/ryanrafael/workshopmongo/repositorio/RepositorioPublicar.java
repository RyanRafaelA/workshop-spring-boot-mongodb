package com.ryanrafael.workshopmongo.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ryanrafael.workshopmongo.dominio.Publicar;

@Repository
public interface RepositorioPublicar extends MongoRepository<Publicar, String>{
	
	@Query("{ 'titulo': { $regex: ?0, $options: 'i' } }")
	List<Publicar> procurarTitulo(String texto);
	
	List<Publicar> findByTituloContainingIgnoreCase(String texto);

}