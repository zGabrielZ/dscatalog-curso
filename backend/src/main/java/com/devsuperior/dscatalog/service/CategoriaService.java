package com.devsuperior.dscatalog.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dscatalog.modelo.Categoria;
import com.devsuperior.dscatalog.modelo.dto.CategoriaDTO;
import com.devsuperior.dscatalog.repositorio.CategoriaRepositorio;

@Service
public class CategoriaService {

	@Autowired
	public CategoriaRepositorio categoriaRepositorio;
	
	public List<CategoriaDTO> findAll(){
		List<Categoria> categorias = categoriaRepositorio.findAll();
		List<CategoriaDTO> categoriaDTOs = categorias.stream().map(c -> new CategoriaDTO(c)).collect(Collectors.toList());
		return categoriaDTOs;
	}
}
