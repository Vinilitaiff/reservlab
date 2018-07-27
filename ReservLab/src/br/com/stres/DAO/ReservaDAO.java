package br.com.stres.DAO;

import java.util.List;

import br.com.stres.model.Reserva;

public interface ReservaDAO {
	
	public List<Reserva> listar() throws Exception;
	
	public List<Reserva> listar(String dtini, String dtfim) throws Exception;
	
	public Reserva getBean(int id) throws Exception;	
	
	public int insert(Reserva reserva) throws Exception;
	
	public int alterar(Reserva reserva) throws Exception;
	
	public int remover(Reserva reserva) throws Exception;

}
