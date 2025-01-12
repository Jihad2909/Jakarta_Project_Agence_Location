<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
    <%@ page import="Model.Bien" %>
    <%@ page import="Model.Utilisateur" %>
    
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">
    <title>Page Catalogue</title>	
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    
  </head>

  <body onload="cata" class="bg-light">
	<% Utilisateur iduser = (Utilisateur) request.getAttribute("iduser"); %>
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
          <div>
          	<p class="text-white fs-2">Welcome <%= iduser.getNom() %> <%= iduser.getPrenom() %></p>
          	<a class="fs-4" href="deconnexion">Deconnexion</a>
          </div>
        </div>
      </div>
    </header>
    <main role="main">			
    <section class="jumbotron text-center mt-3 mb-4">
      <div class="container">
         <h1 class="jumbotron-heading">Nous Produits</h1>
      <div class="input-group mt-4">
		 <div class="form-outline w-100" data-mdb-input-init>
			<form action="search" method="get">
				<input placeholder="rechercher un produit depuis (prix or type)" type="search" name="recherche" class="form-control p-4" />
	         	<input type="submit" value="rechercher">
	        </form>
         </div>
      </div>	
     </div>     	
    </section>
    	
      <div  class="album py-5 bg-light">
        <div class="container " style="border:solid 5px grey;">
          <div class="row mt-3">          	
          	<%          	
          		List<Bien> listeBiens = (List<Bien>) request.getAttribute("liste");          		
          		
          		if (listeBiens.isEmpty()){
          			%><h3>Aucun produit trouvé</h3><% 
          		}          		
          		else{
	    		 for(Bien b : listeBiens){ 	    			 
    		%>
            <div class="col-md-4 ">
              <div class="card mb-4 box-shadow">
                <img class="card-img-top" src="<%= b.getImage() %>" alt="Card image cap">
                <div class="card-body">
                  <p class="card-text">Type : <span class="text-success fw-bold"><%= b.getType() %></span></p>	
                  <p class="card-text">Description :<span class="text-dark fw-bold"> <%= b.getDescription() %> </span></p>
                  <p class="card-text">Disponibilité : <span class="text-success fw-bold"><%= b.getDisponibilite() %></span></p>
                  <p class="card-text">Prix : <span class="text-dark fw-bold"><%= b.getPrixParJour() %></span> DT</p>
                  <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group w-100">
                      <form name="f2" action="reservation" method="get">
                      	<input type="hidden" name="bienID" value="<%= b.getId_bein()%>">
                      	<input type="hidden" name="iduser" value="<%= iduser.getId()%>">                        	                  	                     	
                      	<button type="submit" class="btn btn-sm btn-outline-secondary text-dark">Commander</button>
                      </form>
                    </div>                    
                  </div>
                </div>
              </div>
            </div> 
            <% }} %>             
          </div>
        </div>
      </div>
    </main>
    

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
 	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    
</html>
