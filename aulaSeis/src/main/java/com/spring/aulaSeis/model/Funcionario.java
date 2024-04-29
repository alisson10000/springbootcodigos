package com.spring.aulaSeis.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.*;

@Entity
@Table(name = "funcionarios")
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	@Column(name = "nome", nullable = false)
	private String nome;
	@Column(name = "cpf", unique = true, nullable = false)
	private String cpf;
	@OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)

	private List<Dependente> dependentes;
	// Outros campos, construtores, métodos, etc.
}
