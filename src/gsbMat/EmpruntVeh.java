/**
 * Classe emprunt v�hicule
 */
package gsbMat;

public class EmpruntVeh {
	private int idVisiteur; 
	private String dateDebut; 
	private String dateFin;
	private int duree;
	private Vehicule vehicule;
	/**
	 * Constucteur avec 4 param�tres
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
	 * Permet de r�cup�rer l'id visiteur
	 * @return
	 */
	public int getIdVisiteur() {
		return idVisiteur;
	}
	/**
	 * Permet d'acc�der a la classe v�hicule
	 * @return
	 */
	public Vehicule getVehicule() {
		return vehicule;
	}
	/**
	 * Permet de d�finir un objet de type v�hicule
	 * @param idVisiteur
	 */
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
	/**
	 * Permet de d�finir l'id visiteur
	 * @param idVisiteur
	 */
	public void setIdVisiteur(int idVisiteur) {
		this.idVisiteur = idVisiteur;
	}
	/**
	 * Permet de r�cup�rer la date du d�but
	 * @return
	 */
	public String getDateDebut() {
		return dateDebut;
	}
	/**
	 * Permet de d�finir la date du d�but
	 * @param idVisiteur
	 */
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	/**
	 * Permet de r�cup�rer la date de fin
	 * @return
	 */
	public String getDateFin() {
		return dateFin;
	}
	/**
	 * Permet de d�finir la date de fin
	 * @param idVisiteur
	 */
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	/**
	 * Permet de r�cup�rer la dur�e
	 * @return
	 */
	public int getDuree() {
		return duree;
	}
	/**
	 * Permet de d�finir la duree
	 * @param idVisiteur
	 */
	public void setDuree(int duree) {
		this.duree = duree;
	}
	
}
