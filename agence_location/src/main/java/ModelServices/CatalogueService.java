package ModelServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import Model.Bien;
import Model.Utilisateur;

public class CatalogueService {
	
	Bien b = new Bien();
	List<Bien> list = new ArrayList<Bien>();
	List<Bien> recherche = new ArrayList<Bien>();
	List<Bien> ListBienByID = new ArrayList<Bien>();
	
	public List<Bien> findAllBien() throws ClassNotFoundException {
		
		String affiche = "Select * from bien;";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence","root","your_password");
			PreparedStatement pr = c.prepareStatement(affiche);
		){	
			
			Resultset r = (Resultset) pr.executeQuery();
			
			while (((ResultSet) r).next()) {
				Bien b = new Bien();
				b.setId_bein(((ResultSet) r).getInt("id"));
				b.setDescription(((ResultSet) r).getString("description"));
				b.setDisponibilite(((ResultSet) r).getString("diponibilite"));
				b.setPrixParJour(((ResultSet) r).getString("prix"));
				b.setType(((ResultSet) r).getString("type"));
				b.setImage(((ResultSet) r).getString("image"));
				list.add(b);
			}
				
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		
		return list;
	}
	
	public List<Bien> rechercheBien(String motCle) throws ClassNotFoundException {
		
		String affiche = "Select * from bien where type like ? or prix like ? ;";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence","root","your_password");
			PreparedStatement pr = c.prepareStatement(affiche);
		){	
			
			pr.setString(1,"%"+motCle+"%");
			pr.setString(2,"%"+motCle+"%");
			
			Resultset r = (Resultset) pr.executeQuery();
			
			
			while (((ResultSet) r).next()) {
				Bien b = new Bien();
				b.setId_bein(((ResultSet) r).getInt("id"));
				b.setDescription(((ResultSet) r).getString("description"));
				b.setDisponibilite(((ResultSet) r).getString("diponibilite"));
				b.setPrixParJour(((ResultSet) r).getString("prix"));
				b.setType(((ResultSet) r).getString("type"));
				b.setImage(((ResultSet) r).getString("image"));
				recherche.add(b);
			}
				
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		
		return recherche;
		
	} 
	
	public Bien findBienByID(int id) throws ClassNotFoundException {
		
		String affiche = "Select * from bien where id = ?";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence","root","your_password");
			PreparedStatement pr = c.prepareStatement(affiche);
		){	
			pr.setInt(1,id);
			
			Resultset r = (Resultset) pr.executeQuery();
			
			while (((ResultSet) r).next()) {
				
				b.setId_bein(((ResultSet) r).getInt("id"));
				b.setDescription(((ResultSet) r).getString("description"));
				b.setDisponibilite(((ResultSet) r).getString("diponibilite"));
				b.setPrixParJour(((ResultSet) r).getString("prix"));
				b.setType(((ResultSet) r).getString("type"));				
				
			}
				
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		
		return b;
	}

	public boolean insertBien(Bien b) throws ClassNotFoundException {
		
		boolean result = false;
		String insert = "INSERT INTO bien "
					  + "(type,description,prix,diponibilite,image)"
					  + "VALUES (?,?,?,?,?);";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence","root","your_password");
			PreparedStatement pr = c.prepareStatement(insert);
		){
			pr.setString(1,b.getType());
			pr.setString(2,b.getDescription());
			pr.setString(3,b.getPrixParJour());
			pr.setString(4,b.getDisponibilite());
			pr.setString(5,b.getImage());
			
			int i = pr.executeUpdate();
			
			if (i>0) {
				result = true;
			}				
			else {
				result = false;
			}
				
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		
		return result;
		
	}
	
	
}
