package br.com.stres.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;


@Entity
@Table(name="laboratorio")
public class Laboratorio implements Serializable{
	private static final long serialVersionUID = -258794535381188269L;

/*	
 
@Id
@GeneratedValue
	 */
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROX_SEQ")
	@SequenceGenerator(sequenceName = "PROX_PRODUTO", allocationSize = 1, name = "PROX_SEQ")*/
	@Id
	@GeneratedValue
	private int id;	
	
	@NotNull
    private String bloco;
	
	@NotNull
    private String title;	
	
	@NotNull
    private String sala;
	
	@NotNull
    private String descricao;	
	
	@NotNull
    private int qtdLugares;
	

	public int getId() {
		return id;
	}

	public Laboratorio setId(int id) {
		this.id = id;
		return this;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		Laboratorio other = (Laboratorio) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getQtdLugares() {
		return qtdLugares;
	}

	public void setQtdLugares(int qtdLugares) {
		this.qtdLugares = qtdLugares;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
