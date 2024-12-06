package Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import Model.Utilisateur;
import ModelServices.UtilisateurService;

@WebServlet("/inscrit")
public class inscrit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inscrit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/Views/register.jsp").forward(request, response);		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		
		Utilisateur u = new Utilisateur();
		u.setNom(nom);
		u.setPrenom(prenom);
		u.setMdp(mdp);
		u.setEmail(email);
		
		UtilisateurService us = new UtilisateurService();
		
		try {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			
			if(us.insertUser(u)) {
				request.getRequestDispatcher("/WEB-INF/Views/login.jsp").forward(request, response);
			}else{
				 out.println("<font color=red  size=18>Incription Echoueé <br>");
				 out.println("<a href=inscrit>Revenir inscription </a>");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
