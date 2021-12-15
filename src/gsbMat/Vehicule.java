/**
 * Classe véhicule
 */
package gsbMat;

public class Vehicule {
	//Attributs privés
	private int id;
	private String immat;
	private String modele; 
	private String marque; 
	private int nbPlaces; 
	/**
	 * Constructeur avec 4 paramètres
	 * @param unId
	 * @param uneImmat
	 * @param unModele
	 * @param uneMarque
	 * @param unNbPlaces
	 */
	public Vehicule(int unId, String uneImmat, String unModele, String uneMarque, int unNbPlaces) {
		this.id = unId;
		this.immat = uneImmat; 
		this.modele = unModele; 
		this.marque = uneMarque; 
		this.nbPlaces = unNbPlaces;
	}
	/**
	 * Deuxième constructeur avec 3 paramètres
	 * @param uneImmat
	 * @param unModele
	 * @param uneMarque
	 */
	public Vehicule( String uneImmat, String unModele, String uneMarque) {
		this.immat = uneImmat; 
		this.modele = unModele; 
		this.marque = uneMarque; 
	}
	/**
	 * Permet de récupérer l'id
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * Permet de définir l'id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Permet de récupérer l'immatriculation
	 * @return
	 */
	public String getImmat() {
		return immat;
	}
	/**
	 * Permet de définir l'immatriculation
	 * @param id
	 */
	public void setImmat(String immat) {
		this.immat = immat;
	}
	/**
	 * Permet de récupérer le modele
	 * @return
	 */
	public String getModele() {
		return modele;
	}
	/**
	 * Permet de définir le modele
	 * @param id
	 */
	public void setModele(String modele) {
		this.modele = modele;
	}
	/**
	 * Permet de récupérer la marque
	 * @return
	 */
	public String getMarque() {
		return marque;
	}
	/**
	 * Permet de définir la marque
	 * @param id
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}
	/**
	 * Permet de récupérer le nombres de places
	 * @return
	 */
	public int getNbPlaces() {
		return nbPlaces;
	}
	/**
	 * Permet de définir le nombres de places
	 * @param id
	 */
	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}
	/**
	 * Méthode toString
	 */
	public String toString() {
		String rep = null;
		rep = "Id : " + this.id + " Immat : " + this.immat + " Modele : " + this.modele + " Marque : " + this.marque + " Nb Places : " + this.nbPlaces;
		return rep;
	}
	
}
