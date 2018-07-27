package br.com.stres.DAO;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.stres.model.Laboratorio;
import br.com.stres.util.EntityManagerProvider;
import br.com.stres.util.JPAUtility;


public class LaboratorioDAOImpl implements LaboratorioDAO {
	private DAO<Laboratorio> dao = new DAO<Laboratorio>(Laboratorio.class);
	static LaboratorioDAOImpl db;
	
	public static LaboratorioDAO getInstance(){
		if (db == null){
			db = new LaboratorioDAOImpl();
		}
		return db;
	}

	@Override
	public Laboratorio getBean(int id) throws Exception{
		Laboratorio Laboratorio = new Laboratorio();
		try {
			Laboratorio = dao.getBean(id); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Laboratorio;
	}

	@Override
	public List<Laboratorio> listarLike(String vdesc) throws Exception{
		List<Laboratorio> laboratorio = null;
		EntityManager em = JPAUtility.getEntityManager();
		try {						
			 TypedQuery<Laboratorio> query = em.createQuery("SELECT c FROM Laboratorio c WHERE c.descricao LIKE ?1", Laboratorio.class);
			 laboratorio = query.setParameter(1, "%" + vdesc + "%").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		return laboratorio;
	}
	
	
	@Override
	public int inserir (Laboratorio Laboratorio) throws Exception{
		int ret = 0;
		try {
			dao.adicionar(Laboratorio);
			ret =1;
		} catch (Exception e) {
			//System.out.println("Ocorreu um ERRO " + e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}
	
	@Override
	public int alterar (Laboratorio Laboratorio) throws Exception{
		int ret = 0;
		try {
			dao.atualizar(Laboratorio);
			ret =1;
		} catch (Exception e) {
			//System.out.println("Ocorreu um ERRO " + e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public int remover(Laboratorio laboratorio) throws Exception {
		int ret = 0;
		try {
			dao.remover(laboratorio);
			ret =1;
		} catch (Exception e) {
			//System.out.println("Ocorreu um ERRO " + e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}
	@Override
	public List<Laboratorio> listar() throws Exception {
		List<Laboratorio> lista = null;
		//EntityManager em = new JPAUtility().getEntityManager();
		//EntityManager em = new JPAUtil().getEntityManager();
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		try {
			 	lista = dao.listarTodos();
			  /*TypedQuery<Laboratorio> query = em.createQuery("SELECT c FROM Laboratorio c ORDER BY c.disciplina", 
					  Laboratorio.class);
			  lista = query.getResultList();*/
		  }
		  catch (Exception e) {
				e.printStackTrace();
			}finally {
				em.close();
			}
		return lista;	
	}
	
	
    
	public static void main(String[] args) throws Exception{
		//LaboratorioDAO dao = LaboratorioDAOImpl.getInstance();
		
		/*Laboratorio p0 = new Laboratorio();
		int ret = 0;
		p0.setDescricao("Mochila");
		p0.setQtd(75);
		p0.setUndmed("un");
		p0.setValor(new BigDecimal("53.45"));
		//ret = dao.inserir(p0);
		System.out.println("atualizado  = " + ret );
		
		Produto p1 = new Produto();
		p1.setDescricao("Caderno");
		p1.setQtd(50);
		p1.setUndmed("cx");
		p1.setValor(new BigDecimal("13.45"));
		ret = dao.inserir(p1);
		System.out.println("atualizado  = " + ret );		
		
		Produto p2 = new Produto();
		p2.setDescricao("Lapis");
		p2.setQtd(30);
		p2.setUndmed("un");
		p2.setValor(new BigDecimal("3.15"));
		ret = dao.inserir(p2);
		System.out.println("atualizado  = " + ret );
		
		
		Produto p3 = new Produto();
		p3.setDescricao("Apontador");
		p3.setQtd(9);
		p3.setUndmed("un");
		p3.setValor(new BigDecimal("2.25"));
		ret = dao.inserir(p3);
		System.out.println("atualizado  = " + ret );
		
		Produto p4 = new Produto();
		p4.setDescricao("Regua");
		p4.setQtd(19);
		p4.setUndmed("un");
		p4.setValor(new BigDecimal("1.52"));
		ret = dao.inserir(p4);
		System.out.println("atualizado  = " + ret );
		
		for (Produto p : dao.listar()) {
			System.out.println("produto " + p.getDescricao() + " " + p.getValor());
		}
		*/
				
	}

	
}
