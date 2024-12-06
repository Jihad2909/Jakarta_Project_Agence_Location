package ModelServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import IDAO.IDAO;
import Model.Bien;
import Model.Utilisateur;

public class UtilisateurService implements IDAO<Utilisateur>{

	Utilisateur u = new Utilisateur();
	List<Utilisateur> listeUser = new ArrayList<Utilisateur>();
	
		
	public boolean insertUser(Utilisateur u) throws ClassNotFoundException {
		
		boolean result = false;
		String insert = "INSERT INTO utilisateur "
					  + "(nom,prenom,email,mdp)"
					  + "VALUES (?,?,?,?);";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence","root","your_password");
			PreparedStatement pr = c.prepareStatement(insert);
		){
			pr.setString(1,u.getNom());
			pr.setString(2,u.getPrenom());
			pr.setString(3,u.getEmail());
			pr.setString(4,u.getMdp());	
			
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
	
	public Utilisateur verify(String email ,String mdp) throws ClassNotFoundException {
		
		boolean result = false;
		String verifier = "select * from utilisateur "
					  + "where email=? and mdp=? ;";
					  
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence","root","your_password");
			PreparedStatement pr = c.prepareStatement(verifier);
		){
			pr.setString(1, email);
			pr.setString(2, mdp);
			
			Resultset r = (Resultset) pr.executeQuery();	
			
			if(((ResultSet) r).next()) {
				u.setId(((ResultSet) r).getInt("id"));
				u.setNom(((ResultSet) r).getString("nom"));
				u.setPrenom(((ResultSet) r).getString("prenom"));				
			}else {
				u.setPrenom("null");
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		
		return u;
	}

	public Utilisateur selectById(int n) throws ClassNotFoundException {
		
		boolean result = false;
		String verifier = "select * from utilisateur "
					    + "where id=?;";
					  
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence","root","your_password");
			PreparedStatement pr = c.prepareStatement(verifier);
		){
			pr.setInt(1, n);			
			
			Resultset r = (Resultset) pr.executeQuery();	
			
			if(((ResultSet) r).next()) {
				u.setId(((ResultSet) r).getInt("id"));
				u.setNom(((ResultSet) r).getString("nom"));
				u.setPrenom(((ResultSet) r).getString("prenom"));
				u.setEmail(((ResultSet) r).getString("email"));
				u.setMdp(((ResultSet) r).getString("mdp"));
			}else {
				u.setPrenom("null");
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		
		return u;
	}
	
	
	public boolean update(Utilisateur o) throws ClassNotFoundException {
		
		boolean result = false;
		String verifier = "UPDATE utilisateur "
						+ "SET nom=?, prenom=?, email=?, mdp=?"						
					    + "WHERE id=?;";
					  
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence","root","your_password");
			PreparedStatement pr = c.prepareStatement(verifier);
		){
			pr.setString(1, o.getNom());
			pr.setString(2, o.getPrenom());
			pr.setString(3, o.getEmail());
			pr.setString(4, o.getMdp());
			pr.setInt(5, o.getId());
			
			int r = pr.executeUpdate();	
			
			if(r > 0 ) {
				result = true;
			}else {
				result = false;
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		
		return result;
	}

	
	public boolean delete(Utilisateur o) {
		
		return true;
	}

	
	public Utilisateur selectAll(Utilisateur u) {
		
		return null;
	}

	
	
	
	
}
