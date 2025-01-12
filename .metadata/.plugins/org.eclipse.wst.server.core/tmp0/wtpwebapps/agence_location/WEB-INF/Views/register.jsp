<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Page Incription</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  </head>
  <body class="bg-dark">
  <form action="inscrit" method="POST">
    <section class="vh-100 gradient-custom">
	  <div class="container py-5 h-100">
	    <div class="row d-flex justify-content-center align-items-center h-100">
	      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
	        <div class="card bg-secondary text-dark" style="border-radius: 1rem;">
	          <div class="card-body p-5 text-center">	
	            <div class="mb-md-5 mt-md-4 pb-5">	
	              <h2 class="fw-bold mb-5 text-uppercase">Inscription</h2>
	              
	              <div class="form-outline form-white mb-4">	                
	                <input type="text" name="nom" placeholder="votre nom" class="form-control form-control-lg" required/>	                
	              </div>
	              
	              <div class="form-outline form-white mb-4">	                
	                <input type="text" name="prenom" placeholder="votre prenom" class="form-control form-control-lg" required/>	                
	              </div>
	
	              <div class="form-outline form-white mb-4">                
	                <input type="email" name="email" placeholder="votre email" class="form-control form-control-lg" required/>	                
	              </div>
	
	              <div class="form-outline form-white mb-4">	              	
	                <input type="password" name="mdp" placeholder="votre mot de passe" class="form-control form-control-lg" required/>	                
	              </div>
	
	              <button class="btn btn-outline-light btn-lg px-5" type="submit">Inscrire</button>	
	            </div>	
	            <div>
	              <p class="mb-0">Si vous avez un compte! <a href="login" class="text-warning fw-bold">Connecter</a>
	              </p>
	            </div>	
	          </div>
	        </div>
	      </div>
	    </div>
	  </div>
</section>  
</form>  
    
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>