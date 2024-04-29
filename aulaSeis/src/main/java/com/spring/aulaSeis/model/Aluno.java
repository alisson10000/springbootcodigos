package com.spring.aulaSeis.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "alunos") // Define o nome da tabela no banco de dados
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L; // Configura a estratégia de geração de
	@Id // Anota o campo como chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Configura a estratégia de geração de IDs
	private Long id;

	@Basic // Anota o campo como básico
	@Column(name = "nome") // Especifica o nome da coluna no banco de dados
	private String nome;

	// Relação Many-to-Many com a entidade Curso
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "alunos_cursos", joinColumns = @JoinColumn(name = "aluno_id"), inverseJoinColumns = {
			@JoinColumn(name = "curso_id") })
	private List<Curso> cursos;

	// Construtor padrão, getters e setters
//...
}
