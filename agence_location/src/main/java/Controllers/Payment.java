package Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import Model.Reservation;
import ModelServices.CatalogueService;
import ModelServices.ReservationService;

@WebServlet("/makePayment")
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Payment() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String iduse = request.getParameter("iduser");
		String idbie = request.getParameter("idbien");
		int iduser = Integer.parseInt(iduse);
		int idbien = Integer.parseInt(idbie);
		
		ReservationService rs = new ReservationService();
		
		try {
			
			if(rs.PayerCommande(iduser, idbien)) {
				response.sendRedirect("affichecommande");
			}else {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				 out.println("<font color=red  size=18>Incription Echoueé <br>");
				 out.println("<a href=inscrit>Revenir inscription </a>");
			}			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
