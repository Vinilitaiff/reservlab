<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page = "/main.jsp" />


<div class="container">
  <div class="container-fluid">   
	 <form action="incluir" method="post" name="form1" id="frmReserva">
	    <input  name="reserva.resourceId" id="title">
	          <div class="form-row">
			    <div class="form-group col-md-4">
			      <label for="inputNome">Professor</label>			          
			        <s:select headerKey="-1" headerValue="Informe o Professor"
										cssClass="form-control selectpicker" list="lstProfessor"
										listValue="nome" listKey="id" id="professor"
										name="reserva.professor" theme="simple"/>			     
			    </div>
			    <div class="form-group col-md-4">
			   <label for="inputNome">Laboratorio</label>			          
			         <s:select headerKey="-1" headerValue="Informe o Laboratorio"
										cssClass="form-control selectpicker" list="lstLaboratorio"
										listValue="title" listKey="id" id="laboratorio"
										name="reserva.laboratorio" theme="simple"/>

			      </div>	  
			      <div class="form-group col-md-4">
			   			<label for="inputNome">Disciplina</label>			          			         			     
			    		 <input name="reserva.disciplina" type="text" id="disciplina" class="form-control form-control-sm" id="disciplina" placeholder="Disciplina">
			      </div> 		        
			  </div>
			   
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="inputEmail">Data/Hora Inicial</label>			      
			      <input name="reserva.start" type="text" class="form-control form-control-sm" id="dataini" placeholder="Data/Hora Inicial">
			    </div>
			    <div class="form-group col-md-6">
			          <label for="inputCPF">Data/Hora Final</label>
					  <input name="reserva.end" type="text" class="form-control form-control-sm" id="datafim" placeholder="Data/Hora Final">					  			      
			    </div> 			   
			  			 
			  </div> 
					  
			
			   <button id="btnIncluir" type="button" class="btn btn-sm btn-success">Reservar</button>
			   
       </form>
       <br>
       <br>
		<s:if test="hasActionErrors()">
		   <div class="alert alert-danger" role="alert" id="success_message"> <i class="glyphicon glyphicon-thumbs-down"></i>
				<s:actionerror/>
			</div>	
		</s:if>
		
		<s:if test="hasActionMessages()">
			<!-- Success message -->
	       <div class="alert alert-success" role="alert" id="success_message">
	   		     <s:actionmessage/>
		    </div>
		</s:if>

   </div>  
</div>
     		

  
<jsp:include page = "/javascript.inc.jsp" />
<script type="text/javascript" language="javascript" class="init">

/* $(function () {
    $('#dataini').datetimepicker({
   	 i18n:{
   		  pt:{
   		   months:[
   		    'Janeiro','Fevereiro','Março','Abril',
   		    'Maio','Junho','Julho','Agosto',
   		    'Setembro','Outubro','Novembro','Dezembro',
   		   ],
   		   dayOfWeek:[
   		    "Seg", "Ter", "Qua", "Qui", 
   		    "Dom", "Sex", "Sab",
   		   ]
   		  }
   		 },
   	//yearOffset:222,   	
   	format:'d-m-Y h:m:s'   	
    });
    
    $('#datafim').datetimepicker({
      	 i18n:{
      		  pt:{
      		   months:[
      		    'Janeiro','Fevereiro','Março','Abril',
      		    'Maio','Junho','Julho','Agosto',
      		    'Setembro','Outubro','Novembro','Dezembro',
      		   ],
      		   dayOfWeek:[
      		    "Seg", "Ter", "Qua", "Qui", 
      		    "Dom", "Sex", "Sab",
      		   ]
      		  }
      		 },
      	//yearOffset:222,   	
      	format:'d-m-Y h:m:s'   	
       });
}); */

$("#dataini").mask("9999-99-99T99:99:99",{placeholder:"yyyy-mm-ddThh:mm:ss"});
$("#datafim").mask("9999-99-99T99:99:99",{placeholder:"yyyy-mm-ddThh:mm:ss"});

 $(document).ready(function() {
	 $( "#btnIncluir" ).click(function() {		
		 $('#title').val($("#laboratorio").val());
	    	bootbox.confirm("Confirma essa Reserva", function(result){	    		    	    
	           if (result){
	    	    	var dados = $('#frmReserva').serialize(); 
	    	    	console.log("Value==" + $("dataini").val())
	    	    	console.log("Dados=="+ dados);
			    	$.getJSON( "incluir?"+dados, function( data ) {
			    			if (data.id==1){			    				                		
			    				bootbox.alert({	                	            
	                	            message: 'Reserva incluido com sucesso!</b>'
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
/*  
function getValor(idObj,id){
	var s = document.getElementById("produto"+idObj);
	var qtd = document.getElementById("qtd"+idObj).value;
	//var texto = s.options[s.selectedIndex].text;
	var valor = s.value;
	console.log("VAlor do objeto " + valor);
	//document.getElementById("vlr"+idObj).value=valor;
	
	 $.getJSON( "../produto/getBeanJson?id="+id, function( data ) {
 		console.log(data);
		document.getElementById("vlr"+idObj).value = (data.valor * qtd);
		document.getElementById("vlrund"+idObj).value = (data.valor);
 	});
			                
			                
	
}
  */
</script>	


<jsp:include page = "/footer.jsp" />