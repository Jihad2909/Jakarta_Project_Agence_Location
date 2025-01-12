package Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import Model.Utilisateur;
import ModelServices.UtilisateurService;

@WebServlet("/profile")
public class AfficheProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AfficheProfile() {
        super();
            }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ss = request.getSession();
		if(!ss.isNew()) {
			UtilisateurService us = new UtilisateurService();
			int iduser = (int) ss.getAttribute("iduser");
			try {
				
				Utilisateur u = us.selectById(iduser);
				request.setAttribute("user", u);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}	
			
			request.getRequestDispatcher("/WEB-INF/Views/profile.jsp").forward(request, response);
		}else {
			response.sendRedirect("login");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
