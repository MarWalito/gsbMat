package gsbMat;

public class Stats {
	private int nbEmprunts;
	private String type;
	
	public Stats (int unNbEmprunts, String unType) {
		this.nbEmprunts = unNbEmprunts; 
		this.type = unType;
	}

	public int getNbEmprunts() {
		return nbEmprunts;
	}

	public void setNbEmprunts(int nbEmprunts) {
		this.nbEmprunts = nbEmprunts;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
