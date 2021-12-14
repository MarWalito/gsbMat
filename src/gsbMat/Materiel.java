package gsbMat;

public class Materiel {
	private int id; 
	private String libelle; 
	private double largeur; 
	private double longueur; 
	private String type;
	
	public Materiel (int unId,String unLibelle,  double uneLargeur, double uneLongueur, String unType) {
		this.id = unId; 
		this.libelle = unLibelle;
		this.largeur = uneLargeur; 
		this.longueur = uneLongueur; 
		this.type = unType; 
	}
	public Materiel (int unId, String unLibelle) {
		this.id = unId; 
		this.libelle = unLibelle;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLargeur() {
		return largeur;
	}

	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}

	public double getLongueur() {
		return longueur;
	}

	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
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
