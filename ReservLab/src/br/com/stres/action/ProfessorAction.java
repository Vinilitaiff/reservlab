package br.com.stres.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;

import br.com.stres.DAO.ProfessorDAOImpl;
import br.com.stres.model.BeanResult;
import br.com.stres.model.Professor;

@SuppressWarnings("serial")
@Namespace("/professor")
@ResultPath(value = "/")
@ParentPackage(value = "default")
public class ProfessorAction extends ActionSupport {
	private List<Professor> lstProfessor;
	private Professor professor;
	private int id;
	private BeanResult result;

	@Action(value = "listarJson", results = {
			@Result(name = "success", type = "json", params = { "root", "lstProfessor" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp") })
	public String doListarJson() {

		try {
			this.lstProfessor = ProfessorDAOImpl.getInstance().listar();
		} catch (Exception e) {
			addActionError(getText("error.listar"));
			return "error";
		}
		return "success";
	}
	
	@Action(value = "listarCbxJson", results = {
			@Result(name = "success", type = "json", params = { "root", "lstProfessor" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp") })
	public String doListarPorStatus() {

		try {
			this.lstProfessor = ProfessorDAOImpl.getInstance().listarStatus(this.id);
		} catch (Exception e) {
			addActionError(getText("error.listar"));
			return "error";
		}
		return "success";
	}
	
	@Action(value = "listar", results = { @Result(name = "success", location = "/consultas/professor-listar.jsp"),
			@Result(name = "error", location = "/pages/error.jsp")} 
	)			// interceptorRefs = @InterceptorRef("authStack")
	public String doListar() {

		try {
			this.lstProfessor = ProfessorDAOImpl.getInstance().listar();
		} catch (Exception e) {
			addActionError(getText("error.listar"));
			return "error";
		}
		return "success";
	}
	
	
	@Action(value = "alterar", results = { @Result(name = "success", type = "json", params = { "root", "result" }),
			@Result(name = "error", location = "/pages/error.jsp") })
	// interceptorRefs = @InterceptorRef("authStack")
	public String alterar() {
		int ret = 0;
		BeanResult res = new BeanResult();
		try {
			ret =  ProfessorDAOImpl.getInstance().alterar(this.professor);
			res.setMensagem("Professor alterado com sucesso");
			res.setId(ret);
			this.result = res;
		} catch (Exception e) {
			   addActionError(getText("editar.error"));
			    res.setMensagem("Erro ao alterar professor");
			   res.setError(e.getMessage());
			 this.result = res;
			return "error";
		}
		return "success";
	}
	
	@Action(value = "remover", results = { @Result(name = "success", type = "json", params = { "root", "result" }),
			@Result(name = "error", location = "/pages/error.jsp") })
	// interceptorRefs = @InterceptorRef("authStack")
	public String remover() {
		int ret = 0;
		BeanResult res = new BeanResult();
		try {
			ret =  ProfessorDAOImpl.getInstance().remover(this.professor);
			res.setMensagem("Professor excluído com sucesso");
			res.setId(ret);
			this.result = res;
		} catch (Exception e) {
			   addActionError(getText("remover.error"));
			    res.setMensagem("Erro ao remover professor");
			   res.setError(e.getMessage());
			 this.result = res;
			return "error";
		}
		return "success";
	}
	
	@Action(value = "incluir", results = { @Result(name = "success", type = "json", params = { "root", "result" }),
			@Result(name = "error", location = "/pages/error.jsp") })
	// interceptorRefs = @InterceptorRef("authStack")
	public String incluir() {
		int ret = 0;
		BeanResult res = new BeanResult();
		try {
			ret =  ProfessorDAOImpl.getInstance().inserir(this.professor);
			res.setMensagem("Professor incluido com sucesso");
			res.setId(ret);
			this.result = res;
		} catch (Exception e) {
			   addActionError(getText("editar.error"));
			    res.setMensagem("Erro ao incluir professor");
			   res.setError(e.getMessage());
			 this.result = res;
			return "error";
		}
		return "success";
	}
	
	@Action(value = "frmSetupEdit", results = { @Result(name = "success", location = "/forms/frmEditaProfessor.jsp"),
			@Result(name = "error", location = "/pages/error.jsp")} 
	)			// interceptorRefs = @InterceptorRef("authStack")
	public String frmSetupEdit() {

		try {
			this.professor = ProfessorDAOImpl.getInstance().getBean(this.id);
		} catch (Exception e) {
			addActionError(getText("error.listar"));
			return "error";
		}
		return "success";
	}
	
	@Action(value = "frmSetupCad", results = { @Result(name = "success", location = "/forms/frmCadProfessor.jsp"),
			@Result(name = "error", location = "/pages/error.jsp")} 
	)			// interceptorRefs = @InterceptorRef("authStack")
	public String frmSetupCad() {

		try {
			this.professor = ProfessorDAOImpl.getInstance().getBean(this.id);
		} catch (Exception e) {
			addActionError(getText("error.listar"));
			return "error";
		}
		return "success";
	}

	@Action(value = "getBeanJson", results = { @Result(name = "success", type = "json", params = { "root", "professor" }),
			@Result(name = "error", location = "/pages/error.jsp") })
	public String getBeanJson() {
		try {
			this.professor = ProfessorDAOImpl.getInstance().getBean(this.id);
		} catch (Exception e) {
			addActionError(getText("getbean.error"));
			return "error";
		}
		return "success";
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public BeanResult getResult() {
		return result;
	}


	public void setResult(BeanResult result) {
		this.result = result;
	}

	public List<Professor> getLstProfessor() {
		return lstProfessor;
	}

	public void setLstProfessor(List<Professor> lstProfessor) {
		this.lstProfessor = lstProfessor;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

}