package com.spring.aulaNove.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@Table(name="alunos")
@NamedQuery(
	    name = "Aluno.findByNome",
	    query = "SELECT a FROM Aluno a WHERE a.nome LIKE CONCAT('%',:nome, '%')"
	)
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAluno")
	private Long id;
	
	
	@Column(name = "nomeAluno")
	private String nome;

	
	public Aluno() {
		// TODO Auto-generated constructor stub
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
	
	
	
	
}
