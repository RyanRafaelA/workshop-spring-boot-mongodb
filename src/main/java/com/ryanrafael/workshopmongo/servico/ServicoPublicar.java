package com.ryanrafael.workshopmongo.servico;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryanrafael.workshopmongo.dominio.Publicar;
import com.ryanrafael.workshopmongo.repositorio.RepositorioPublicar;
import com.ryanrafael.workshopmongo.servico.excecao.ObjetoNaoEncontradoExcecao;

@Service
public class ServicoPublicar {

	@Autowired
	private RepositorioPublicar repo;

	public Publicar encontradoPorId(String id) {
		Optional<Publicar> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjetoNaoEncontradoExcecao("Objeto não encontrado"));
	}
}