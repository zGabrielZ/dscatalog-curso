package com.devsuperior.dscatalog.modelo;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "descricao", nullable = false, columnDefinition = "TEXT")
	private String descricao;
	
	@Column(name = "preco", nullable = false)
	private Double preco;
	
	@Column(name = "imagem_url")
	private String imagemUrl;
	
	@Column(name = "data", nullable = false,columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant data;
	
	@ManyToMany
	@JoinTable(
			name = "PRODUTO_CATEGORIA", joinColumns = @JoinColumn(name="produto_id"),
			inverseJoinColumns = @JoinColumn(name="categoria_id")
	)
	private Set<Categoria> categorias = new HashSet<>();
	
	@Column(name = "criado", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant criado;
	
	@Column(name = "atualizado", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant atualizado;
	
	public Produto() {}

	public Produto(Long id, String nome, String descricao, Double preco, String imagemUrl, Instant data, Instant criado,
			Instant atualizado) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.imagemUrl = imagemUrl;
		this.data = data;
		this.criado = criado;
		this.atualizado = atualizado;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getImagemUrl() {
		return imagemUrl;
	}

	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}

	public Instant getData() {
		return data;
	}

	public void setData(Instant data) {
		this.data = data;
	}

	public Instant getCriado() {
		return criado;
	}

	public void setCriado(Instant criado) {
		this.criado = criado;
	}

	public Instant getAtualizado() {
		return atualizado;
	}

	public void setAtualizado(Instant atualizado) {
		this.atualizado = atualizado;
	}

	public Set<Categoria> getCategorias() {
		return categorias;
	}
	
	@PrePersist
	public void preInsercao() {
		criado = Instant.now();
	}
	
	@PreUpdate
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
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", imagemUrl="
				+ imagemUrl + ", data=" + data + ", criado=" + criado + ", atualizado=" + atualizado + "]";
	}
	
	
	
	

}
