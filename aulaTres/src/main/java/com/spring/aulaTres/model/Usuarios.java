package com.spring.aulaTres.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_usuario",sequenceName="seq_usuario", allocationSize = 1 , initialValue=1)
public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
	private Long idUsuario;
	private String nomeUsuario;
	private Date idadeUsuario;
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public Date getIdadeUsuario() {
		return idadeUsuario;
	}
	public void setIdadeUsuario(Date idadeUsuario) {
		this.idadeUsuario = idadeUsuario;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}