package ModelServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JSpinner.ListEditor;

import com.mysql.cj.protocol.Resultset;

import Model.Bien;
import Model.Reservation;

public class ReservationService {

	List<Reservation> Listcommande = new ArrayList<Reservation>();
	
	
	public boolean insertCommande(Reservation r) throws ClassNotFoundException {
		
		boolean test = false;
		String insert = "INSERT INTO reservation "
				  + "(idutilisateur,idbien,datedebut,datefin,status,montant)"
				  + "VALUES (?,?,?,?,?,?);";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence","root","your_password");
			PreparedStatement pr = c.prepareStatement(insert);
		){	
			
			pr.setInt(1,r.getId_utilisateur());
			pr.setInt(2,r.getId_bein());
			pr.setString(3,r.getDate_debut());
			pr.setString(4,r.getDate_fin());
			pr.setString(5,r.getStatus());
			pr.setInt(6,r.getMontant_totale());
			
			int i = pr.executeUpdate();
			
			if (i>0) {
				test = true;
			}				
			else {
				test = false;
			}
				
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		
		return test;
	}
		
	public List<Reservation> findCommandeByIDUser(int iduser) throws ClassNotFoundException {
		
		String affiche = "Select * from reservation where idutilisateur = ?";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence","root","your_password");
			PreparedStatement pr = c.prepareStatement(affiche);
		){	
			pr.setInt(1,iduser);
			
			Resultset r = (Resultset) pr.executeQuery();
			
			while (((ResultSet) r).next()) {	
				
				Reservation res = new Reservation();
				
				res.setId(((ResultSet) r).getInt("id"));
				res.setId_bein(((ResultSet) r).getInt("idbien"));
				res.setId_utilisateur(((ResultSet) r).getInt("idutilisateur"));
				res.setDate_debut(((ResultSet) r).getString("datedebut"));
				res.setDate_fin(((ResultSet) r).getString("datefin"));
				res.setStatus(((ResultSet) r).getString("status"));
				res.setMontant_totale(((ResultSet) r).getInt("montant"));
				
				Listcommande.add(res);
			}
				
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		
		return Listcommande;
	}
		
	public boolean SuppCommande(int iduser, int idbien) throws ClassNotFoundException {
		
		boolean test = false;
		String insert = "DELETE FROM reservation "
				  + "where idutilisateur = ? and idbien = ? ;";
				  
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence","root","your_password");
			PreparedStatement pr = c.prepareStatement(insert);
		){	
			
			pr.setInt(1,iduser);
			pr.setInt(2,idbien);			
			
			int i = pr.executeUpdate();
			
			if (i>0) {
				test = true;
			}				
			else {
				test = false;
			}
				
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		
		return test;
	}
		
	public boolean ConfirmCommande(int iduser, int idbien) throws ClassNotFoundException {
		
		boolean test = false;
		String update = "UPDATE reservation "
				  + "SET status = 'confirmer'"
				  + "WHERE idutilisateur = ? and idbien = ? ;";
				  
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence","root","your_password");
			PreparedStatement pr = c.prepareStatement(update);
		){	
			
			pr.setInt(1,iduser);
			pr.setInt(2,idbien);			
			
			int i = pr.executeUpdate();
			
			if (i>0) {
				test = true;
			}				
			else {
				test = false;
			}
				
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		
		return test;
	}
	
	public boolean PayerCommande(int iduser, int idbien) throws ClassNotFoundException {
		
		boolean test = false;
		String update = "UPDATE reservation "
				  + "SET status = 'Payer'"
				  + "WHERE idutilisateur = ? and idbien = ? ;";
				  
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence","root","your_password");
			PreparedStatement pr = c.prepareStatement(update);
		){	
			
			pr.setInt(1,iduser);
			pr.setInt(2,idbien);			
			
			int i = pr.executeUpdate();
			
			if (i>0) {
				test = true;
			}				
			else {
				test = false;
			}
				
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		
		return test;
	}
	
	public double montantTotal(int iduser) throws ClassNotFoundException {
		double total = 0.0;
		String affiche = "Select sum(montant) AS total from reservation,bien "
					   + "where bien.id = reservation.idbien and reservation.idutilisateur= ?";	
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence","root","your_password");
			PreparedStatement pr = c.prepareStatement(affiche);
		){	
			pr.setInt(1,iduser);			
			Resultset r = (Resultset) pr.executeQuery();			
			
			if( ((ResultSet) r).next()) {					
				total = ((ResultSet) r).getDouble("total");
			}
				
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		
		return total;
	}
	
	
	
	
}
