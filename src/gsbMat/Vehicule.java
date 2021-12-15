package gsbMat;

public class Vehicule {
	private int id;
	private String immat;
	private String modele; 
	private String marque; 
	private int nbPlaces; 
	
	public Vehicule(int unId, String uneImmat, String unModele, String uneMarque, int unNbPlaces) {
		this.id = unId;
		this.immat = uneImmat; 
		this.modele = unModele; 
		this.marque = uneMarque; 
		this.nbPlaces = unNbPlaces;
	}
	
	public Vehicule( String uneImmat, String unModele, String uneMarque) {
		this.immat = uneImmat; 
		this.modele = unModele; 
		this.marque = uneMarque; 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImmat() {
		return immat;
	}

	public void setImmat(String immat) {
		this.immat = immat;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}
	
	public String toString() {
		String rep = null;
		rep = "Id : " + this.id + " Immat : " + this.immat + " Modele : " + this.modele + " Marque : " + this.marque + " Nb Places : " + this.nbPlaces;
		return rep;
	}
	
}
