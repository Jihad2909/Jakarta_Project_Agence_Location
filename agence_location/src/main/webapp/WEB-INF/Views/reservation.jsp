<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="Model.Bien" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  </head>
  <body class="align-bottom bg-light" >
  	 <header>      
      <div class="navbar p-3 navbar-dark bg-dark box-shadow">
        <div class="container d-flex justify-content-between">
          <a href="cata" class="navbar-brand d-flex align-items-center">
            <strong>Catalogue des biens</strong>
          </a>
          <a href="affichecommande" class="navbar-brand d-flex align-items-right">
            <strong>Liste de Commande</strong>
          </a>
          <a href="profile" class="navbar-brand d-flex align-items-right">
            <strong>Gere profile</strong>
          </a>
        </div>
      </div>
    </header>
  
  	<% 	
  		Bien b = (Bien) request.getAttribute("bien");
  		int iduser = (int) request.getAttribute("iduser");
  	%>
   	<div class="text-center mt-3">
   		<h2 class="fs-1">Reservé <%=b.getDescription() %></h2>
   	</div>
    <div class="container mt-4">
    	<form name="f2" action="commandes" method="get">
	    	<div class="form-outline form-white mb-4">	                
	          <input type="text" name="description" value="<%= b.getDescription() %>" class="form-control form-control-lg" />	                
	        </div>	
	        <div class="form-outline form-white mb-4">	              	
	          <input type="text" name="dispo" value="<%= b.getDisponibilite() %>" class="form-control form-control-lg" />	                
	        </div>
	        <div class="form-outline form-white mb-4">	              	
	          <input type="text" name="prix" value="<%= b.getPrixParJour() %>" class="form-control form-control-lg" />	                
	        </div>
	        <div class="form-outline form-white mb-4">	              	
	          <input type="text" name="type" value="<%= b.getType() %>" class="form-control form-control-lg" />	                
	        </div>	        
		    <div class="form-outline form-white mb-4">
		      <label class="fs-3">Date Debut</label>	              	
	          <input type="date" name="dateDebut"  class="form-control form-control-lg" required/>	                
	        </div> 
	        <div class="form-outline form-white mb-4">
		      <label class="fs-3">Date Fin</label>	              	
	          <input type="date" name="dateFin"  class="form-control form-control-lg" required/>	                
	        </div> 
	        <input type="hidden" name="idBien" value="<%= b.getId_bein() %>">
	        <input type="hidden" name="iduser" value="<%= iduser %>">
	        
	        <div class="form-outline form-white mb-4">	              	
	          <input type="submit" name="btn" value="Reserve" class="form-control form-control-lg" />	                
	        </div>
        </form>
        
    </div>
    
    
    
    
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>