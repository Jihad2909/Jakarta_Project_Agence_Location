package Controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import Model.Bien;
import Model.Utilisateur;
import ModelServices.CatalogueService;
import ModelServices.UtilisateurService;

@WebServlet("/cata")
public class Cataloge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Cataloge() {
        super();
        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ss = request.getSession();
		if(!ss.isNew()) {
			int iduser = (int) ss.getAttribute("iduser");
			CatalogueService cs = new CatalogueService();
			UtilisateurService us = new UtilisateurService();			
			try {
				
				List<Bien> listeBien = cs.findAllBien();
				Utilisateur u = us.selectById(iduser);
				request.setAttribute("liste", listeBien);
				request.setAttribute("iduser", u);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}		
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Views/Catalogue.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("login");
		}
			
			
			
		}		

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
