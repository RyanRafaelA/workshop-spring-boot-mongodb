package com.ryanrafael.workshopmongo.recursos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ryanrafael.workshopmongo.dominio.Publicar;
import com.ryanrafael.workshopmongo.servico.ServicoPublicar;

@RestController
@RequestMapping(value = "/publicacoes")
public class RecursosPublicar {
	
	@Autowired
	private ServicoPublicar servico;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Publicar> buscaPorId(@PathVariable String id){
		Publicar obj = servico.encontradoPorId(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
