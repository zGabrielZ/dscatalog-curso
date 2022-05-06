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
import com.devsuperior.dscatalog.modelo.dto.ProdutoDTO;
import com.devsuperior.dscatalog.service.ProdutoService;

@RestController // Implementa o controlador REST
@RequestMapping("/produtos") // Mapeamento da requisição, rota
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<Page<ProdutoDTO>> mostrarProdutos(
			@RequestParam(value = "pagina",required = false,defaultValue = "0") Integer pagina,
			@RequestParam(value = "quantidadePagina",required = false,defaultValue = "12") Integer quantidadePagina,
			@RequestParam(value = "direcao",required = false,defaultValue = "ASC") String direcao,
			@RequestParam(value = "ordernarPor",required = false,defaultValue = "nome") String ordernarPor){
		
		PageRequest pageRequest = PageRequest.of(pagina,quantidadePagina,Direction.valueOf(direcao),ordernarPor);
		
		Page<ProdutoDTO> produtosDtos = produtoService.findAllPaginado(pageRequest);
		return ResponseEntity.ok().body(produtosDtos); // .ok () Status 200
	}
	
	@GetMapping("/{idProduto}")
	public ResponseEntity<ProdutoDTO> mostrarProdutoPorId(@PathVariable Long idProduto){
		ProdutoDTO produtoDTO = produtoService.findById(idProduto);
		return ResponseEntity.ok().body(produtoDTO); // .ok () Status 200
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDTO> inserirProduto(@RequestBody ProdutoDTO produtoDTO){
		produtoDTO = produtoService.inserirProduto(produtoDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(produtoDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(produtoDTO); // .created () Status 201
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProdutoDTO> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO){
		produtoDTO = produtoService.atualizarProduto(id,produtoDTO);
		return ResponseEntity.ok().body(produtoDTO); // .ok () Status 200
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarProduto(@PathVariable Long id){
		produtoService.deletarProduto(id);
		return ResponseEntity.noContent().build(); // .noContent () Status 204
	}
}
