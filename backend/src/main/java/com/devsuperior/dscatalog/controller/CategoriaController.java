package com.devsuperior.dscatalog.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dscatalog.modelo.Categoria;
import com.devsuperior.dscatalog.service.CategoriaService;

@RestController // Implementa o controlador REST
@RequestMapping("/categorias") // Mapeamento da requisição, rota
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> mostrarCategorias(){
		List<Categoria> categorias = categoriaService.findAll();
		return ResponseEntity.ok().body(categorias); // .ok () Status 200
	}
}
