/**
 * Classe matériel
 */
package gsbMat;

public class Materiel {
	private int id; 
	private String libelle; 
	private double largeur; 
	private double longueur; 
	private String type;
	/**
	 * Constructeur à 5 paramètres
	 * @param unId
	 * @param unLibelle
	 * @param uneLargeur
	 * @param uneLongueur
	 * @param unType
	 */
	public Materiel (int unId,String unLibelle,  double uneLargeurdzqdqdq, double uneLongueur, String unType) {
		this.id = unId; 
		this.libelle = unLibelle;
		this.largeur = uneLargeurdzqdqdq; 
		this.longueur = uneLongueur; 
		this.type = unType; 
	}
	/**
	 * Constructeur à 2 paramètres
	 * @param unId
	 * @param unLibelle
	 */
	public Materiel (int unId, String unLibelle) {
		this.id = unId; 
		this.libelle = unLibelle;
	}
	/**
	 * Constructeur à 2 paramètres
	 * @param unLibelle
	 * @param unType
	 */
	public Materiel (String unLibelle, String unType) {
		this.libelle = unLibelle; 
		this.type = unType;
	}
	/**
	 * Permet de récupérer le libelle
	 * @return
	 */
	public String getLibelle() {
		return libelle;
	}
	/**
	 * Permet de définir le libelle
	 * @param libelle
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
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
	 * Permet de récupérer la largeur
	 * @return
	 */
	public double getLargeur() {
		return largeur;
	}
	/**
	 * Permet de définir la largeur
	 * @param largeur
	 */
	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}
	/**
	 * Permet de récupérer la longueur
	 * @return
	 */
	public double getLongueur() {
		return longueur;
	}
	/**
	 * Permet de définir la longueur
	 * @param longueur
	 */
	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}
	/**
	 * Permet de récupérer le type
	 * @return
	 */
	public String getType() {
		return type;
	}
	/**
	 * Permet de définir le type
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * Méthode toXml pour un affichage de recherche
	 * @return
	 */
	public String toXML() {
		String rep = "";
		rep += "\n\t<materiel>";
		rep += "\n\t\t<id> " + this.id + " </id>";
		rep += "\n\t\t<libelle> " + this.libelle + " </libelle>";
		rep += "\n\t\t<largeur> " + this.largeur + " </largeur>";
		rep += "\n\t\t<longueur> " + this.longueur + " </longueur>";
		rep += "\n\t\t<type> " + this.type + " </type>";
		rep += "\n\t</materiel>";
		return rep;
	}
	
	
}
