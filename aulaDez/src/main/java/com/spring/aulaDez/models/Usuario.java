package com.spring.aulaDez.models;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
@Entity
@Table(name = "usuario")
@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1, initialValue = 1)
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
	@Column(name = "id")
	private Long id;

	@Column(name = "login")
	private String login;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Column(name = "senha")
	private String senha;

	@Column(name = "nome")
	private String nome;

	@Column(name = "idade")
	private Date idade;

	public Usuario() {
	}

	public Usuario(Long id, String login, String senha, String nome, Date idade, List<Role> roles) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.idade = idade;
		this.roles = roles;
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

	public Date getIdade() {
		return idade;
	}

	public void setIdade(Date idade) {
		this.idade = idade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/* Relacionamento de um para muitos */
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuarios_role", uniqueConstraints = @UniqueConstraint(columnNames = { "usuario_id",
			"role_id" }, name = "unique_nome_user"), 
	joinColumns = @JoinColumn(name = "usuario_id", 
	referencedColumnName = "id", table = "usuario", unique = false,
	foreignKey = @ForeignKey(name = "usuario_fk", value = ConstraintMode.CONSTRAINT)),
	inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id",
	table = "role", unique = false, updatable = false,
	foreignKey = @ForeignKey(name = "role_fk", value = ConstraintMode.CONSTRAINT)))
	private List<Role> roles;/* papeis ou acessos */

	/* As autorizações são os acessos aos usuarios ROLE_ADIM ou ROLE_VISITANTE */

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return roles;/* Aqui são os papeis de acesso */
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.nome;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}