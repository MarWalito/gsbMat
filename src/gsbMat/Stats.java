package gsbMat;

public class Stats {
	private int nbEmprunts;
	private String type;
	private String login;
	
	public Stats (int unNbEmprunts, String unType, String unLogin) {
		this.nbEmprunts = unNbEmprunts; 
		this.type = unType;
		this.login = unLogin;
	}

	public int getNbEmprunts() {
		return nbEmprunts;
	}

	public void setNbEmprunts(int nbEmprunts) {
		this.nbEmprunts = nbEmprunts;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
