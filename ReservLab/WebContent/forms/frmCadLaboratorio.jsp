<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page = "/main.jsp" />


<div class="container">
  <div class="container-fluid">   
	 <form action="" method="post" name="form1" id="frmLaboratorio">
	     <input   name="laboratorio.title" id="title">
	          <div class="form-row">			
			    <div class="form-group col-md-6">
			      <label for="inputCPF">Bloco</label>
			      <input name="laboratorio.bloco" type="text" class="form-control" id="bloco" placeholder="Informe o Bloco">
			    </div>
			    <div class="form-group col-md-6">
			      <label for="inputEmail">Sala</label>
			      <input type="email" name="laboratorio.sala"  class="form-control" id="sala" placeholder="Informe o Sala">
			    </div>
			  </div>			  
			  <div class="form-row">			     
			    <div class="form-group col-md-6">
			      <label for="inputPassword">Descricao</label>
			      <input name="laboratorio.descricao" type="text" class="form-control" id="senha" placeholder="Informe a descricao">
			    </div>			 
			    <div class="form-group col-md-6">
			      <label for="inputCelular">Qtd Lugares</label>
			    <input name="laboratorio.qtdLugares" type="text" class="form-control" id="celular" placeholder="Informe qtd Lugares">
			    </div>
			  </div>				   		 
			   <button id="btnIncluir" type="button" class="btn btn-success">Salvar</button>
       </form>
	
   </div>  
</div>
     		

  
<jsp:include page = "/javascript.inc.jsp" />
<script type="text/javascript" language="javascript" class="init">
$(document).ready(function() {	
	    $( "#btnIncluir" ).click(function() {
	    	bootbox.confirm("Confirma esse cadastro", function(result){
	    		$('#title').val("Bloco: "+ $("#bloco").val() + " Sala: " + $("#sala").val());    	    	
	           if (result){
	    	    	var dados = $('#frmLaboratorio').serialize();
	    	    	console.log("Value==" + $("title").val())
	    	    	console.log("Dados=="+ dados);
			    	$.getJSON( "incluir?"+dados, function( data ) {
			    			if (data.id==1){			    				                		
			    				bootbox.alert({	                	            
	                	            message: 'Laboratorio incluido com sucesso!</b>'
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
	
	console.log("Value==" + $("title").val)
				
</script>	


<jsp:include page = "/footer.jsp" />