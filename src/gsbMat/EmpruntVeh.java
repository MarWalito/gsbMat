package gsbMat;

public class EmpruntVeh {
	private int idVisiteur; 
	private int idVehicule; 
	private String dateDebut; 
	private String dateFin;
	private int duree;
	
	public EmpruntVeh (int unIdMateriel, String uneDateDebut, String uneDateFin, int uneDuree ) {
		this.idVehicule = unIdMateriel;
		this.dateDebut = uneDateDebut;
		this.dateFin = uneDateFin;
		this.duree = uneDuree;
	}

	public int getIdVisiteur() {
		return idVisiteur;
	}

	public void setIdVisiteur(int idVisiteur) {
		this.idVisiteur = idVisiteur;
	}

	public int getIdVehicule() {
		return idVehicule;
	}

	public void setIdVehicule(int idVehicule) {
		this.idVehicule = idVehicule;
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
