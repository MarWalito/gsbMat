package gsbMat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gsbMat.Modele.M_gsbMat;

class testGsbMat {

	@Test
	//On vérifie que l'insertion ne fonctionne pas quand la clé primaire est déjà utilisé
	public void testAjout() {
		Assert.assertFalse("Erreur insert", M_gsbMat.addMateriel(15, "Portable", 10.02, 10.02,"Portable"));

	}
}
