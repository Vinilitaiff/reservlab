package br.com.stres.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;

import br.com.stres.DAO.LaboratorioDAOImpl;
import br.com.stres.model.BeanResult;
import br.com.stres.model.Laboratorio;

@SuppressWarnings("serial")
@Namespace("/laboratorio")
@ResultPath(value = "/")
@ParentPackage(value = "default")
public class LaboratorioAction extends ActionSupport {
	private List<Laboratorio> lstLaboratorio;
	private Laboratorio laboratorio;
	private int id;
	private BeanResult result;

	@Action(value = "listarJson", results = {
			@Result(name = "success", type = "json", params = { "root", "lstLaboratorio" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp") })
	public String doListarJson() {

		try {
			this.lstLaboratorio = LaboratorioDAOImpl.getInstance().listar();
		} catch (Exception e) {
			addActionError(getText("error.listar"));
			return "error";
		}
		return "success";
	}
	
	@Action(value = "listar", results = { @Result(name = "success", location = "/consultas/laboratorio-listar.jsp"),
			@Result(name = "error", location = "/pages/error.jsp")} 
	)			// interceptorRefs = @InterceptorRef("authStack")
	public String doListar() {

		try {
			this.lstLaboratorio = LaboratorioDAOImpl.getInstance().listar();
		} catch (Exception e) {
			addActionError(getText("error.listar"));
			return "error";
		}
		return "success";
	}

	@Action(value = "getBeanJson", results = { @Result(name = "success", type = "json", params = { "root", "laboratorio" }),
			@Result(name = "error", location = "/pages/error.jsp") })
	public String getBeanJson() {
		try {
			this.laboratorio = LaboratorioDAOImpl.getInstance().getBean(this.id);
		} catch (Exception e) {
			addActionError(getText("getbean.error"));
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
			ret =  LaboratorioDAOImpl.getInstance().alterar(this.laboratorio);
			res.setMensagem("Laboratorio alterado com sucesso");
			res.setId(ret);
			this.result = res;
		} catch (Exception e) {
			   addActionError(getText("editar.error"));
			    res.setMensagem("Erro ao alterar laboratorio");
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
			ret =  LaboratorioDAOImpl.getInstance().inserir(this.laboratorio);
			res.setMensagem("Laboratorio incluido com sucesso");
			res.setId(ret);
			this.result = res;
		} catch (Exception e) {
			   addActionError(getText("editar.error"));
			    res.setMensagem("Erro ao incluir laboratorio");
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
			ret =  LaboratorioDAOImpl.getInstance().remover(this.laboratorio);
			res.setMensagem("Laboratorio excluído com sucesso");
			res.setId(ret);
			this.result = res;
		} catch (Exception e) {
			   addActionError(getText("remover.error"));
			    res.setMensagem("Erro ao remover laboratorio");
			   res.setError(e.getMessage());
			 this.result = res;
			return "error";
		}
		return "success";
	}
	
	@Action(value = "frmSetupCad", results = { @Result(name = "success", location = "/forms/frmCadLaboratorio.jsp"),
			@Result(name = "error", location = "/pages/error.jsp")} 
	)			// interceptorRefs = @InterceptorRef("authStack")
	public String frmSetupCad() {

		try {
			this.laboratorio = LaboratorioDAOImpl.getInstance().getBean(this.id);
		} catch (Exception e) {
			addActionError(getText("error.listar"));
			return "error";
		}
		return "success";
	}
	
	
	@Action(value = "frmSetupEdit", results = { @Result(name = "success", location = "/forms/frmEditaLaboratorio.jsp"),
			@Result(name = "error", location = "/pages/error.jsp")} 
	)			// interceptorRefs = @InterceptorRef("authStack")
	public String frmSetupEdit() {

		try {
			this.laboratorio = LaboratorioDAOImpl.getInstance().getBean(this.id);
		} catch (Exception e) {
			addActionError(getText("error.listar"));
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

	public List<Laboratorio> getLstLaboratorio() {
		return lstLaboratorio;
	}

	public void setLstLaboratorio(List<Laboratorio> lstLaboratorio) {
		this.lstLaboratorio = lstLaboratorio;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

	public BeanResult getResult() {
		return result;
	}

	public void setResult(BeanResult result) {
		this.result = result;
	}

}