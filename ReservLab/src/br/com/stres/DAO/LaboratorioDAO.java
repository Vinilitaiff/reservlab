package br.com.stres.DAO;

import java.util.List;

import br.com.stres.model.Laboratorio;

public interface LaboratorioDAO {
	
	public List<Laboratorio> listar() throws Exception;
	
	public List<Laboratorio> listarLike(String vdesc) throws Exception;
	
	public Laboratorio getBean(int id) throws Exception;
	
	public int inserir (Laboratorio laboratorio) throws Exception;
	
	public int alterar (Laboratorio laboratorio) throws Exception;
	 
	public int remover (Laboratorio laboratorio) throws Exception;
	
} 