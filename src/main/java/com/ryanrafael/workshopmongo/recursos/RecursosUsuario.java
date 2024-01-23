package com.ryanrafael.workshopmongo.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ryanrafael.workshopmongo.dominio.Usuario;
import com.ryanrafael.workshopmongo.servico.ServicoUsuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursosUsuario {
	
	@Autowired
	private ServicoUsuario servico;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> buscaTodos(){
		List<Usuario> lista = servico.encontraTudo();
		
		return ResponseEntity.ok().body(lista);
	}
}
