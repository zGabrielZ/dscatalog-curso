package com.devsuperior.dscatalog.modelo.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.devsuperior.dscatalog.modelo.Categoria;
import com.devsuperior.dscatalog.modelo.Produto;

public class ProdutoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String descricao;
	private Double preco;
	private String imagemUrl;
	private Instant data;
	private List<CategoriaDTO> categoriaDTOs = new ArrayList<CategoriaDTO>();
	
	public ProdutoDTO() {}
	
	public ProdutoDTO(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.preco = produto.getPreco();
		this.imagemUrl = produto.getImagemUrl();
		this.data = produto.getData(); 
	}
	
	public ProdutoDTO(Produto produto, Set<Categoria> categorias) {
		this(produto); // Vai chama o construtor que so chama o 'produto'
		for(Categoria categoria : categorias) {
			this.categoriaDTOs.add(new CategoriaDTO(categoria));
		}
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
	
	public List<CategoriaDTO> getCategoriaDTOs() {
		return categoriaDTOs;
	}

	public void setCategoriaDTOs(List<CategoriaDTO> categoriaDTOs) {
		this.categoriaDTOs = categoriaDTOs;
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
		ProdutoDTO other = (ProdutoDTO) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "ProdutoDTO [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco
				+ ", imagemUrl=" + imagemUrl + ", data=" + data + ", categoriaDTOs=" + categoriaDTOs + "]";
	}
	
	
	
	

}
