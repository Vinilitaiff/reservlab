<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page = "/main.jsp" />

<div class="container">
  <div class="container-fluid">   

  <div class="card">
  <div class="card-body">
     <h5 class="card-title">Mensagem do sistema</h5>
	  
	  <h6 class="card-subtitle mb-2 text-muted">Veja as informações abaixo detalhadas pelo sistema</h6>
	   
		 
		  <s:if test="hasActionErrors()">
		   <div class="alert alert-danger" role="alert" id="success_message"> <i class="fa fa-thumbs-down"></i>
				<s:actionerror/>
			</div>	
		</s:if>
		
		<s:if test="hasActionMessages()">
			<!-- Success message -->
	       <div class="alert alert-success" role="alert" id="success_message">
	       <i class="fa fa-thumbs-up"></i>

	   		     <s:actionmessage/>
		    </div>
		</s:if>
  </div>
   
  </div>
 </div>
</div>

<jsp:include page = "/javascript.inc.jsp" />

<jsp:include page = "/footer.jsp" />