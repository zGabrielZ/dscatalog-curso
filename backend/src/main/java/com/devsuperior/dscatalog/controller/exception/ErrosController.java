package com.devsuperior.dscatalog.controller.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.dscatalog.exception.EntidadeNaoEncontradaException;
import com.devsuperior.dscatalog.exception.modelo.ErroPadrao;

@ControllerAdvice
public class ErrosController {

	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<ErroPadrao> entidadeNaoEncontradaException(EntidadeNaoEncontradaException e, HttpServletRequest httpServletRequest){
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao erroPadrao = new ErroPadrao(Instant.now(),status.value(),"Controlador não encontrado", e.getMessage(), httpServletRequest.getRequestURI());
		return ResponseEntity.status(status).body(erroPadrao);
	}
}
