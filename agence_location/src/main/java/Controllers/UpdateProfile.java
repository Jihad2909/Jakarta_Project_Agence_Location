package Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import Model.Utilisateur;
import ModelServices.UtilisateurService;

@WebServlet("/updateProfile")
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    
    public UpdateProfile() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		String iduser = request.getParameter("iduser");
		int id = Integer.parseInt(iduser);
		
		Utilisateur u = new Utilisateur();
		
		u.setId(id);
		u.setEmail(email);
		u.setMdp(mdp);
		u.setNom(nom);
		u.setPrenom(prenom);
		
		UtilisateurService us = new UtilisateurService();
		
		try {
			if(us.update(u)) {
				Utilisateur userModified = us.selectById(id);
				request.setAttribute("user", userModified);
				request.getRequestDispatcher("/WEB-INF/Views/profile.jsp").forward(request, response);
			}else {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println("<font color=red  size=18>Problem de modification");				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
