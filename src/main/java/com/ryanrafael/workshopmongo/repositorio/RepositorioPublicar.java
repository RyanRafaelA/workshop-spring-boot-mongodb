package com.ryanrafael.workshopmongo.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ryanrafael.workshopmongo.dominio.Publicar;

@Repository
public interface RepositorioPublicar extends MongoRepository<Publicar, String>{
	
	@Query("{ 'titulo': { $regex: ?0, $options: 'i' } }")
	List<Publicar> pesquisarTitulo(String texto);
	
	List<Publicar> findByTituloContainingIgnoreCase(String texto);
	
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} }, { $or: [ { 'titulo': { $regex: ?0, $options: 'i' } }, { 'corpo': { $regex: ?0, $options: 'i' } }, { 'comentario.texto': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Publicar> pesquisarTudo(String texto, Date minData, Date maxData);

}