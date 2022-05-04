package com.devsuperior.dscatalog.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devsuperior.dscatalog.modelo.dto.CategoriaDTO;
import com.devsuperior.dscatalog.service.CategoriaService;

@RestController // Implementa o controlador REST
@RequestMapping("/categorias") // Mapeamento da requisição, rota
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> mostrarCategorias(){
		List<CategoriaDTO> categorias = categoriaService.findAll();
		return ResponseEntity.ok().body(categorias); // .ok () Status 200
	}
	
	@GetMapping("/{idCategoria}")
	public ResponseEntity<CategoriaDTO> mostrarCategoriaPorId(@PathVariable Long idCategoria){
		CategoriaDTO categoriaDTO = categoriaService.findById(idCategoria);
		return ResponseEntity.ok().body(categoriaDTO); // .ok () Status 200
	}
}
