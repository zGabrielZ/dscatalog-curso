package com.devsuperior.dscatalog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dscatalog.modelo.Categoria;

@RestController // Implementa o controlador REST
@RequestMapping("/categorias") // Mapeamento da requisição, rota
public class CategoriaController {

	@GetMapping
	public ResponseEntity<List<Categoria>> mostrarCategorias(){
		return ResponseEntity.ok().body(getCategorias()); // .ok () Status 200
	}
	
	private List<Categoria> getCategorias(){
		List<Categoria> categorias = new ArrayList<>();
		categorias.add(new Categoria(1L, "Livros"));
		categorias.add(new Categoria(2L, "Eletrônicos."));
		return categorias;
	}
}
