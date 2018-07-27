package br.com.stres.model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;


@Entity
@NamedQuery(name="Professor.listarCbx",query="SELECT u.id, u.nome FROM Professor u WHERE u.ativo=1 ORDER BY u.nome")
@Table(name="professor")
public class Professor implements Serializable{
	private static final long serialVersionUID = -258794535381188269L;
		
/*	@Id
	@GeneratedValue */
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTE_SEQ")
	@SequenceGenerator(sequenceName = "PROX_CLIENTE", allocationSize = 1, name = "CLIENTE_SEQ")*/
	@Id
	@GeneratedValue
	private int id;	
	
	@NotNull
    private String nome;
	
    private String senha;
	
	@Embedded
	private Endereco endereco;
	
	@NotNull
    private int ativo;
	
	@NotNull
    private String email;
	
    private String celular;
	
	@NotNull
    private String cpf;	
	
	public Professor() {
		
	}
	
	public Professor(int id, String nome, Endereco endereco, int ativo, String email, String celular, String cpf) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.ativo = ativo;
		this.email = email;
		this.celular = celular;
		this.cpf = cpf;
	}


	public String getNome() {
		return nome;
	}

	public Professor setNome(String nome) {
		this.nome = nome;
		
		return this;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

	public int getId() {
		return id;
	}

	public Professor setId(int id) {
		this.id = id;
		
		return this;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
/*
	public AtivoType getAtivo() {
		return ativo;
	}

	public void setAtivo(AtivoType ativo) {
		this.ativo = ativo;
	}
*/
	

}
