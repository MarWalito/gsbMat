/**
 * Classe EmpruntMat pour gérer les emprunts
 */
package gsbMat;

public class EmpruntMat {
	private int idVisiteur; 
	private Materiel materiel; 
	private String dateDebut; 
	private String dateFin;
	private int duree;
	/**
	 * Constructeur avec 4 paramètres  
	 * @param uneDateDebut
	 * @param uneDateFin
	 * @param uneDuree
	 * @param unMateriel
	 */
	public EmpruntMat (String uneDateDebut, String uneDateFin, int uneDuree, Materiel unMateriel ) {
		this.materiel = unMateriel;
		this.dateDebut = uneDateDebut;
		this.dateFin = uneDateFin;
		this.duree = uneDuree;
	}
	/**
	 * Recupérer l'id visiteur
	 * @return
	 */
	public int getIdVisiteur() {
		return idVisiteur;
	}
	/**
	 * Définir l'id visiteur
	 * @param idVisiteur
	 */
	public void setIdVisiteur(int idVisiteur) {
		this.idVisiteur = idVisiteur;
	}
	/**
	 * Accéder à la classe matériel
	 * @return
	 */
	public Materiel getMateriel() {
		return materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}
	/**
	 * Récupérer la date début
	 * @return
	 */
	public String getDateDebut() {
		return dateDebut;
	}
	/**
	 * Définir la date début
	 * @param dateDebut
	 */
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	/**
	 * Récupérer la date fin
	 * @return
	 */
	public String getDateFin() {
		return dateFin;
	}
	/**
	 * Récupérer la date fin
	 * @param dateDebut
	 */
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	/**
	 * Définir la durée
	 * @param dateDebut
	 */
	public int getDuree() {
		return duree;
	}
	/**
	 * Définir la durée
	 * @param dateDebut
	 */
	public void setDuree(int duree) {
		this.duree = duree;
	}

	
}
