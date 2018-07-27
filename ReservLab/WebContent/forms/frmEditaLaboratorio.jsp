<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page = "/main.jsp" />


<div class="container">
  <div class="container-fluid">   
	 <form action="" method="post" name="form1" id="frmLaboratorio">
	    <input type="hidden" name="laboratorio.id" value="${laboratorio.id}">
	    <input 
	    name="laboratorio.title" id="title">
	          <div class="form-row">			
			    <div class="form-group col-md-6">
			      <label for="inputCPF">Bloco</label>
			      <input name="laboratorio.bloco" type="text" id="bloco" value="${laboratorio.bloco}" class="form-control" id="cpf" placeholder="cpf">
			    </div>
			    <div class="form-group col-md-6">
			      <label for="inputEmail">Sala</label>
			      <input type="email" name="laboratorio.sala" id="sala" value="${laboratorio.sala}" class="form-control" id="email" placeholder="Email">
			    </div>
			  </div>			  
			  <div class="form-row">			    
			    <div class="form-group col-md-6">
			      <label for="inputPassword">Descricao</label>
			      <input name="laboratorio.descricao" type="text" value="${laboratorio.descricao}" class="form-control" id="senha" placeholder="Password">
			    </div>			 
			    <div class="form-group col-md-6">
			      <label for="inputCelular">Qtd Lugares</label>
			    <input name="laboratorio.qtdLugares" type="text" value="${laboratorio.qtdLugares}" class="form-control" id="celular" placeholder="Informe num cel fone">
			    </div>
			  </div>				   		 
			   <button id="btnEditar" type="button" class="btn btn-success">Salvar</button>
       </form>
	
   </div>  
</div>
     		

  
<jsp:include page = "/javascript.inc.jsp" />
<script type="text/javascript" language="javascript" class="init">
$(document).ready(function() {
	    $( "#btnEditar" ).click(function() {
	    	$('#title').val("Bloco: "+ $("#bloco").val() + " Sala: " + $("#sala").val());
	    	bootbox.confirm("Confirma essa edição", function(result){ 		  
	           if (result){
	    	    	var dados = $('#frmLaboratorio').serialize();
			    	$.getJSON( "alterar?"+dados, function( data ) {
			    		if (data.id==1){			    				                		
		    				bootbox.alert({	                	            
                	            message: 'Laboratorio alterado com sucesso!</b>'
                	        });
                		}else{
                			bootbox.alert({
                                 title: 'Atenção',
                                 message: 'Ocorreu um erro inesperado. Mensagem do sistema:<br><b> ' + jsonResponse.message + '</b>',	                                 
                                });
                		}});
	    	   } 	
	    	});
	    });
	});
</script>	


<jsp:include page = "/footer.jsp" />