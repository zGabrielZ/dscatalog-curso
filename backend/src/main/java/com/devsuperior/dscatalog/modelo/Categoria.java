package com.devsuperior.dscatalog.modelo;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIA")
public class Categoria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome",nullable = false)
	private String nome;
	
	@Column(name = "criado", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant criado;
	
	@Column(name = "atualizado", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant atualizado;

	public Categoria() {}

	public Categoria(Long id, String nome) {
		this.id = id;
		this.nome = nome;
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
	
	public Instant getCriado() {
		return criado;
	}

	public Instant getAtualizado() {
		return atualizado;
	}
	
	@PrePersist // Quando chamar o save, ele vai ir nesse método
	public void preInsercao() {
		criado = Instant.now();
	}
	
	@PreUpdate // Quando chamar o save mas pra atualizar, ele vai ir nesse método
	public void preAtualizar() {
		atualizado = Instant.now();
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
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + ", criado=" + criado + ", atualizado=" + atualizado + "]";
	}
	
	
}
