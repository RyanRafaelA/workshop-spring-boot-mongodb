package com.ryanrafael.workshopmongo.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ryanrafael.workshopmongo.dto.AutorDTO;
import com.ryanrafael.workshopmongo.dto.ComentarioDTO;

@Document
public class Publicar implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private Date data;
	private String titulo;
	private String corpo;
	private AutorDTO autor;
	
	private List<ComentarioDTO> comentario = new ArrayList<>();
	
	public Publicar() {}
	public Publicar(String id, Date data, String titulo, String corpo, AutorDTO autor) {
		super();
		this.id = id;
		this.data = data;
		this.titulo = titulo;
		this.corpo = corpo;
		this.autor = autor;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCorpo() {
		return corpo;
	}
	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}
	public AutorDTO getAutor() {
		return autor;
	}
	public void setAutor(AutorDTO autor) {
		this.autor = autor;
	}
	public List<ComentarioDTO> getComentario() {
		return comentario;
	}
	public void setComentario(List<ComentarioDTO> comentario) {
		this.comentario = comentario;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publicar other = (Publicar) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
