package br.com.stres.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;

import br.com.stres.DAO.LaboratorioDAOImpl;
import br.com.stres.DAO.ProfessorDAOImpl;
import br.com.stres.DAO.ReservaDAOImpl;
import br.com.stres.model.BeanResult;
import br.com.stres.model.Laboratorio;
import br.com.stres.model.Professor;
import br.com.stres.model.Reserva;

@SuppressWarnings("serial")
@Namespace("/reserva")
@ResultPath(value = "/")
@ParentPackage(value = "default")
public class ReservaAction extends ActionSupport {
	private List<Reserva> lstReserva;
	private List<Laboratorio> lstLaboratorio;
	private List<Professor> lstProfessor;
	private Reserva reserva;
	private int id;
	private BeanResult result;

	@Action(value = "frmSetupNovaReserva", results = { @Result(name = "success", location = "/forms/frmNovaReserva.jsp"),
			@Result(name = "error", location = "/pages/error.jsp")} 
	)			// interceptorRefs = @InterceptorRef("authStack")
	public String setupNovaVenda() {
		try {
			lstProfessor = ProfessorDAOImpl.getInstance().listar();
			lstLaboratorio = LaboratorioDAOImpl.getInstance().listar();
		} catch (Exception e) {
			return "error";
		}
		return "success";
	}
	
	@Action(value = "incluir", results = { @Result(name = "success", type = "json", params = { "root", "result" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp") }
	)			// interceptorRefs = @InterceptorRef("authStack")
	public String doIncluir() {
		BeanResult result = new BeanResult();
		int ret = 0;
		try {
			lstProfessor = ProfessorDAOImpl.getInstance().listar();
			lstLaboratorio = LaboratorioDAOImpl.getInstance().listar();					
			ret = ReservaDAOImpl.getInstance().insert(this.reserva);
			result.setId(ret);
			result.setMensagem(getText("incluir.sucesso"));
			this.result = result;
		} catch (Exception e) {
			    result.setId(0);
			   result.setMensagem(getText("incluir.error") +" Error:" + e.getMessage());
			  this.result = result;
			 //addActionError(getText("remover.error") +" Error:" + e.getMessage());
			return "error";
		}
		return "success";
	}
	
	@Action(value = "remover", results = {
			@Result(name = "success", type = "json", params = { "root", "result" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp") })
	public String doExcluir() {
		BeanResult result = new BeanResult();
		int ret = 0;
		try {
			ret = ReservaDAOImpl.getInstance().remover(this.reserva);
			result.setId(ret);
			result.setMensagem(getText("remover.sucesso"));
			this.result = result;
		} catch (Exception e) {
			    result.setId(0);
			   result.setMensagem(getText("remover.error") +" Error:" + e.getMessage());
			  this.result = result;
			 //addActionError(getText("remover.error") +" Error:" + e.getMessage());
			return "error";
		}
		return "success";
	}
	
	
	@Action(value = "listar", results = { @Result(name = "success", location = "/consultas/reserva-listar.jsp"),
			@Result(name = "error", location = "/pages/error.jsp")} 
	)			// interceptorRefs = @InterceptorRef("authStack")
	public String doListar() {

		try {
			this.lstReserva = ReservaDAOImpl.getInstance().listar();
		} catch (Exception e) {
			addActionError(getText("error.listar"));
			return "error";
		}
		return "success";
	}
	
	@Action(value = "listarDetalhe", results = { @Result(name = "success", location = "/consultas/reserva-listar-detalhe.jsp"),
			@Result(name = "error", location = "/pages/error.jsp")} 
	)			// interceptorRefs = @InterceptorRef("authStack")
	public String doListarDetalhe() {

		try {
			this.lstReserva = ReservaDAOImpl.getInstance().listar();
		} catch (Exception e) {
			addActionError(getText("error.listar"));
			return "error";
		}
		return "success";
	}
	
	@Action(value = "listarJson", results = {
			@Result(name = "success", type = "json", params = { "root", "lstReserva" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp") })
	public String doListarJson() {

		try {
			this.lstReserva = ReservaDAOImpl.getInstance().listar();
		} catch (Exception e) {
			addActionError(getText("error.listar"));
			return "error";
		}
		return "success";
	}
	
	
	@Action(value = "listarPorDataJson", results = {
			@Result(name = "success", type = "json", params = { "root", "lstReserva" }),
			@Result(name = "error", location = "/pages/resultAjax.jsp") })
	public String doListarPorDataJson() {

		try {
			this.lstReserva = ReservaDAOImpl.getInstance().listar("11/06/2018","11/06/2018");
		} catch (Exception e) {
			addActionError(getText("error.listar"));
			return "error";
		}
		return "success";
	}
	

	@Action(value = "getBeanJson", results = { @Result(name = "success", type = "json", params = { "root", "reserva" }),
			@Result(name = "error", location = "/pages/error.jsp") })
	public String getBeanJson() {
		try {
			this.reserva = ReservaDAOImpl.getInstance().getBean(this.id);
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

	public List<Reserva> getLstReserva() {
		return lstReserva;
	}

	public void setLstReserva(List<Reserva> lstReserva) {
		this.lstReserva = lstReserva;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public List<Laboratorio> getLstLaboratorio() {
		return lstLaboratorio;
	}

	public void setLstLaboratorio(List<Laboratorio> lstLaboratorio) {
		this.lstLaboratorio = lstLaboratorio;
	}

	public List<Professor> getLstProfessor() {
		return lstProfessor;
	}

	public void setLstProfessor(List<Professor> lstProfessor) {
		this.lstProfessor = lstProfessor;
	}

}