package Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import Model.Bien;
import ModelServices.CatalogueService;

@WebServlet("/ajoutBien")
public class AjoutBien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AjoutBien() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String desc = request.getParameter("discription");
		String prix = request.getParameter("prix");
		String dispo = request.getParameter("dispo");
		String image = request.getParameter("image");
		
		
		CatalogueService cs = new CatalogueService();
		Bien b = new Bien();
		
		b.setDescription(desc);
		b.setDisponibilite(dispo);
		b.setImage(image);
		b.setPrixParJour(prix);
		b.setType(type);		
		
		try {
			
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			
			if(cs.insertBien(b)) {
				 out.println("<font color=green  size=18>Ajout avec succes <br>");
			}else {
				 out.println("<font color=red  size=18>Problem d'insertion <br>");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
				
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
