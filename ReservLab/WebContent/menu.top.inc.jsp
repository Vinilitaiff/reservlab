  <nav class="navbar navbar-expand-md bg-navbar">
		<div class="container">
	      <a class="navbar-brand" href="#"></a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">                
                        
           <li class="nav-item dropdown">
           <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Professor</a>
            <div class="dropdown-menu" aria-labelledby="dropdown01">
            <a class="nav-link" href="${pageContext.request.contextPath}/professor/frmSetupCad">Cadastrar</a>
           <a class="nav-link" href="${pageContext.request.contextPath}/professor/listar">Listar</a>                     
           </li>
            
           <li class="nav-item dropdown">
           	  <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Laboratorio</a>
              <div class="dropdown-menu" aria-labelledby="dropdown01">
              	  <a class="nav-link" href="${pageContext.request.contextPath}/laboratorio/frmSetupCad">Cadastrar</a>
            	  <a class="nav-link" href="${pageContext.request.contextPath}/laboratorio/listar">Listar</a>
            </li> 
           	         			  	
			     <!--
             <li class="nav-item">
               <a class="nav-link disabled" href="#"><?php echo $_SERVER["HTTP_HOST"];?></a>
             </li> -->

          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Reserva</a>
            <div class="dropdown-menu" aria-labelledby="dropdown01">
                 <%-- <a class="dropdown-item" href="${pageContext.request.contextPath}/venda/listar">Vendas</a> --%>
                 
                 <a class="dropdown-item" href="${pageContext.request.contextPath}/reserva/frmSetupNovaReserva">Cadastar</a>
                 <a class="dropdown-item" href="${pageContext.request.contextPath}/reserva/listar">Listar</a>
                 <a class="dropdown-item" href="${pageContext.request.contextPath}/reserva/	listarDetalhe">Listar Detalhe</a>
                 
              
            </div>
          </li>
      
        </ul>
        
		
	         <ul class="nav navbar-nav navbar-right">
				  <li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
             		 NOME USUARIO LOGADO
					</a>
					<div class="dropdown-menu" aria-labelledby="dropdown01">
					  <a class="dropdown-item" href="/sistemas/rotasdasurnas/logout.php">Sair</a>
					  <a class="dropdown-item" href="#">Log</a>
					</div>
				  </li>
				 <!-- <li><a href="#" id="countdown">00:00</a></li> -->
		     </ul>
         </div>
	  </div>
  </nav>