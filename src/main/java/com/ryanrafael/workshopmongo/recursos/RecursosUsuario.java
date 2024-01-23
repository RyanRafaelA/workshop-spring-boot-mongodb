package com.ryanrafael.workshopmongo.recursos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ryanrafael.workshopmongo.dominio.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursosUsuario {
	
	@GetMapping
	public ResponseEntity<List<Usuario>> buscaTodos(){
		Usuario maria = new Usuario("1", "Maria Silva", "maria@gmail.com");
		Usuario alex = new Usuario("2", "Alex Green", "Alex@gmail.com");
		
		List<Usuario> lista = new ArrayList<>();
		lista.addAll(Arrays.asList(maria, alex));
		
		return ResponseEntity.ok().body(lista);
	}
}
