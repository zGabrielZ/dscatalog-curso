package com.devsuperior.dscatalog.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscatalog.exception.DatabaseException;
import com.devsuperior.dscatalog.exception.EntidadeNaoEncontradaException;
import com.devsuperior.dscatalog.modelo.Categoria;
import com.devsuperior.dscatalog.modelo.dto.CategoriaDTO;
import com.devsuperior.dscatalog.repositorio.CategoriaRepositorio;

@Service
public class CategoriaService {

	@Autowired
	public CategoriaRepositorio categoriaRepositorio;
	
	@Transactional
	public CategoriaDTO inserirCategoria(CategoriaDTO categoriaDTO) {
		Categoria categoria = new Categoria();
		categoria.setNome(categoriaDTO.getNome());
		categoria = categoriaRepositorio.save(categoria);
		return new CategoriaDTO(categoria);
	}
	
	@Transactional
	public CategoriaDTO atualizarCategoria(Long id, CategoriaDTO categoriaDTO) {
		try {
			Categoria categoria = categoriaRepositorio.getOne(id);
			categoria.setNome(categoriaDTO.getNome());
			categoria = categoriaRepositorio.save(categoria);
			return new CategoriaDTO(categoria);
		} catch (EntityNotFoundException e) {
			throw new EntidadeNaoEncontradaException("Categoria não encontrada.");
		}
	}
	
	public void deletarCategoria(Long id) {
		try {
			Categoria categoria = categoriaRepositorio.getOne(id);
			categoriaRepositorio.deleteById(categoria.getId());
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException("Categoria não encontrada.");
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Categoria não pode ser deletada pois tem produtos relacionados.");
		}
	}
	
	public List<CategoriaDTO> findAll(){
		List<Categoria> categorias = categoriaRepositorio.findAll();
		List<CategoriaDTO> categoriaDTOs = categorias.stream().map(c -> new CategoriaDTO(c)).collect(Collectors.toList());
		return categoriaDTOs;
	}
	
	public CategoriaDTO findById(Long id) {
		Optional<Categoria> optionalCategoria = categoriaRepositorio.findById(id);
		// Caso não encontrar a categoria, vai lançar a exception de entidade não encontrada
		optionalCategoria.orElseThrow(() -> new EntidadeNaoEncontradaException("Categoria não encontrada."));
		CategoriaDTO categoriaDTO = new CategoriaDTO(optionalCategoria.get());
		return categoriaDTO;
	}
}
