package com.spring.aulaSete.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "enderecos")
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEndereco")
	private Long id;

	@NotNull
	@Size(min = 3, max = 100)
	@Column(name = "ruaEndereco")
	private String rua;

	@NotNull
	@Size(min = 1, max = 10)
	@Column(name = "numeroCasaEndereco")
	private String numeroCasa;

	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "bairroEndereco")
	private String bairro;

	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "cidadeEndereco")
	private String cidade;

	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "estadoEndereco")
	private String estado;

	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "paisEndereco")
	private String pais;

	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "cepEndereco")
	private String cep;
	
	
	

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	
}
