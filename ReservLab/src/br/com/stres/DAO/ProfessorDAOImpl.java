package br.com.stres.DAO;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.stres.model.Endereco;
import br.com.stres.model.Professor;
import br.com.stres.util.EntityManagerProvider;
import br.com.stres.util.GeradorSenha;
import br.com.stres.util.JPAUtility;

public class ProfessorDAOImpl implements ProfessorDAO {
	
	private DAO<Professor> dao = new DAO<Professor>(Professor.class);
	
    static ProfessorDAO db;
	
	public static ProfessorDAO getInstance(){
		if (db == null){
			db = new ProfessorDAOImpl();
		}
		return db;
	}
	 

	@Override
	public Professor getBean(int id) throws Exception{
		Professor professor = new Professor();
		try {
			professor = dao.getBean(id); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return professor;
	}

	@Override
	public Professor getBean(String email) throws Exception{
		Professor professor = null;
		EntityManager em = JPAUtility.getEntityManager();
		try {						
			 TypedQuery<Professor> query = em.createQuery("SELECT c FROM Cliente c WHERE c.email = :email", Professor.class);
			 professor = query.setParameter("email", email).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		return professor;
	}
	
	@Override
	public List<Professor> listarCbx() throws Exception{
		List<Professor> lista = null;
		 EntityManager em = JPAUtility.getEntityManager();
		 
		  try {
			 
 
			
		  }
		  catch (Exception e) {
			     em.close();
				e.printStackTrace();
		  }	finally {
				em.close();
		  }
		return lista;	
	} 
	
	@Override
	public int inserir (Professor professor) throws Exception{
		int ret = 0;
		try {
			dao.adicionar(professor);
			ret =1;
		} catch (Exception e) {
			//System.out.println("Ocorreu um ERRO " + e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}
	
	@Override
	public int alterar (Professor professor) throws Exception{
		int ret = 0;
		try {
			dao.atualizar(professor);
			ret =1;
		} catch (Exception e) {
			//System.out.println("Ocorreu um ERRO " + e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}
	
	
	public int remover (Professor professor) throws Exception{
		int ret = 0;
		try {
			dao.remover(professor);
			ret =1;
		} catch (Exception e) {
			//System.out.println("Ocorreu um ERRO " + e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public List<Professor> listar() throws Exception {
		List<Professor> lista = null;
		  try {
			  lista = dao.listarTodos();
		  }
		  catch (Exception e) {
				e.printStackTrace();
			}
		return lista;	
	}
	
	@Override
	public List<Professor> listarStatus(int ativo) throws Exception{
		List<Professor> lista = null;
		//EntityManager em = JPAUtility.getEntityManager();
		
		//EntityManager em = new JPAUtil().getEntityManager();
		
		EntityManager em = EntityManagerProvider.getInstance().createManager();
		
		
		  try {
			  TypedQuery<Professor> query = em.createQuery("SELECT c FROM Professor c WHERE c.ativo = :status", Professor.class);
			  lista = query.setParameter("status", ativo).getResultList();
		  }
		  catch (Exception e) {
				e.printStackTrace();
			}
		  finally {
				em.close();
			}
		return lista;	
	}
	
    
	public static void main(String[] args) throws Exception{
		ProfessorDAO dao = ProfessorDAOImpl.getInstance();
		
		Professor u = new Professor();
		Endereco end = new Endereco();
		end.setEndereco("Rua Montese");
		end.setNumero(12);
		end.setCep("69050000");
		end.setBairro("Nova Esperanca");
		end.setCidade("Manaus1");		
		u.setEmail("moacir.viana@tre-am.jus.br");
		u.setNome("Moacir M Viana");
		u.setCpf("43637833204");
		u.setAtivo(1);
		u.setCelular("92981536356");
		u.setEndereco(end);
		u.setId(3);
		
		String senha = GeradorSenha.getInstance().encriptar("senha123");
		
		u.setSenha(senha);
		int ret = dao.inserir(u);
		System.out.println("atualizado  = " + ret );		
		
		
		 
		// for (Cliente z : dao.listarCbx()) {
			//	System.out.println("Nome " + z.getNome()); 
			//}
		
		/*
		u = dao.getBean(4);
		System.out.println("GetBean pelo ID Nome " + u.getNome() + " CPF " + u.getCpf());
		 
		u = dao.getBean("vinicius.cavalcante@tre-am.jus.br");
		System.out.println("GETBean Pelo email Nome " + u.getNome() + " CPF " + u.getCpf() + " end " + u.getEndereco().getEndereco());
		*/
	}


}
