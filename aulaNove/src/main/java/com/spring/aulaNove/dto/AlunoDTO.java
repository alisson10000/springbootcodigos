package com.spring.aulaNove.dto;

public class AlunoDTO {

    private Long id;
    private String nome;

    // Construtor padrão sem argumentos
    public AlunoDTO() {
    }

    // Construtor com todos os argumentos
    public AlunoDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters e setters
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
