<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="Model.Reservation" %>
    <%@ page import="java.util.List" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">


</head>
<body class="bg-light">
 <header>      
      <div class="navbar p-3 navbar-dark bg-dark box-shadow">
        <div class="container d-flex justify-content-between">
          <a href="cata" class="navbar-brand d-flex align-items-left">
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
	<p class="text-center fs-1 mt-3">Liste de Commande </p>
<div class="container mt-4">
	<table class="table table-striped">
	  <thead>
	    <tr>
	      <th scope="col">#_Commande</th>
	      <th scope="col">#_User</th>
	      <th scope="col">#_Bien</th>
	      <th scope="col">DateDebut</th>
	      <th scope="col">DateFin</th>
	      <th scope="col">Status</th>
	      <th scope="col">Montant</th>      
	    </tr>
	  </thead>
	  <tbody>
	    <% 
	    	List<Reservation> listR = (List<Reservation>) request.getAttribute("listeComm");
	    	double tot = (double) request.getAttribute("montant");	
	    
	    	if (listR.isEmpty()){%>
	    		<h2> Aucune commande Trouve</h2>
	    	<%}
	    	else{
	    		for(Reservation r : listR){    	    	
	    %>	    
	    <tr>
	      <td scope="row"><%=r.getId() %></td>
	      <td><%=r.getId_utilisateur() %></td>
	      <td><%=r.getId_bein() %></td>
	      <td><%=r.getDate_debut()%></td>
	      <td><%=r.getDate_fin() %></td>
	      <td><%=r.getStatus() %></td>  
	      <td><%=r.getMontant_totale() %> DT</td>
	      <td>
	      	<div>
	      	<% if (r.getStatus().equals("en cours")){ %>	
	      		<form name="f22" action="confirmcommande" method="get">
	      			<input type="hidden" name="idbien" value="<%=r.getId_bein() %>">
	    			<input type="hidden" name="iduser" value="<%=r.getId_utilisateur() %>">
		      		<button type="submit">Confirm</button>		      		
		      	</form>
		    <% } %>
		    <% if (r.getStatus().equals("en cours")){ %>
		      	<form name="f11" action="suppcommande" method="get">
		      	<input type="hidden" name="idbien" value="<%=r.getId_bein() %>">
	    		<input type="hidden" name="iduser" value="<%=r.getId_utilisateur() %>">
		      		<button type="submit">Supprime</button>	
	      		</form>  
	      	<% } %>   
	      	<% if (r.getStatus().equals("confirmer")){ %>
		      	<form name="f11" action="payment" method="get">
		      	<input type="hidden" name="idbien" value="<%=r.getId_bein() %>">
	    		<input type="hidden" name="iduser" value="<%=r.getId_utilisateur() %>">
		      		<button type="submit">Payer</button>	
	      		</form>  
	      	<% } %> 		
	      	</div>
	      </td>    
	    </tr>
	    <%}}%>
	  </tbody>
	</table>
	<div style="width:100%;">
		<p style="width:100%;" class="text-center fs-3 fw-bold">Montant Total : <%= tot %></p>
	</div>
</div>


	
</body>
</html>