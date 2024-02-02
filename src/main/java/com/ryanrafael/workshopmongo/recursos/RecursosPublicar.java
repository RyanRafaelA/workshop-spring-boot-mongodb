package com.ryanrafael.workshopmongo.recursos;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ryanrafael.workshopmongo.dominio.Publicar;
import com.ryanrafael.workshopmongo.recursos.util.URL;
import com.ryanrafael.workshopmongo.servico.ServicoPublicar;

@RestController
@RequestMapping(value = "/publicacoes")
public class RecursosPublicar {
	
	@Autowired
	private ServicoPublicar servico;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Publicar> buscaPorId(@PathVariable String id){
		Publicar obj = servico.buscarPorId(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value="/pesquisarTitulo")
	public ResponseEntity<List<Publicar>> buscarPorTitulo(@RequestParam(value="texto", defaultValue="") String texto){
		texto = URL.paramentroDecodificacao(texto);
		List<Publicar> lista = servico.buscarPorTitulo(texto);

		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value="/pesquisarTudo")
	public ResponseEntity<List<Publicar>> pesquiesarTudo(
			@RequestParam(value="texto", defaultValue="") String texto,
			@RequestParam(value="minData", defaultValue="") String minData,
			@RequestParam(value="maxData", defaultValue="") String maxData){
		texto = URL.paramentroDecodificacao(texto);
		Date min = URL.converterData(minData, new Date(0L));
		Date max = URL.converterData(maxData, new Date());
		
		List<Publicar> lista = servico.pesquisarTudo(texto, min, max);

		return ResponseEntity.ok().body(lista);
	}
}
