<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page = "/main.jsp" />



<div class="container-full">
  <div class="container-fluid">   

<div class="panel panel-danger">
 <div class="panel-heading">Mensagem do sistema</div>
 <div class="panel-body">
 
 
  <div class="alert alert-danger" role="alert">
      <p><span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span>&nbsp;&nbsp;Veja as informações abaixo detalhadas pelo sistema:</p>
    <br>
         
         <s:actionerror />
          
   </div>  


    </div>  
  </div> 

    </div>  
  </div>
  
<jsp:include page = "/javascript.inc.jsp" />

<jsp:include page = "/footer.jsp" />