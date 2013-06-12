package com.vortice.seguranca.vo;

import com.vortice.abstracao.ValueObject;

public class LinkVO extends ValueObject {
	
	public LinkVO(){}
	
	public LinkVO(Integer c){
		codigo = c;
	}
	
	public LinkVO(String url){
		this.url = url;
	}
	
	private Integer 		codigo;
	private String 		url;
	private String 		descricao;
	private Character tipo;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Character getTipo() {
		return tipo;
	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
