package gsbMat;

public class EmpruntMat {
	private int idVisiteur; 
	private int idMateriel; 
	private String dateDebut; 
	private String dateFin;
	private int duree;
	
	public EmpruntMat (int unIdMateriel, String uneDateDebut, String uneDate, int uneDuree ) {
		this.idMateriel = unIdMateriel;
		this.dateDebut = uneDateDebut;
		this.dateFin = dateFin;
		this.duree = uneDuree;
	}

	public int getIdVisiteur() {
		return idVisiteur;
	}

	public void setIdVisiteur(int idVisiteur) {
		this.idVisiteur = idVisiteur;
	}

	public int getIdMateriel() {
		return idMateriel;
	}

	public void setIdMateriel(int idMateriel) {
		this.idMateriel = idMateriel;
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
