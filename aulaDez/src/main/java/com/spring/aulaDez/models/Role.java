package com.spring.aulaDez.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "role")
@SequenceGenerator(name = "seq_role",sequenceName="seq_role", allocationSize = 1 , initialValue=1)
public class Role implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_role")
	@Column(name = "id")
	private Long id;

	@Column(name = "nome")
	private String nome;/* Papel, exemplo ROLE_SECRETARIO ou ROLE_GERENTE */

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@Override
	public String getAuthority() {/* Retorna o nome no papel, acesso ou autorização exemplo ROLE_GERENTE */
		// TODO Auto-generated method stub
		return this.nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeRole() {
		return nome;
	}

	public void setNomeRole(String nome) {
		this.nome = nome;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
