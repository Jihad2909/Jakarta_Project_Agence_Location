<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
	
   	<div class="text-center mt-3">
   		<p class="fs-1 text-center">Ajouter un produit bien</p>
   	</div>
    <div class="container mt-4">
    	<form name="f2" action="ajoutBien" method="get">
	    	<div class="form-outline form-white mb-4">	                
	          <input type="text" placeholder="Type de bien" name="type"class="form-control form-control-lg" required/>	                
	        </div>	
	        <div class="form-outline form-white mb-4">	              	
	          <input type="text" placeholder="Description" name="discription" class="form-control form-control-lg" required/>	                
	        </div>
	        <div class="form-outline form-white mb-4">	              	
	          <input type="text" placeholder="Prix" name="prix" class="form-control form-control-lg" required/>	                
	        </div>
	        <div class="form-outline form-white mb-4">	              	
	          <input type="text" placeholder="Disponibilité" name="dispo" class="form-control form-control-lg" required/>	                
	        </div>	        
		    <div class="form-outline form-white mb-4">	              	
	          <input type="text" placeholder="Tapez l'adresse de l'image " name="image"  class="form-control form-control-lg" required/>	                
	        </div>	          
	        <div class="form-outline form-white mb-4">	              	
	          <input type="submit" name="btn" value="ADD" class="form-control form-control-lg" />	                
	        </div>
        </form>        
    </div>
	
</body>
</html>