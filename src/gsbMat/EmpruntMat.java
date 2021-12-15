/**
 * Classe EmpruntMat pour g�rer les emprunts
 */
package gsbMat;

public class EmpruntMat {
	private int idVisiteur; 
	private Materiel materiel; 
	private String dateDebut; 
	private String dateFin;
	private int duree;
	/**
	 * Constructeur avec 4 param�tres  
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
	 * Recup�rer l'id visiteur
	 * @return
	 */
	public int getIdVisiteur() {
		return idVisiteur;
	}
	/**
	 * D�finir l'id visiteur
	 * @param idVisiteur
	 */
	public void setIdVisiteur(int idVisiteur) {
		this.idVisiteur = idVisiteur;
	}
	/**
	 * Acc�der � la classe mat�riel
	 * @return
	 */
	public Materiel getMateriel() {
		return materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}
	/**
	 * R�cup�rer la date d�but
	 * @return
	 */
	public String getDateDebut() {
		return dateDebut;
	}
	/**
	 * D�finir la date d�but
	 * @param dateDebut
	 */
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	/**
	 * R�cup�rer la date fin
	 * @return
	 */
	public String getDateFin() {
		return dateFin;
	}
	/**
	 * R�cup�rer la date fin
	 * @param dateDebut
	 */
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	/**
	 * D�finir la dur�e
	 * @param dateDebut
	 */
	public int getDuree() {
		return duree;
	}
	/**
	 * D�finir la dur�e
	 * @param dateDebut
	 */
	public void setDuree(int duree) {
		this.duree = duree;
	}

	
}
