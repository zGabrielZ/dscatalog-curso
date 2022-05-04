package com.devsuperior.dscatalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dscatalog.modelo.Categoria;
import com.devsuperior.dscatalog.repositorio.CategoriaRepositorio;

@Service
public class CategoriaService {

	@Autowired
	public CategoriaRepositorio categoriaRepositorio;
	
	public List<Categoria> findAll(){
		return categoriaRepositorio.findAll();
	}
}
