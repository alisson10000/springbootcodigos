package com.spring.aulaOito.dto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsuarioDTO {
	private Long id;
	@NotBlank(message = "O nome do usuário é obrigatório")
	@Size(min = 3, max = 50, message = "O nome do usuário deve ter entre 3 e 50 caracteres")
	private String nome;

	// Construtor padrão sem argumentos
	public UsuarioDTO() {
	}

	public UsuarioDTO(Long id,
			@NotBlank(message = "O nome do usuário é obrigatório") @Size(min = 3, max = 50, message = "O nome do usuário deve ter entre 3 e 50 caracteres") String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// Construtores, getters e setters
}