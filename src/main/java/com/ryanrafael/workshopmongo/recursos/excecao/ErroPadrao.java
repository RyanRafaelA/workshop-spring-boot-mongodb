package com.ryanrafael.workshopmongo.recursos.excecao;

import java.io.Serializable;

public class ErroPadrao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long dataHora;
	private Integer status;
	private String erro;
	private String mensagem;
	private String caminho;
	
	public ErroPadrao() {}
	public ErroPadrao(Long dataHora, Integer status, String erro, String mensagem, String caminho) {
		super();
		this.dataHora = dataHora;
		this.status = status;
		this.erro = erro;
		this.mensagem = mensagem;
		this.caminho = caminho;
	}
	
	public Long getDataHora() {
		return dataHora;
	}
	public void setDataHora(Long dataHora) {
		this.dataHora = dataHora;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getErro() {
		return erro;
	}
	public void setErro(String erro) {
		this.erro = erro;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getCaminho() {
		return caminho;
	}
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

}
