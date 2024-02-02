package com.ryanrafael.workshopmongo.servico;

import java.util.Date;
import java.util.List;
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

	public Publicar buscarPorId(String id) {
		Optional<Publicar> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjetoNaoEncontradoExcecao("Objeto não encontrado"));
	}
	
	public List<Publicar> buscarPorTitulo(String texto){
		return repo.pesquisarTitulo(texto);
	}
	
	public List<Publicar> pesquisarTudo(String texto, Date minData, Date maxData){
		maxData = new Date(maxData.getTime() + 24 * 60 * 60 * 1000);
		return repo.pesquisarTudo(texto, minData, maxData);
	}
}