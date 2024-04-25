package com.spring.aulacinco.model;


import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Enderecos {

	@Column(name = "rua")
	private String rua;
	

	@Column(name = "numero")
	private String numero;
	

	@Column(name = "bairro")
	private String bairro;
	

	@Column(name = "cidade")
	private String cidade;
	

	@Column(name = "estado")
	private String estado;
	
	
	

	@Column(name = "cep" , columnDefinition = "INTEGER")
	private Integer cep;
	
	
	
}
