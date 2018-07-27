<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page = "/main.jsp" />


<div class="container">
  <div class="container-fluid">   

	<table id="table2" class="table" cellspacing="0" width="100%">
	<thead>
	<tr> 
	    <th width="5%">Id</th>
		<th width="8%">Nome</th>		
		<th width="8%">Endereco</th>
		<th width="10%"></th>
		<th width="10%"></th>
	</tr>
	</thead>
	<tbody>
	<s:iterator value="lstProfessor">
		<tr id="tr${id}">
			<td>${id}</td>
			<td>${nome}</td>
			<td>${endereco.endereco} ${endereco.bairro}</td>
			<td>
			    <s:if test="ativo==1">
			       <span class="badge badge-success">Ativo</span>
			    </s:if>
			    <s:else>
			       <span class="badge badge-danger">Desativado</span> 
			    </s:else>
			</td>	
			<td>
				<a href="#" id="excluir${id}" class="btn btn-sm btn-danger" role="button" 
						    data-record-id="${id}" data-record-nome="${nome}">
						          <i class="fa fa-trash-o" aria-hidden="true"></i>
				</a>
					
				<a href="frmSetupEdit?id=${id}" class="btn btn-sm btn-info" role="button" title="Editar">
							 <i class="fa fa-pencil" aria-hidden="true"></i>
				</a>		 
			</td>
		</tr>	
	</s:iterator>
	 </tbody>	
	</table>
	
     </div>  
    </div>
     		
<jsp:include page = "/javascript.inc.jsp" />
<script type="text/javascript" language="javascript" class="init">
	$(document).ready(function() {
	/*     $('#table2').dataTable( {
	        "order": [[ 1, "asc" ]],
	        "language": {
	            "url": "../js/Portuguese-Brasil.json"
	        }
	    }); */

	    $( "[id*='excluir']" ).click(function(event) {
			var data = $(event.delegateTarget).data();
			var id = data.recordId;
			var nome = data.recordNome;
			
			bootbox.confirm("Confirma essa exclusão do professor " + nome, function(result){ 		  
		           if (result){
		    	    	
				    	$.getJSON( "remover?professor.id="+id, function( data ) {
				    		console.log(data);
				    		if (data.id==1){
				    			bootbox.alert({	                	            
	                	            message: 'Professor exluido com sucesso!</b>'
	                	        });
				    			var vTr = $('#tr'+id);
	                			$('#tr'+id).fadeOut();
				    		}else
				    			{
					    			bootbox.alert({	                	            
		                	            message: 'ERRO ao excluir professor!</b>'
		                	        });
				    			}	    		
				    	 });
		    	      } 	
		    	  });
	        });
			
			
	    
	    
	});
</script>	


<jsp:include page = "/footer.jsp" />