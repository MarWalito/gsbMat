package gsbMat;

public class EmpruntMat {
	private int idVisiteur; 
	private Materiel materiel; 
	private String dateDebut; 
	private String dateFin;
	private int duree;
	
	public EmpruntMat (String uneDateDebut, String uneDateFin, int uneDuree, Materiel unMateriel ) {
		this.materiel = unMateriel;
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

	public Materiel getMateriel() {
		return materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
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
