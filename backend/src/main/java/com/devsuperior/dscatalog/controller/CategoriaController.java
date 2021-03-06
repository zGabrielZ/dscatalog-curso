package com.devsuperior.dscatalog.controller;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.dscatalog.modelo.dto.CategoriaDTO;
import com.devsuperior.dscatalog.service.CategoriaService;

@RestController // Implementa o controlador REST
@RequestMapping("/categorias") // Mapeamento da requisição, rota
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public ResponseEntity<Page<CategoriaDTO>> mostrarCategorias(
			@RequestParam(value = "pagina",required = false,defaultValue = "0") Integer pagina,
			@RequestParam(value = "quantidadePagina",required = false,defaultValue = "12") Integer quantidadePagina,
			@RequestParam(value = "direcao",required = false,defaultValue = "ASC") String direcao,
			@RequestParam(value = "ordernarPor",required = false,defaultValue = "nome") String ordernarPor){
		
		PageRequest pageRequest = PageRequest.of(pagina,quantidadePagina,Direction.valueOf(direcao),ordernarPor);
		
		Page<CategoriaDTO> categorias = categoriaService.findAllPaginado(pageRequest);
		return ResponseEntity.ok().body(categorias); // .ok () Status 200
	}
	
	@GetMapping("/{idCategoria}")
	public ResponseEntity<CategoriaDTO> mostrarCategoriaPorId(@PathVariable Long idCategoria){
		CategoriaDTO categoriaDTO = categoriaService.findById(idCategoria);
		return ResponseEntity.ok().body(categoriaDTO); // .ok () Status 200
	}
	
	@PostMapping
	public ResponseEntity<CategoriaDTO> inserirCategoria(@RequestBody CategoriaDTO categoriaDTO){
		categoriaDTO = categoriaService.inserirCategoria(categoriaDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(categoriaDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(categoriaDTO); // .created () Status 201
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoriaDTO> atualizarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO){
		categoriaDTO = categoriaService.atualizarCategoria(id,categoriaDTO);
		return ResponseEntity.ok().body(categoriaDTO); // .ok () Status 200
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarCategoria(@PathVariable Long id){
		categoriaService.deletarCategoria(id);
		return ResponseEntity.noContent().build(); // .noContent () Status 204
	}
}
