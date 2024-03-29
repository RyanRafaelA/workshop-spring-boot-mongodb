package com.ryanrafael.workshopmongo.recursos.excecao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ryanrafael.workshopmongo.servico.excecao.ObjetoNaoEncontradoExcecao;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class IndentificadorExcecaoRecursos {
	
	@ExceptionHandler(ObjetoNaoEncontradoExcecao.class)
	public ResponseEntity<ErroPadrao> objetoNaoEncontrado(ObjetoNaoEncontradoExcecao e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		ErroPadrao erro = new ErroPadrao(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(erro);
	}
}
