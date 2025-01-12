package Controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import Model.Utilisateur;
import ModelServices.UtilisateurService;

@WebServlet("/loginInfo")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Login() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
		        
		String email = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		
		UtilisateurService us = new UtilisateurService();	
		Utilisateur u = null ;
		try {
			
			 u = us.verify(email, mdp);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if( !(u.getPrenom().equals("null")) ) {
			
			HttpSession ss = request.getSession();
			ss.setAttribute("iduser", u.getId());
			
			response.sendRedirect("cata");
			
		}else {
			response.sendRedirect("error");
		}
		
		
		
		
		doGet(request, response);
	}

}
