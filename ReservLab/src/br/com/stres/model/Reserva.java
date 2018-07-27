package br.com.stres.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.internal.NotNull;


@Entity
@Table(name="reserva")
public class Reserva implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/*
	@Id
	@GeneratedValue
	*/
    
	/*@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITENS_SEQ")
	@SequenceGenerator(sequenceName = "PROX_VENDA_ITEM", allocationSize = 1, name = "ITENS_SEQ")*/
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne(cascade = CascadeType.PERSIST, optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_professor", referencedColumnName = "id")
	private Professor professor;
	
	@OneToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_laboratorio", referencedColumnName = "id", nullable = true)
	private Laboratorio laboratorio;
	
	@NotNull
	private int resourceId;	
	
	@NotNull
    private String title;
	
	@Column(name="dataIni")
	private String start;
	  	
	@Column(name="dataFim")
	private String end;
	
	@NotNull
    private String disciplina;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
			Reserva other = (Reserva) obj;
			if (id != other.id)
				return false;
			return true;
		}

		public Professor getProfessor() {
			return professor;
		}

		public void setProfessor(Professor professor) {
			this.professor = professor;
		}
	

		public String getDisciplina() {
			return disciplina;
		}

		public void setDisciplina(String disciplina) {
			this.disciplina = disciplina;
		}

		
		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getStart() {
			return start;
		}

		public void setStart(String start) {
			this.start = start;
		}

		public String getEnd() {
			return end;
		}

		public void setEnd(String end) {
			this.end = end;
		}

		public int getResourceId() {
			return resourceId;
		}

		public void setResourceId(int resourceId) {
			this.resourceId = resourceId;
		}

		public Laboratorio getLaboratorio() {
			return laboratorio;
		}

		public void setLaboratorio(Laboratorio laboratorio) {
			this.laboratorio = laboratorio;
		}

	

		
   
   
   
   
   
	
}
