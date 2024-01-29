package com.ryanrafael.workshopmongo.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryanrafael.workshopmongo.dominio.Usuario;
import com.ryanrafael.workshopmongo.dto.UsuarioDTO;
import com.ryanrafael.workshopmongo.repositorio.RepositorioUsuario;
import com.ryanrafael.workshopmongo.servico.excecao.ObjetoNaoEncontradoExcecao;

@Service
public class ServicoUsuario {
	
	@Autowired
	private RepositorioUsuario repo;
	
	public List<Usuario> encontraTudo(){
		return repo.findAll();
	}
	
	public Usuario encontradoPorId(String id) {
		Optional<Usuario> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoExcecao("Objeto não encontrado"));
	}
	
	public Usuario inserir(Usuario obj) {
		return repo.insert(obj);
	}
	
	public void deletar(String id) {
		encontradoPorId(id);
		
		repo.deleteById(id);
	}
	
	public Usuario paraDTO(UsuarioDTO objDto) {
		return new Usuario(objDto.getId(), objDto.getNome(), objDto.getEmail());
	}
}