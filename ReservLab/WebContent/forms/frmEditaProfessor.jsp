<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page = "/main.jsp" />


<div class="container">
  <div class="container-fluid">   
	 <form action="" method="post" name="form1" id="frmProfessor">
	    <input type="hidden" name="professor.id" value="${professor.id}">
	          <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="inputNome">Nome</label>
			      <input type="text" name="professor.nome" value="${professor.nome}" class="form-control" id="nome" placeholder="Informe nome">
			    </div>
			    <div class="form-group col-md-6">
			      <label for="inputCPF">CPF</label>
			      <input name="professor.cpf" type="text" value="${professor.cpf}" class="form-control" id="cpf" placeholder="cpf">
			    </div>
			  </div>
			  
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="inputEmail">Email</label>
			      <input type="email" name="professor.email" value="${professor.email}" class="form-control" id="email" placeholder="Email">
			    </div>
			    <div class="form-group col-md-6">
			      <label for="inputPassword">Password</label>
			      <input name="professor.senha" type="password" value="${professor.senha}" class="form-control" id="senha" placeholder="Password">
			    </div>
			  </div>
			  
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="inputCelular">Celular</label>
			    <input name="professor.celular" type="text" value="${professor.celular}" class="form-control" id="celular" placeholder="Informe num cel fone">
			    </div>
			    <div class="form-group col-md-6">
			       <s:select label="Tipo" class="form-control"
						        name="professor.ativo"
						        headerKey="-1" headerValue="--Selecione--"
						        list="#{'0':'Desativado', '1':'Ativo'}"
						        required="true"	 />
			    </div>
			  </div>
			  
			   <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="inputAddress">Endereço</label>
			    <input name="professor.endereco.endereco" type="text" value="${professor.endereco.endereco}" class="form-control" id="endereco" placeholder="Informe seu endereco">
			    </div>
			    <div class="form-group col-md-6">
			      <label for="inputBarrro">Bairro</label>
			      <input name="professor.endereco.bairro" type="text" value="${professor.endereco.bairro}" class="form-control" id="bairro" placeholder="Bairro">
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="inputCity">Cidade</label>
			      <input type="text" class="form-control" id="cidade" name="professor.endereco.cidade" value="${professor.endereco.cidade}">
			    </div>
			    <div class="form-group col-md-4">
			      <label for="inputState">Número</label>
			      <input type="text" class="form-control" id="numero" name="professor.endereco.numero" value="${professor.endereco.numero}">
			    </div>
			    <div class="form-group col-md-2">
			      <label for="inputZip">CEP</label>
			      <input type="text" class="form-control" id="cep" name="professor.endereco.cep" value="${professor.endereco.cep}">
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
	    	bootbox.confirm("Confirma essa edição", function(result){ 		  
	           if (result){
	    	    	var dados = $('#frmProfessor').serialize();
			    	$.getJSON( "alterar?"+dados, function( data ) {
			    		if (data.id==1){			    				                		
		    				bootbox.alert({	                	            
                	            message: 'Professor aterado com sucesso!</b>'
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