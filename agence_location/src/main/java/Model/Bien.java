package Model;

public class Bien {
	
	private int id_bein;
	private String type;
	private String description;
	private String prixParJour;
	private String disponibilite;
	private String image;
		
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getId_bein() {
		return id_bein;
	}

	public void setId_bein(int id_bein) {
		this.id_bein = id_bein;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrixParJour() {
		return prixParJour;
	}
	public void setPrixParJour(String prixParJour) {
		this.prixParJour = prixParJour;
	}
	public String getDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(String disponibilite) {
		this.disponibilite = disponibilite;
	}
	
	
}
