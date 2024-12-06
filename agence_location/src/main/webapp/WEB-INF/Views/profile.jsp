<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		Utilisateur u = (Utilisateur)request.getAttribute("user");
	%>
	<div class="container mt-4">
		<p class="fs-2 text-center mb-4">Gérer votre profile</p>
		<center><img src="https://mdbcdn.b-cdn.net/img/new/avatars/2.webp" class="rounded-circle" style="width: 150px;"
  				alt="Avatar" /></center>
	
    	<form name="f2" action="updateProfile" method="post">	
	        <div class="form-outline form-white mt-3 mb-4">	              	
	          <input type="text" name="nom" value="<%=u.getNom() %>" class="form-control form-control-lg" />	                
	        </div>
	        <div class="form-outline form-white mb-4">	              	
	          <input type="text" name="prenom" value="<%=u.getPrenom() %>" class="form-control form-control-lg" />	                
	        </div>
	        <div class="form-outline form-white mb-4">	              	
	          <input type="text" name="email" value="<%=u.getEmail() %>" class="form-control form-control-lg" />	                
	        </div>	        
		    <div class="form-outline form-white mb-4">	              	
	          <input type="password" name="mdp" value="<%=u.getMdp() %>" class="form-control form-control-lg" required/>	                
	        </div>  
	        <input type="hidden" name="iduser" value="<%=u.getId() %>">
	        
	        <div class="form-outline form-white mb-4">	              	
	          <input type="submit" name="btn" value="Modifier" class="form-control form-control-lg bg-warning" />	                
	        </div>
        </form>
        
    </div>



</body>
</html>