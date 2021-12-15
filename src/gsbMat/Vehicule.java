/**
 * Classe v�hicule
 */
package gsbMat;

public class Vehicule {
	//Attributs priv�s
	private int id;
	private String immat;
	private String modele; 
	private String marque; 
	private int nbPlaces; 
	/**
	 * Constructeur avec 4 param�tres
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
	 * Deuxi�me constructeur avec 3 param�tres
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
	 * Permet de r�cup�rer l'id
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * Permet de d�finir l'id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Permet de r�cup�rer l'immatriculation
	 * @return
	 */
	public String getImmat() {
		return immat;
	}
	/**
	 * Permet de d�finir l'immatriculation
	 * @param id
	 */
	public void setImmat(String immat) {
		this.immat = immat;
	}
	/**
	 * Permet de r�cup�rer le modele
	 * @return
	 */
	public String getModele() {
		return modele;
	}
	/**
	 * Permet de d�finir le modele
	 * @param id
	 */
	public void setModele(String modele) {
		this.modele = modele;
	}
	/**
	 * Permet de r�cup�rer la marque
	 * @return
	 */
	public String getMarque() {
		return marque;
	}
	/**
	 * Permet de d�finir la marque
	 * @param id
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}
	/**
	 * Permet de r�cup�rer le nombres de places
	 * @return
	 */
	public int getNbPlaces() {
		return nbPlaces;
	}
	/**
	 * Permet de d�finir le nombres de places
	 * @param id
	 */
	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}
	/**
	 * M�thode toString
	 */
	public String toString() {
		String rep = null;
		rep = "Id : " + this.id + " Immat : " + this.immat + " Modele : " + this.modele + " Marque : " + this.marque + " Nb Places : " + this.nbPlaces;
		return rep;
	}
	
}
