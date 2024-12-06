package Controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import Model.Bien;
import ModelServices.CatalogueService;

@WebServlet("/reservation")
public class Reserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Reserv() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idBien = request.getParameter("bienID");
		String idus = request.getParameter("iduser");
		int id = Integer.parseInt(idBien);
		int iduser = Integer.parseInt(idus);
		
		CatalogueService cs = new CatalogueService();
		
		try {
			
			Bien b = cs.findBienByID(id);
			request.setAttribute("bien", b);
			request.setAttribute("iduser", iduser);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Views/reservation.jsp");
		dispatcher.forward(request, response);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
