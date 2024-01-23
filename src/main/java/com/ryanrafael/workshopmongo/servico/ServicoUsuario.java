package com.ryanrafael.workshopmongo.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryanrafael.workshopmongo.dominio.Usuario;
import com.ryanrafael.workshopmongo.repositorio.RepositorioUsuario;

@Service
public class ServicoUsuario {
	
	@Autowired
	private RepositorioUsuario repo;
	
	public List<Usuario> encontraTudo(){
		return repo.findAll();
	}
}