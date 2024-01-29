package com.ryanrafael.workshopmongo.recursos;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ryanrafael.workshopmongo.dominio.Usuario;
import com.ryanrafael.workshopmongo.dto.UsuarioDTO;
import com.ryanrafael.workshopmongo.servico.ServicoUsuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursosUsuario {
	
	@Autowired
	private ServicoUsuario servico;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> buscaTodos(){
		List<Usuario> lista = servico.encontraTudo();
		
		List<UsuarioDTO> listaDto = lista.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listaDto);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UsuarioDTO> buscaPorId(@PathVariable String id){
		Usuario obj = servico.encontradoPorId(id);
		
		return ResponseEntity.ok().body(new UsuarioDTO(obj));
	}
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody UsuarioDTO objDto){
		Usuario obj = servico.paraDTO(objDto);
		obj = servico.inserir(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
