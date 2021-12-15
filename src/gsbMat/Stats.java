/**
 * Classe stats
 */
package gsbMat;

public class Stats {
	private int nbEmprunts;
	private String type;
	private String login;
	private Materiel unMateriel;
	/**
	 * Constructeurs à 2 paramètres
	 * @param unNbEmprunts
	 * @param unMateriel
	 */
	public Stats (int unNbEmprunts, Materiel unMateriel) {
		this.nbEmprunts = unNbEmprunts; 
		this.unMateriel = unMateriel;
	}
	/**
	 * Constructeurs à 3 paramètres
	 * @param unNbEmprunts
	 * @param unType
	 * @param unLogin
	 */
	public Stats (int unNbEmprunts, String unType, String unLogin) {
		this.nbEmprunts = unNbEmprunts; 
		this.type = unType;
		this.login = unLogin;
	}
	/**
	 * Permet de récuperer le nombres d'emprunts
	 * @return
	 */
	public int getNbEmprunts() {
		return nbEmprunts;
	}
	/**
	 * Permet de définir un nombres d'emprunts
	 * @param nbEmprunts
	 */
	public void setNbEmprunts(int nbEmprunts) {
		this.nbEmprunts = nbEmprunts;
	}
	/**
	 * Permet de récuperer le login
	 * @return
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * Permet de définir un login
	 * @param nbEmprunts
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * Permet de récuperer le type
	 * @return
	 */
	public String getType() {
		return type;
	}
	/**
	 * Permet de définir un type
	 * @param nbEmprunts
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * Permet de récuperer un objet de type matériel
	 * @return
	 */
	public Materiel getUnMateriel() {
		return unMateriel;
	}
	/**
	 * Permet de définir un objet de type matériel
	 * @param nbEmprunts
	 */
	public void setUnMateriel(Materiel unMateriel) {
		this.unMateriel = unMateriel;
	}
	
}
