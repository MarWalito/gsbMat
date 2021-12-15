package gsbMat;

public class EmpruntVeh {
	private int idVisiteur; 
	private String dateDebut; 
	private String dateFin;
	private int duree;
	private Vehicule vehicule;
	
	public EmpruntVeh (String uneDateDebut, String uneDateFin, int uneDuree, Vehicule unVehicule ) {
		this.vehicule = unVehicule;
		this.dateDebut = uneDateDebut;
		this.dateFin = uneDateFin;
		this.duree = uneDuree;
	}

	public int getIdVisiteur() {
		return idVisiteur;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public void setIdVisiteur(int idVisiteur) {
		this.idVisiteur = idVisiteur;
	}


	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}
	
}
