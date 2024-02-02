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

	public List<Usuario> buscarTudo() {
		return repo.findAll();
	}

	public Usuario buscarPorId(String id) {
		Optional<Usuario> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjetoNaoEncontradoExcecao("Objeto não encontrado"));
	}

	public Usuario inserir(Usuario obj) {
		return repo.insert(obj);
	}

	public Usuario atualizar(Usuario obj) {
		Optional<Usuario> optUsuario = repo.findById(obj.getId());

		if (optUsuario.isPresent()) {
			Usuario newObj = optUsuario.get();
			atualizarDados(newObj, obj);

			return repo.save(newObj);
		} else {
			return null;
		}
	}

	private void atualizarDados(Usuario newObj, Usuario obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}

	public void deletar(String id) {
		buscarPorId(id);

		repo.deleteById(id);
	}

	public Usuario paraDTO(UsuarioDTO objDto) {
		return new Usuario(objDto.getId(), objDto.getNome(), objDto.getEmail());
	}
}