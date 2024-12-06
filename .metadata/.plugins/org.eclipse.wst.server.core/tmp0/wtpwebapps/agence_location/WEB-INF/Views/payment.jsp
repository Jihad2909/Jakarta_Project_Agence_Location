<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="Model.Bien" %>
    <%@ page import="Model.Utilisateur" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
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
    <%
    	Utilisateur user = (Utilisateur) request.getAttribute("user"); 
    	Bien b = (Bien) request.getAttribute("bien"); 
    
    
    %>
    
	<div class="container p-0 mt-3">
	
        <div class="card px-4">
        <p class="fs-2 fw-bold" >C.Info : <%= b.getDescription() %> | <%= b.getType() %></p>
            <p class="h8 py-3 fs-4">Payer</p>
            <div class="row gx-3">
                <div class="col-12">
                <form action="makePayment" method="get">
                    <div class="d-flex flex-column">
                        <p class="text mb-1">Card Name</p>
                        <input class="form-control mb-3" type="text" placeholder="Name" value="<%= user.getNom() %> <%= user.getPrenom()%>" required>
                    </div>
                </div>
                <div class="col-12">
                    <div class="d-flex flex-column">
                        <p class="text mb-1">Card Number</p>
                        <input class="form-control mb-3" type="text" placeholder="1234 5678 435678"required>
                    </div>
                </div>
                <div class="col-6">
                    <div class="d-flex flex-column">
                        <p class="text mb-1">Expiry</p>
                        <input class="form-control mb-3" type="text" placeholder="MM/YYYY" required>
                    </div>
                </div>
                <div class="col-6">
                    <div class="d-flex flex-column">
                        <p class="text mb-1">CVV/CVC</p>
                        <input class="form-control mb-3 pt-2 " type="password" placeholder="***"required>
                    </div>
                </div>                
	                <input type="hidden" name="idbien" value="<%= b.getId_bein() %>">
	                <input type="hidden" name="iduser" value="<%= user.getId() %>">
	                <div>
	                    <button style="width:100%;" class="btn btn-primary mb-3">Payer | <%= b.getPrixParJour() %>DT</button>
	                </div>
                </form>                
            </div>
        </div>
    </div>


</body>
</html>