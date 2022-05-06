package com.devsuperior.dscatalog.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.devsuperior.dscatalog.exception.EntidadeNaoEncontradaException;
import com.devsuperior.dscatalog.modelo.Categoria;
import com.devsuperior.dscatalog.modelo.Produto;
import com.devsuperior.dscatalog.modelo.dto.CategoriaDTO;
import com.devsuperior.dscatalog.modelo.dto.ProdutoDTO;
import com.devsuperior.dscatalog.repositorio.ProdutoRepositorio;

@Service
public class ProdutoService {

	@Autowired
	public ProdutoRepositorio produtoRepositorio;
	
//	@Transactional
//	public ProdutoDTO inserirProduto(ProdutoDTO produtoDTO) {
//		Produto produto = new Produto();
//		produto.setNome(produtoDTO.getNome());
//		produto.setDescricao(produtoDTO.getDescricao());
//		produto.setPreco(produtoDTO.getPreco());
//		produto.setImagemUrl(produtoDTO.getImagemUrl());
//		produto.setData(produtoDTO.getData());
//		
//		// Adicionando as listas de categorias Dtos para classe Catagoria
//		for(CategoriaDTO categoriaDTO : produtoDTO.getCategoriaDTOs()) {
//			Categoria categoria = new Categoria(categoriaDTO.getId(), categoriaDTO.getNome());
//			produto.getCategorias().add(categoria);
//		}
//		return new ProdutoDTO(produto, produto.getCategorias());
//	}
	
//	@Transactional
//	public ProdutoDTO atualizarProduto(Long id, ProdutoDTO categoriaDTO) {
//		try {
//			Produto categoria = categoriaRepositorio.getOne(id);
//			categoria.setNome(categoriaDTO.getNome());
//			categoria = categoriaRepositorio.save(categoria);
//			return new ProdutoDTO(categoria);
//		} catch (EntityNotFoundException e) {
//			throw new EntidadeNaoEncontradaException("Produto não encontrada.");
//		}
//	}
//	
	public void deletarProduto(Long id) {
		try {
			Produto produto = produtoRepositorio.getOne(id);
			produtoRepositorio.deleteById(produto.getId());
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException("Produto não encontrado.");
		}
	}
	
	public Page<ProdutoDTO> findAllPaginado(PageRequest pageRequest){
		Page<Produto> produtos = produtoRepositorio.findAll(pageRequest);
		Page<ProdutoDTO> produtosDtos = produtos.map(p -> new ProdutoDTO(p));
		return produtosDtos;
	}
	
	public ProdutoDTO findById(Long id) {
		Optional<Produto> optionalProduto = produtoRepositorio.findById(id);
		// Caso não encontrar o produto, vai lançar a exception de entidade não encontrada
		optionalProduto.orElseThrow(() -> new EntidadeNaoEncontradaException("Produto não encontrado."));
		ProdutoDTO produtoDTO = new ProdutoDTO(optionalProduto.get(), optionalProduto.get().getCategorias());
		return produtoDTO;
	}
}
