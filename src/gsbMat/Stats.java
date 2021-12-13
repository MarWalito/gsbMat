package gsbMat;

public class Stats {
    private String type;
    private int nbEmprunt;

    public Stats(String unType, int unNbEmprunt){
        this.type = unType;
        this.nbEmprunt = unNbEmprunt;
    }

    public String getType() {
        return type;
    }

    public void setType(String unType) {
        this.type = unType;
    }

    public int getNbEmprunt() {
        return nbEmprunt;
    }

    public void setNbEmprunt(int unNbEmprunt) {
        this.nbEmprunt = unNbEmprunt;
    }
}
