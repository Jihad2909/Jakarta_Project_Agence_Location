package Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import Model.Reservation;
import ModelServices.ReservationService;


@WebServlet("/commandes")
public class SaveReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SaveReservation() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idbien = (String) request.getParameter("idBien");
		String iduserS = (String) request.getParameter("iduser");
		String datedebut = (String) request.getParameter("dateDebut");
		String datefin = (String) request.getParameter("dateFin");
		String p = (String) request.getParameter("prix");
		
		ReservationService rs = new ReservationService();
		Reservation r = new Reservation();
		int idb = Integer.parseInt(idbien);
		int prix = Integer.parseInt(p);
		int iduser = Integer.parseInt(iduserS);
		
		r.setId_bein(idb);
		r.setId_utilisateur(iduser);
		r.setDate_debut(datedebut);
		r.setDate_fin(datefin);
		r.setStatus("en cours");
		r.setMontant_totale(prix);
		
		try { 
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");	
			
			if(rs.insertCommande(r)) {
				out.println("<font color=green  size=18>Insertion confirmer <br>");				
				out.println("<a href=affichecommande>Voir Liste de commande </a><br>");
				out.println("<a href=cata>Revenir au Catalogue </a>");
				//request.getRequestDispatcher("/affichecommande").forward(request, response);
			}else {				
				out.println("<font color=red  size=18>Promblem de reservation de Bien <br>");
				out.println("<a href=cata>Revenir au Catalogue </a>");
			}
				
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
