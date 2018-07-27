<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page = "/main.jsp" />


<div class="container">
  <div class="container-fluid">   

	<table id="table2" class="table" cellspacing="0" width="100%">
	<thead>
	<tr> 
	    <th width="5%">Id</th>
	    <th width="10%">Titulo</th>
		<th width="8%">Data Inicial</th>		
		<th width="8%">Data Final</th>			 	
		<th width="10%"></th>
	</tr>
	</thead>
	<tbody>
	<s:iterator value="lstReserva">
		<tr id="tr${id}">
			<td>${id}</td>
			<td>${title}</td>  
			<td>${start}</td> 
			<td>${end}</td>						
			<td>
				<a href="#" id="excluir${id}" class="btn btn-sm btn-danger" role="button" 
						    data-record-id="${id}" data-record-nome="${title}">
						          <i class="fa fa-trash-o" aria-hidden="true"></i>
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
			
			bootbox.confirm("Confirma essa exclusão do reserva " + nome, function(result){ 		  
		           if (result){
		    	    	
				    	$.getJSON( "remover?reserva.id="+id, function( data ) {
				    		console.log(data);
				    		if (data.id==1){
				    			$.notify({
				    				title: '<strong>Exclusão</strong>',
				    				message: data.mensagem
				    			},{	type: 'success'	});
				    			var vTr = $('#tr'+id);
	                			$('#tr'+id).fadeOut();
				    		}else
				    			{
					    			$.notify({
					    				title: '<strong>Ocorreu um erro</strong>',
					    				message: data.mensagem
					    			},{type: 'danger'});
				    			}	    		
				    	 });
		    	      } 	
		    	  });
	        });
			
			
	    
	    
	});
</script>	


<jsp:include page = "/footer.jsp" />