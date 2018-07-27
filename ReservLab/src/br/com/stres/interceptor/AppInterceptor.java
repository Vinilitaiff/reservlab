package br.com.stres.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import br.com.stres.model.BeanLogin;

public class AppInterceptor implements Interceptor{
	private static final long serialVersionUID = -7919618750953161995L;

	public void destroy() {}

	//called during interceptor initialization
	public void init() {}
	
	//put interceptor code here
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String result = "success";
		/* VERIFICANDO A SESSÃO */
		try{
		   HttpSession session = ServletActionContext.getRequest().getSession(true);
    	   BeanLogin b = (BeanLogin)session.getAttribute("login");
	    	if (b.getNome()==null) {
	    		 //System.out.println("Sessão expirada");
	    		 result = "error";
	    	} 
	    	else {
	    		
	    		// capturando namespace sem a barra
	    		String namespace = invocation.getProxy().getNamespace();
	    		namespace = namespace.substring(1);
	    		
	    		String acao = invocation.getInvocationContext().getName();
	    		
	    		//TabelasDAOImpl.getInstance().gravaLog(b.getTitulo(), acao, namespace);
	    		result = invocation.invoke();
	    	}
		}catch (Exception e) {
			result = "loginNecessario";
		}
		// ---------   DEPOIS DA ACTION
		// System.out.println("CustomInterceptor, after invocation.invoke()... Result........>> " + result);
		return result;
	}

}