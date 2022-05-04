package com.devsuperior.dscatalog.modelo.dto;

import java.io.Serializable;
import java.util.Objects;

import com.devsuperior.dscatalog.modelo.Categoria;

public class CategoriaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	
	public CategoriaDTO() {}
	
	public CategoriaDTO(Categoria categoria) {
		id = categoria.getId();
		nome = categoria.getNome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoriaDTO other = (CategoriaDTO) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "CategoriaDTO [id=" + id + ", nome=" + nome + "]";
	}
	
	

}
