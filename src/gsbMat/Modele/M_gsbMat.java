package gsbMat.Modele;

/**
 * 
 * Modï¿½le pour la BDD
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import gsbMat.Materiel;
import gsbMat.Stats;
import gsbMat.Vehicule;

public class M_gsbMat {
	
	private static Connection connexion;
	private static Statement st;
	private static ResultSet rs;
	private static int count; 
	private static PreparedStatement pst;
	private static Pattern p;
    private static Matcher m;
    private static String user;
	
	/**
	 * Mï¿½thode static pour la connexion
	 */
	public static void connexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://172.16.203.202/gsbMat?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "sio", "slam");
			st = connexion.createStatement();
		} catch (ClassNotFoundException erreur ) {
			// TODO Auto-generated catch block
			System.out.println("Driver --> Pas la " + erreur);
		} catch (SQLException erreur) {
			System.out.println("Connexion --> Echouï¿½e " + erreur);
		}
	}
	/**
	 * Mï¿½thode static pour la dï¿½connexion
	 */
	public static void deconnexion() {

		try {
			connexion.close();
		} catch (SQLException erreur) {
			// TODO Auto-generated catch block
			System.out.println("Dï¿½connexion --> Pas la " + erreur);
		}
	}

	public static boolean connexion(String unLogin, String unMdp) {
		M_gsbMat.connexion();
		boolean rep; 
		int nbLogin;
		rep = false;
		nbLogin = 0;
		try {
			//Requï¿½te prï¿½parï¿½
			pst = connexion.prepareStatement( "SELECT COUNT(*) AS nbLogin, typeUtilisateur FROM Visiteur WHERE login = ? AND mdp = sha1(?) ;");
			pst.setString(1, unLogin);
			pst.setString(2, unMdp);
			rs = pst.executeQuery();
			while(rs.next()) {
				//On rï¿½cupï¿½re la valeur du count
				nbLogin = rs.getInt("nbLogin");
				M_gsbMat.user = rs.getString("typeUtilisateur");
			}
			rs.close();
			//Si nbLogin = 1 alors on met rep = true pour pouvoir se connecter
			if (nbLogin == 1) {
				rep = true;
			}
		} catch (SQLException erreur) {
			// TODO Auto-generated catch block
			System.out.println("Erreur --> Requï¿½te rï¿½cupï¿½ration " + erreur);
		}
		return rep;
	}
	
	public static String getType() {
		return M_gsbMat.user;
	}
	
	public static boolean modifPassword(String unMdpActuel, String unNouveauMdp) {
		M_gsbMat.connexion();
		boolean rep; 
		int nbLogin;
		rep = false;
		nbLogin = 0;
		try {
			//Requï¿½te prï¿½parï¿½
			pst = connexion.prepareStatement( "UPDATE User SET password = sha1(?) WHERE password = sha1(?)");
			pst.setString(1, unNouveauMdp);
			pst.setString(2, unMdpActuel);
			count = pst.executeUpdate();
			//Si nbLogin = 1 alors on met rep = true pour pouvoir se connecter
			if (count == 1) {
				rep = true;
			}
		} catch (SQLException erreur) {
			// TODO Auto-generated catch block
			System.out.println("Erreur --> Requï¿½te rï¿½cupï¿½ration " + erreur);
		}
		return rep;
	}
	// ========== PARTIE MATERIEL ==========
	public static boolean addMateriel(int unId, String unLibelle, double uneLargeur, double uneLongeur, String unType) {
		M_gsbMat.connexion();
		boolean rep; 
		int nbLogin;
		rep = false;
		nbLogin = 0;
		try {
			//Requï¿½te prï¿½parï¿½
			pst = connexion.prepareStatement( "INSERT INTO Materiel VALUES (?,?,?,?,?);");
			pst.setInt(1, unId);
			pst.setString(2, unLibelle);
			pst.setDouble(3, uneLargeur);
			pst.setDouble(4, uneLongeur);
			pst.setString(5, unType);
			count = pst.executeUpdate();
			//Si nbLogin = 1 alors on met rep = true pour pouvoir se connecter
			if (count == 1) {
				rep = true;
			}
		} catch (SQLException erreur) {
			// TODO Auto-generated catch block
			System.out.println("Erreur --> Requï¿½te insertion Materiel " + erreur);
			erreur.printStackTrace();
		}
		return rep;
	}
	
	public static boolean deleteMateriel (String unType) {
		M_gsbMat.connexion();
		boolean rep; 
		int nbLogin;
		rep = false;
		nbLogin = 0;
		int id = rcpIdMat(unType);
		try {
			//Requï¿½te prï¿½parï¿½
			pst = connexion.prepareStatement( "DELETE FROM Materiel WHERE libelle = ?");
			pst.setString(1, unType);
			count += pst.executeUpdate();
			
			pst = connexion.prepareStatement( "DELETE FROM empruntMat WHERE idMateriel = ?");
			pst.setInt(1, id);
			count += pst.executeUpdate();
			//Si nbLogin = 1 alors on met rep = true pour pouvoir se connecter
			if (count == 2) {
				rep = true;
			}
		} catch (SQLException erreur) {
			// TODO Auto-generated catch block
			System.out.println("Erreur --> Requï¿½te suppression materiel " + erreur);
			erreur.printStackTrace();
		}
		return rep;
	}
	
	public static ArrayList<String> recupListeMateriel() {
        M_gsbMat.connexion();
        ArrayList<String> liste = new ArrayList<String>();
        try {
            rs = st.executeQuery("SELECT libelle FROM Materiel;") ;
            String libelle;
            while(rs.next()) {
            	libelle = rs.getString("libelle");
                liste.add(libelle);
            }
            rs.close();
        } catch (SQLException erreur) {
            System.out.println("Erreur --> recupï¿½ration du matï¿½riel");
            erreur.printStackTrace();
        }
        return liste;
    }
	
	public static int getNbMateriel() {
		M_gsbMat.connexion();
        int rep = 0;
        try {
            rs = st.executeQuery("SELECT COUNT(*) AS nb FROM Materiel;") ;
            while(rs.next()) {
                rep = rs.getInt("nb");
            }
            rs.close();
        } catch (SQLException erreur) {
            System.out.println("Erreur --> recupï¿½ration du nombre de matï¿½riel");
            erreur.printStackTrace();
        }
        return rep;
    }
	
	public static ArrayList<Materiel> recupCtnTblMateriel() {
		M_gsbMat.connexion();
		ArrayList<Materiel> lesMateriels;
		lesMateriels = new ArrayList<Materiel>();
		String req;
		int id;
		String libelle, type;
		double largeur, longueur;
		try {
			req = "SELECT * FROM Materiel;";
			rs = st.executeQuery(req);
			while (rs.next()) {
				id = rs.getInt("id");
				libelle = rs.getString("libelle");
				largeur = rs.getDouble("largeur");
				longueur = rs.getDouble("longueur");
				type = rs.getString("type");
				lesMateriels.add(new Materiel(id, libelle, largeur, longueur, type));
			}
			rs.close() ;
		} catch (SQLException erreur) {
			// TODO Auto-generated catch block
			System.out.println("Erreur --> Requï¿½te Recup ctn table " + erreur);
			erreur.printStackTrace();
		}
		return lesMateriels;
	}
	
	public static boolean searchMateriel(String unLibelle) {
		M_gsbMat.connexion();
		boolean rep = false;
		int count = 0;
		try {
			pst = connexion.prepareStatement( "SELECT COUNT(*) AS nb FROM materiel WHERE libelle = ?;");
			pst.setString(1, unLibelle);
			rs = pst.executeQuery();
			while(rs.next()) {
				count = rs.getInt("nb");
			}
			rs.close();
			if(count != 0) {
				rep = true;
			}
		} catch (SQLException erreur) {
			System.out.println("Erreur lors de la recherche de la course");
			erreur.printStackTrace();
		}
		return rep;
	}
	public static String getInfoMateriel(String unLibelle) {
		M_gsbMat.connexion();
		String rep = "";
		int id;
		Materiel unMateriel = null;
		String libelle, type;
		double largeur, longueur;
		try {
			pst = connexion.prepareStatement( "SELECT * FROM materiel WHERE libelle = ?;");
			pst.setString(1, unLibelle);
			rs = pst.executeQuery();
			while(rs.next()) {
				id = rs.getInt("id");
				libelle = rs.getString("libelle");
				largeur = rs.getDouble("largeur");
				longueur = rs.getDouble("longueur");
				type = rs.getString("type");
				unMateriel = new Materiel(id, libelle, largeur, longueur, type);
			}
			rs.close();
			rep = unMateriel.toXML();
		} catch (SQLException erreur) {
			System.out.println("Erreur --> recupï¿½ration des infos de la course");
			erreur.printStackTrace();
		}
		return rep;
	}
	// ========== PARTIE MATERIEL ==========
	
	// ========== PARTIE VEHICULE ==========
	public static boolean addVehicule(int unId, String uneImmat, String unModele, String uneMarque, int unNbPlaces) {
		M_gsbMat.connexion();
		boolean rep; 
		int nbLogin;
		rep = false;
		nbLogin = 0;
		try {
			//Requï¿½te prï¿½parï¿½
			pst = connexion.prepareStatement( "INSERT INTO Vehicule VALUES (?,?,?,?,?);");
			pst.setInt(1, unId);
			pst.setString(2, uneImmat);
			pst.setString(3, unModele);
			pst.setString(4, uneMarque);
			pst.setInt(5, unNbPlaces);
			count = pst.executeUpdate();
			//Si nbLogin = 1 alors on met rep = true pour pouvoir se connecter
			if (count == 1) {
				rep = true;
			}
		} catch (SQLException erreur) {
			// TODO Auto-generated catch block
			System.out.println("Erreur --> Requï¿½te insertion véhicule " + erreur);
			erreur.printStackTrace();
		}
		return rep;
	}
	
	public static boolean deleteVehicule (String uneImmat) {
		M_gsbMat.connexion();
		boolean rep; 
		int nbLogin;
		rep = false;
		nbLogin = 0;
		try {
			//Requï¿½te prï¿½parï¿½
			pst = connexion.prepareStatement( "DELETE FROM Vehicule WHERE immat = ?");
			pst.setString(1, uneImmat);
			count = pst.executeUpdate();
			//Si nbLogin = 1 alors on met rep = true pour pouvoir se connecter
			if (count == 1) {
				rep = true;
			}
		} catch (SQLException erreur) {
			// TODO Auto-generated catch block
			System.out.println("Erreur --> Requï¿½te suppression materiel " + erreur);
			erreur.printStackTrace();
		}
		return rep;
	}
	
	public static ArrayList<String> recupListeVehicule() {
        M_gsbMat.connexion();
        ArrayList<String> liste = new ArrayList<String>();
        try {
            rs = st.executeQuery("SELECT immat FROM Vehicule;") ;
            String immat;
            while(rs.next()) {
            	immat = rs.getString("immat");
                liste.add(immat);
            }
            rs.close();
        } catch (SQLException erreur) {
            System.out.println("Erreur --> recupï¿½ration du matï¿½riel");
            erreur.printStackTrace();
        }
        return liste;
    }
	
	public static ArrayList<String> recupListeModeleVehicule() {
        M_gsbMat.connexion();
        ArrayList<String> liste = new ArrayList<String>();
        try {
            rs = st.executeQuery("SELECT modele FROM Vehicule;") ;
            String modele;
            while(rs.next()) {
            	modele = rs.getString("modele");
                liste.add(modele);
            }
            rs.close();
        } catch (SQLException erreur) {
            System.out.println("Erreur --> recupï¿½ration du matï¿½riel");
            erreur.printStackTrace();
        }
        return liste;
    }
	
	public static int getNbVehicule() {
		M_gsbMat.connexion();
        int rep = 0;
        try {
            rs = st.executeQuery("SELECT COUNT(*) AS nb FROM Vehicule;") ;
            while(rs.next()) {
                rep = rs.getInt("nb");
            }
            rs.close();
        } catch (SQLException erreur) {
            System.out.println("Erreur --> recupï¿½ration du nombre de matï¿½riel");
            erreur.printStackTrace();
        }
        return rep;
    }
	
	public static ArrayList<Vehicule> recupCtnTblVehicule() {
		M_gsbMat.connexion();
		ArrayList<Vehicule> lesVehicules;
		lesVehicules = new ArrayList<Vehicule>();
		String req;
		int id, nbPlaces;
		String immat, type, marque, modele;
		try {
			req = "SELECT * FROM Vehicule;";
			rs = st.executeQuery(req);
			while (rs.next()) {
				id = rs.getInt("id");
				immat = rs.getString("immat");
				modele = rs.getString("modele");
				marque = rs.getString("marque");
				nbPlaces = rs.getInt("nbPlaces");
				lesVehicules.add(new Vehicule(id, immat, modele, marque, nbPlaces));
			}
			rs.close() ;
		} catch (SQLException erreur) {
			// TODO Auto-generated catch block
			System.out.println("Erreur --> Requï¿½te Recup ctn table " + erreur);
			erreur.printStackTrace();
		}
		return lesVehicules;
	}
	
	public static boolean searchVehicule(String uneImmat) {
		M_gsbMat.connexion();
		boolean rep = false;
		int count = 0;
		try {
			pst = connexion.prepareStatement( "SELECT COUNT(*) AS nb FROM Vehicule WHERE immat = ?;");
			pst.setString(1, uneImmat);
			rs = pst.executeQuery();
			while(rs.next()) {
				count = rs.getInt("nb");
			}
			rs.close();
			if(count != 0) {
				rep = true;
			}
		} catch (SQLException erreur) {
			System.out.println("Erreur lors de la recherche de la course");
			erreur.printStackTrace();
		}
		return rep;
	}
	public static String getInfoVehicule(String uneImmat) {
		M_gsbMat.connexion();
		String rep = "";
		int id, nbPlaces;
		String immat, type, marque, modele;
		Vehicule unVehicule = null;
		try {
			pst = connexion.prepareStatement( "SELECT * FROM Vehicule WHERE immat = ?;");
			pst.setString(1, uneImmat);
			rs = pst.executeQuery();
			while(rs.next()) {
				id = rs.getInt("id");
				immat = rs.getString("immat");
				modele = rs.getString("modele");
				marque = rs.getString("marque");
				nbPlaces = rs.getInt("nbPlaces");
				unVehicule = new Vehicule(id, immat, modele, marque, nbPlaces);
			}
			rs.close();
			rep = unVehicule.toString();
		} catch (SQLException erreur) {
			System.out.println("Erreur --> recupï¿½ration des infos de la course");
			erreur.printStackTrace();
		}
		return rep;
	}
	// ========== PARTIE VEHICULE ==========
	
	// ========== PARTIE EMPRUNT ==========
		public static int rcpIdMat(String unNomMateriel) {
			M_gsbMat.connexion();
			int idMat = 0;
			try {
				pst = connexion.prepareStatement("SELECT id FROM Materiel WHERE libelle = ? ;") ;
				pst.setString(1, unNomMateriel);
				rs = pst.executeQuery();
				while (rs.next()) {
					idMat = rs.getInt("id");
				}
	            rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Erreur dans la recuperation de l'id materiel via le nom");
				e.printStackTrace();
			}
			return idMat;
		}
		
		public static int rcpIdVis(String unLogin) {
			M_gsbMat.connexion();
			int idMat = 0;
			try {
				pst = connexion.prepareStatement("SELECT id FROM Visiteur WHERE login = ? ;") ;
				pst.setString(1, unLogin);
				rs = pst.executeQuery();
				while (rs.next()) {
					idMat = rs.getInt("id");
				}
	            rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Erreur dans la recuperation de l'id materiel via le nom");
				e.printStackTrace();
			}
			return idMat;
		}
		
		public static int rcpIdVeh(String unModele) {
			M_gsbMat.connexion();
			int idMat = 0;
			try {
				pst = connexion.prepareStatement("SELECT id FROM Vehicule WHERE modele = ? ;") ;
				pst.setString(1, unModele);
				rs = pst.executeQuery();
				while (rs.next()) {
					idMat = rs.getInt("id");
				}
	            rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Erreur dans la recuperation de l'id materiel via le nom");
				e.printStackTrace();
			}
			return idMat;
		}
		
		public static boolean addEmpruntM(int unIdMateriel, Date uneDateDebut, Date uneDateFin, float uneDuree, int unIdVisiteur) {
			M_gsbMat.connexion();
	        boolean rep = false;
	        int result = 0;
	        try {
	        	pst = connexion.prepareStatement("INSERT INTO empruntMat (idMateriel, dateDebut, dateFin, duree, idVisiteur) VALUES (?,?,?,?,?);");
	        	pst.setInt(1, unIdMateriel);
	        	pst.setDate(2, uneDateDebut);
	        	pst.setDate(3, uneDateFin);
	        	pst.setFloat(4, uneDuree);
	        	pst.setInt(5, unIdVisiteur);
	            result = pst.executeUpdate();
	            if (result == 1) {
	                rep = true;
	            }
	        } catch (SQLException e) {
	            System.out.println("Erreur d'insertion d'un materiel.");
	            e.printStackTrace();
	        }
	        return rep;

	    }
		
		public static boolean addEmpruntV(int unIdVehicule, Date uneDateDebut, Date uneDateFin, float uneDuree, int unIdVisiteur) {
			M_gsbMat.connexion();
	        boolean rep = false;
	        int result = 0;
	        try {
	        	pst = connexion.prepareStatement("INSERT INTO empruntVeh (idVehicule, dateDebut, dateFin, duree, idVisiteur) VALUES (?,?,?,?,?);");
	        	pst.setInt(1, unIdVehicule);
	        	pst.setDate(2, uneDateDebut);
	        	pst.setDate(3, uneDateFin);
	        	pst.setFloat(4, uneDuree);
	        	pst.setInt(5, unIdVisiteur);
	            result = pst.executeUpdate();
	            if (result == 1) {
	                rep = true;
	            }
	        } catch (SQLException e) {
	            System.out.println("Erreur d'insertion d'un materiel.");
	            e.printStackTrace();
	        }
	        return rep;

	    }



		// ========== PARTIE DIRECTEUR STATISTIQUES  ==========

		public static ArrayList<Stats> recupCtnTblStats() {
			M_gsbMat.connexion();
			ArrayList<Stats> lesStats;
			lesStats = new ArrayList<Stats>();
			String req;
			int totalEmprunt;
			String type, login;
			try {
				req = "SELECT count(*) AS totalEmprunt, type, login FROM empruntMat EM, Materiel M, Visiteur V WHERE EM.idMateriel = M.id AND V.id = EM.idVisiteur GROUP BY type;";
				rs = st.executeQuery(req);
				while (rs.next()) {
					totalEmprunt = rs.getInt("totalEmprunt");
					type = rs.getString("type");
					login = rs.getString("login");
					lesStats.add(new Stats(totalEmprunt,type,login));
				}
				rs.close() ;
			} catch (SQLException erreur) {
				// TODO Auto-generated catch block
				System.out.println("Erreur --> Requï¿½te Recup ctn table " + erreur);
				erreur.printStackTrace();
			}
			return lesStats;
		}

	
}
