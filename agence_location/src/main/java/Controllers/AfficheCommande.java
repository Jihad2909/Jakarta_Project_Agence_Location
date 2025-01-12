package Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Model.Reservation;
import ModelServices.ReservationService;


@WebServlet("/affichecommande")
public class AfficheCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AfficheCommande() {
        super();
       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ss = request.getSession();		
		
		if(!ss.isNew()){
			int iduser = (int) ss.getAttribute("iduser");
			ReservationService rs = new ReservationService();
			List<Reservation> liste = new ArrayList<Reservation>();
			
			try {
				
				liste = rs.findCommandeByIDUser(iduser);
				double tot = rs.montantTotal(iduser);
				request.setAttribute("listeComm", liste);
				request.setAttribute("montant", tot);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			request.getRequestDispatcher("/WEB-INF/Views/AfficheCommande.jsp").forward(request, response);
		}else {
			response.sendRedirect("login");
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
