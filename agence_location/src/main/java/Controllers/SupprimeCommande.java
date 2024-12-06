package Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import Model.Reservation;
import ModelServices.ReservationService;


@WebServlet("/suppcommande")
public class SupprimeCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SupprimeCommande() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idbien = (String) request.getParameter("idbien");
		String iduser = (String) request.getParameter("iduser");
		int idb = Integer.parseInt(idbien);
		int idu = Integer.parseInt(iduser);
		ReservationService rs = new ReservationService();
		
		try {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			
			if(rs.SuppCommande(idu, idb)) {
				List<Reservation> liste = new ArrayList<Reservation>();
				liste = rs.findCommandeByIDUser(idu);
				double tot = rs.montantTotal(idu);
				request.setAttribute("listeComm", liste);
				request.setAttribute("montant", tot);
				request.getRequestDispatcher("/WEB-INF/Views/AfficheCommande.jsp").forward(request, response);				
			}else {
				out.println("<font color=red  size=18>Problem de supprission! <br>");
				out.println("<a href=affichecommande>Revenir au liste de commande </a>");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
