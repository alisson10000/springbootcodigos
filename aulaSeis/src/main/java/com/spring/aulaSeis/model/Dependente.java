package com.spring.aulaSeis.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "dependentes")
public class Dependente implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	@Column(name = "nome", nullable = false)
	private String nome;
	@Column(name = "rg", unique = true, nullable = false)
	private String rg;
	// A anotação @ManyToOne(fetch = FetchType.LAZY)
	// indica que os dados do Funcionario serão carregados somente quando necessários (lazy loading)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "funcionario_id", referencedColumnName = "id")
	private Funcionario funcionario;

}
