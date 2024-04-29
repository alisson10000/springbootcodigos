package com.spring.aulaSeis.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cursos")
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L; // Configura a estratégia de geração de
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) // Configura a estratégia de geração de IDs
private Long id;

    @Basic
@Column(name = "nome")
private String nome;

    // Relação Many-to-Many com a entidade Aluno
@ManyToMany(mappedBy = "cursos")
private List<Aluno> alunos;

    // Construtor padrão, getters e setters
//...
}
