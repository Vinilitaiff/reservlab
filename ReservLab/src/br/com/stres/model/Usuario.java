package br.com.stres.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
/*	
    @Id
	@GeneratedValue
	*/
	
   /* @Id
	@Column(name="codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
	@SequenceGenerator(sequenceName = "PROX_USUARIO", allocationSize = 1, name = "USER_SEQ")*/
	@Id
	@GeneratedValue
	private int id;	
	
	@Column(name="nome")
	@NotNull
	private String nome;
	
	@Column(name="email")
	@NotNull
	private String email;
	
	@Column(name="age")
	private int age;
	
	@Column(name="senha")
	@NotNull
	private String senha;
	
	public Usuario() {
	}
			
	public Usuario(int codigo, String name, String senha, String email,int age){
		this.id = codigo;
		this.nome = name;
		this.senha = senha;
		this.email = email;
		this.age = age;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String name) {
		this.nome = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}  
