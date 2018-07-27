package br.com.stres.DAO;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.stres.model.Endereco;
import br.com.stres.model.Laboratorio;
import br.com.stres.model.Professor;
import br.com.stres.model.Reserva;
import br.com.stres.util.GeradorSenha;
import br.com.stres.util.JPAUtility;


public class ReservaDAOImpl implements ReservaDAO {
	private DAO<Reserva> dao = new DAO<Reserva>(Reserva.class);
    static ReservaDAOImpl db;
	
	public static ReservaDAO getInstance(){
		if (db == null){
			db = new ReservaDAOImpl();
		}
		return db;
	}
	
	@Override
	public List<Reserva> listar() throws Exception {
		List<Reserva> lista = null;
		  try {			  
			  lista =dao.listarTodos(); 
		  }
		  catch (Exception e) {
				e.printStackTrace();
			}
		return lista;	
	}

	
	@Override
	public List<Reserva> listar(String dtini, String dtfim) throws Exception{
		List<Reserva> Reservas = null;
		EntityManager em = JPAUtility.getEntityManager();
		try {
			 TypedQuery<Reserva> query = 
					 em.createQuery("SELECT c FROM Venda c WHERE to_date(to_char(data,'dd/mm/yyyy'),'dd/mm/yyyy') " + 
					 		"BETWEEN to_date(?1,'dd/mm/yyyy') and to_date(?2,'dd/mm/yyyy')", Reserva.class);
			 query.setParameter(1, dtini);
			 Reservas = query.setParameter(2, dtfim).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		return Reservas;
	}

	@Override
	public Reserva getBean(int id) throws Exception{
		Reserva reserva = null;
		try {
			reserva = dao.getBean(id);			
		   } catch (Exception e) {
			 e.printStackTrace();
		 }
		return reserva;
	} 	

	
	@Override
   public int insert(Reserva reserva) throws Exception{
		int ret = 0;
		try {
		    dao.adicionar(reserva);
			ret=1;
		} catch (Exception e) {			
			e.printStackTrace();
		}		
		
		return ret;
	}
	
	@Override
	public int alterar(Reserva reserva) throws Exception{
		int ret = 0;
		try {
			dao.atualizar(reserva);
			ret=1;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return ret;
	}
	
	public int remover(Reserva veserva) throws Exception{
		int ret = 0;
		try {
			dao.remover(veserva);
			ret=1;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return ret;
	}
	
    
	public static void main(String[] args) throws Exception{
		ReservaDAO dao = ReservaDAOImpl.getInstance();
		Reserva u = new Reserva();		
		u.setDisciplina("Matematica");
		u.setStart("2018-04-25T00:00:00");
		u.setEnd("2018-04-27T00:00:00");
		u.setId(14);		
		u.setResourceId(13);
		u.setTitle("Teste main");
		u.setProfessor(new Professor().setId(3));
		u.setLaboratorio(new Laboratorio().setId(13));		
		
		int ret = dao.insert(u);
		System.out.println("atualizado  = " + ret );		
		
	/*	ReservaDAO dao = ReservaDAOImpl.getInstance();
		
		
		Reserva veserva = new Reserva();
		  
		reserva = dao.getBean(2);
		  System.out.println("Venda data " + venda.getData() + " Cliente " + venda.getCliente().getNome() + " total = " + venda.getTotal());
		  for (VendaItens itens : venda.getItens()) {
			  System.out.println("--->Produto " + itens.getFkProduto().getDescricao() + " qtd " + itens.getQtd() + " valor " + itens.getValor());
		  }
		  
		  
		  
		  venda.setTotal(new BigDecimal(18.99));
	      venda.setCliente(new Cliente().setNome("").setId(4));
		  venda.setData(new Date(System.currentTimeMillis()));
		
		  List<VendaItens> itensVenda = new ArrayList<VendaItens>();
		  VendaItens p1 = new VendaItens();
		  p1.setFkProduto(new Produto().setId(1));
		  p1.setQtd(2);
		  p1.setValor(new BigDecimal(1.52));
		  itensVenda.add(p1);
		  
		  VendaItens p2 = new VendaItens();
		  p2.setFkProduto(new Produto().setId(3));
		  p2.setQtd(2);
		  p2.setValor(new BigDecimal(11.25)); 
		  itensVenda.add(p2);
		   
		  venda.setItens(itensVenda);
   		   p1.setVenda(venda);
		   p2.setVenda(venda);
		   int ret = dao.insert(venda);
		  System.out.println("Retorno inclusao " + ret);
		    
		    */
		  
		  //ReflectionUtil.imprimirLista(venda.getItens());
		/*   
		  
		  System.out.println("..................");
		
		for (Venda z : dao.listar("11/06/2018","11/06/2018")) {
			System.out.println("Codigo " + z.getId() +  " Cliente " + z.getCliente().getNome() + " Total " + z.getTotal());
			for(VendaItens b : z.getItens()){
				System.out.println("........" + b.getId() + " " 
			 + b.getFkProduto().getDescricao() + " valor: " + b.getValor());
			}
		}*/
		
		
		//Lancamento b = dao.getBean(1);
		//System.out.println("BeanZona " + b.getCodigo() + " " + b.getPessoa().getNome());
		
		
		/*
		for(BeanJob b : db.getLista()){
			System.out.println("id " + b.getId() + " procedure " + b.getWhat() + " broken = " + b.getBroken() );
		} */
		
		
	}

	
}
