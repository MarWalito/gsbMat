/**
 * Classe mat�riel
 */
package gsbMat;

public class Materiel {
	private int id; 
	private String libelle; 
	private double largeur; 
	private double longueur; 
	private String type;
	/**
	 * Constructeur � 5 param�tres
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
	 * Constructeur � 2 param�tres
	 * @param unId
	 * @param unLibelle
	 */
	public Materiel (int unId, String unLibelle) {
		this.id = unId; 
		this.libelle = unLibelle;
	}
	/**
	 * Constructeur � 2 param�tres
	 * @param unLibelle
	 * @param unType
	 */
	public Materiel (String unLibelle, String unType) {
		this.libelle = unLibelle; 
		this.type = unType;
	}
	/**
	 * Permet de r�cup�rer le libelle
	 * @return
	 */
	public String getLibelle() {
		return libelle;
	}
	/**
	 * Permet de d�finir le libelle
	 * @param libelle
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
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
	 * Permet de r�cup�rer la largeur
	 * @return
	 */
	public double getLargeur() {
		return largeur;
	}
	/**
	 * Permet de d�finir la largeur
	 * @param largeur
	 */
	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}
	/**
	 * Permet de r�cup�rer la longueur
	 * @return
	 */
	public double getLongueur() {
		return longueur;
	}
	/**
	 * Permet de d�finir la longueur
	 * @param longueur
	 */
	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}
	/**
	 * Permet de r�cup�rer le type
	 * @return
	 */
	public String getType() {
		return type;
	}
	/**
	 * Permet de d�finir le type
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * M�thode toXml pour un affichage de recherche
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
