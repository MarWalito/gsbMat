package gsbMatTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gsbMat.Vehicule;
import gsbMat.Modele.M_gsbMat;

class test {
	//On v�rifie que l'insertion ne fonctionne pas quand la cl� primaire est d�j� utilis�
	@Test
	public void testAjout() {
		Assert.assertFalse("Erreur insert", M_gsbMat.addMateriel(15, "Portable", 10.02, 10.02,"Portable"));
	}
	//On v�rifie que la connexion sans sha1 ne fonctionne pas
	@Test
	public void testConnexion() {
		Assert.assertFalse("Erreur connexion", M_gsbMat.connexion("pe", "pe"));
	}
	//On v�rifie que la fonction nbMateriel renvoie bien 2
	@Test
	public void testGetNb() {
		Assert.assertEquals("Erreur r�cup taille",2,M_gsbMat.getNbMateriel());
	}
	//On v�rifie que le toString renvoie bien la bonne chaine de caract�res
	@Test
	public void testToString() {
		Vehicule unVehicule = new Vehicule(1,"AB-123-BA","Renault", "Trafic",5);
		String rep = "";
		rep = "Id : 1 Immat : AB-123-BA Modele : Renault Marque : Trafic Nb Places : 5";
		Assert.assertEquals("Erreur toString", rep, unVehicule.toString());
	}
}
