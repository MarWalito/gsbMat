/**
 * Classe emprunt véhicule
 */
package gsbMat;

public class EmpruntVeh {
	private int idVisiteur; 
	private String dateDebut; 
	private String dateFin;
	private int duree;
	private Vehicule vehicule;
	/**
	 * Constucteur avec 4 paramètres
	 * @param uneDateDebut
	 * @param uneDateFin
	 * @param uneDuree
	 * @param unVehicule
	 */
	public EmpruntVeh (String uneDateDebut, String uneDateFin, int uneDuree, Vehicule unVehicule ) {
		this.vehicule = unVehicule;
		this.dateDebut = uneDateDebut;
		this.dateFin = uneDateFin;
		this.duree = uneDuree;
	}
	/**
	 * Permet de récupérer l'id visiteur
	 * @return
	 */
	public int getIdVisiteur() {
		return idVisiteur;
	}
	/**
	 * Permet d'accèder a la classe véhicule
	 * @return
	 */
	public Vehicule getVehicule() {
		return vehicule;
	}
	/**
	 * Permet de définir un objet de type véhicule
	 * @param idVisiteur
	 */
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
	/**
	 * Permet de définir l'id visiteur
	 * @param idVisiteur
	 */
	public void setIdVisiteur(int idVisiteur) {
		this.idVisiteur = idVisiteur;
	}
	/**
	 * Permet de récupérer la date du début
	 * @return
	 */
	public String getDateDebut() {
		return dateDebut;
	}
	/**
	 * Permet de définir la date du début
	 * @param idVisiteur
	 */
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	/**
	 * Permet de récupérer la date de fin
	 * @return
	 */
	public String getDateFin() {
		return dateFin;
	}
	/**
	 * Permet de définir la date de fin
	 * @param idVisiteur
	 */
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	/**
	 * Permet de récupérer la durée
	 * @return
	 */
	public int getDuree() {
		return duree;
	}
	/**
	 * Permet de définir la duree
	 * @param idVisiteur
	 */
	public void setDuree(int duree) {
		this.duree = duree;
	}
	
}
