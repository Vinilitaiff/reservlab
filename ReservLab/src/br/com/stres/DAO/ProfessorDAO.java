package br.com.stres.DAO;

import java.util.List;

import br.com.stres.model.Professor;

public interface ProfessorDAO {
	
	public List<Professor> listar() throws Exception; 
	
	public List<Professor> listarCbx() throws Exception; // para preenchimento de combobox
	
	public List<Professor> listarStatus(int ativo) throws Exception;
	
	public Professor getBean(int id) throws Exception;
	
	public Professor getBean(String email) throws Exception;
	
	public int inserir (Professor professor) throws Exception;
	
	public int alterar (Professor professor) throws Exception;
	
	public int remover (Professor professor) throws Exception;
	
}  