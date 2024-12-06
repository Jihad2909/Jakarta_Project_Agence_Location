package Controllers;

import jakarta.servlet.DispatcherType;
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

@WebServlet("/search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Search() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss = request.getSession();
		if(!ss.isNew()) {
			int iduser = (int) ss.getAttribute("iduser");
			String rech = request.getParameter("recherche");		
			CatalogueService cs = new CatalogueService();
			UtilisateurService us = new UtilisateurService();
			try {
				
				List<Bien> listerech = cs.rechercheBien(rech);
				Utilisateur u = us.selectById(iduser);
				request.setAttribute("liste", listerech);
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
