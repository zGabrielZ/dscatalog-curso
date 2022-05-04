package com.devsuperior.dscatalog.exception.modelo;

import java.io.Serializable;
import java.time.Instant;

public class ErroPadrao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Instant data;
	private Integer status;
	private String erro;
	private String mensagem;
	private String caminho;
	
	public ErroPadrao() {}
	
	public ErroPadrao(Instant data, Integer status, String erro, String mensagem, String caminho) {
		this.data = data;
		this.status = status;
		this.erro = erro;
		this.mensagem = mensagem;
		this.caminho = caminho;
	}

	public Instant getData() {
		return data;
	}

	public void setData(Instant data) {
		this.data = data;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
	

}
