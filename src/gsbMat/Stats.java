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
	 * Constructeurs � 2 param�tres
	 * @param unNbEmprunts
	 * @param unMateriel
	 */
	public Stats (int unNbEmprunts, Materiel unMateriel) {
		this.nbEmprunts = unNbEmprunts; 
		this.unMateriel = unMateriel;
	}
	/**
	 * Constructeurs � 3 param�tres
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
	 * Permet de r�cuperer le nombres d'emprunts
	 * @return
	 */
	public int getNbEmprunts() {
		return nbEmprunts;
	}
	/**
	 * Permet de d�finir un nombres d'emprunts
	 * @param nbEmprunts
	 */
	public void setNbEmprunts(int nbEmprunts) {
		this.nbEmprunts = nbEmprunts;
	}
	/**
	 * Permet de r�cuperer le login
	 * @return
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * Permet de d�finir un login
	 * @param nbEmprunts
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * Permet de r�cuperer le type
	 * @return
	 */
	public String getType() {
		return type;
	}
	/**
	 * Permet de d�finir un type
	 * @param nbEmprunts
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * Permet de r�cuperer un objet de type mat�riel
	 * @return
	 */
	public Materiel getUnMateriel() {
		return unMateriel;
	}
	/**
	 * Permet de d�finir un objet de type mat�riel
	 * @param nbEmprunts
	 */
	public void setUnMateriel(Materiel unMateriel) {
		this.unMateriel = unMateriel;
	}
	
}
