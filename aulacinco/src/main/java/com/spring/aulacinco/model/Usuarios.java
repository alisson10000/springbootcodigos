package com.spring.aulacinco.model;



import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "usuarios")
public class Usuarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	
	@Column(name = "email", unique = true)
	@Email
	@NotBlank
	private String email;
	
	@Column(name = "senha")
	private String senha;
	
	
	
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "rua" , column = @Column(name = "rua")),
		@AttributeOverride(name = "numero" , column = @Column(name = "numero")),
		@AttributeOverride(name = "bairro" , column = @Column(name = "bairro")),
		@AttributeOverride(name = "cidade" , column = @Column(name = "cidade")),
		@AttributeOverride(name = "estado" , column = @Column(name = "estado")),
		@AttributeOverride(name = "cep" , column = @Column(name = "cep")),
	})
	private Enderecos endereco;
	
	
	
	
	
	

}
