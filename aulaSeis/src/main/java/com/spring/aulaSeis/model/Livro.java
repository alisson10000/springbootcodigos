package com.spring.aulaSeis.model;
import javax.persistence.*;
import java.io.Serializable;
@Entity
@SequenceGenerator(name = "seq_livro", sequenceName = "seq_livro", allocationSize = 1, initialValue = 1)
@Table(name = "livros")
public class Livro implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_livro")
	@Column(name = "id_livro")
	private Long idLivro;
	@Column(name = "titulo_livro", nullable = false)
	private String tituloLivro;
	@Column(name = "autor_livro", nullable = false)
	private String autorLivro;
	@Transient
	private String isbnLivro; // Adicionado @Transient para ignorar isbnLivro durante a persistência
	@Column(name = "cpf_autor", unique = true, nullable = false)
	private String cpfAutor;
}
