package gsbMat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gsbMat.Modele.M_gsbMat;

class testGsbMat {

	@Test
	//On v�rifie que l'insertion ne fonctionne pas quand la cl� primaire est d�j� utilis�
	public void testAjout() {
		Assert.assertFalse("Erreur insert", M_gsbMat.addMateriel(15, "Portable", 10.02, 10.02,"Portable"));

	}
}
