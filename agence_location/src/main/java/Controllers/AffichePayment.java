package Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import Model.Bien;
import Model.Utilisateur;
import ModelServices.CatalogueService;
import ModelServices.UtilisateurService;

@WebServlet("/payment")
public class AffichePayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public AffichePayment() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String iduse = request.getParameter("iduser");
		String idbie = request.getParameter("idbien");
		int iduser = Integer.parseInt(iduse);
		int idbien = Integer.parseInt(idbie);
		
		CatalogueService cs = new CatalogueService();
		UtilisateurService us = new UtilisateurService();
		
		try {
			
			Utilisateur u = us.selectById(iduser);
			Bien b = cs.findBienByID(idbien);
			request.setAttribute("user", u);
			request.setAttribute("bien", b);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
		
		request.getRequestDispatcher("/WEB-INF/Views/payment.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
