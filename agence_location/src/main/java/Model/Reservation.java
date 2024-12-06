package Model;

import java.util.concurrent.atomic.AtomicInteger;

public class Reservation {
	
	private int id;
	private int id_utilisateur;
	private int id_bein;
	private String date_debut;
	private String date_fin;
	private String status;
	private int montant_totale;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_utilisateur() {
		return id_utilisateur;
	}
	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	public int getId_bein() {
		return id_bein;
	}
	public void setId_bein(int id_bein) {
		this.id_bein = id_bein;
	}
	public String getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}
	public String getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getMontant_totale() {
		return montant_totale;
	}
	public void setMontant_totale(int montant_totale) {
		this.montant_totale = montant_totale;
	}
	
	
	
}
