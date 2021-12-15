package gsbMat.Controleur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

import VueDirecteur.AfficherStatsD;
import VueDirecteur.AfficherStatsDir;
import VueResponsable.AfficherMateriel;
import VueResponsable.AfficherVehicule;
import VueResponsable.AjouterMaterielRS;
import VueResponsable.AjouterVehiculeRS;
import VueResponsable.RechercherMateriel;
import VueResponsable.RechercherVehicule;
import VueResponsable.SuppressionMaterielRS;
import VueResponsable.SuppressionVehiculeRS;
import VueVisiteur.AfficherEmpruntMatV;
import VueVisiteur.AfficherEmpruntVehV;
import VueVisiteur.AjouterEmpruntMatV;
import VueVisiteur.AjouterEmpruntVehV;
import VueVisiteur.SuppressionEmpruntMatV;
import VueVisiteur.SuppressionEmpruntVehV;
import gsbMat.*;
import gsbMat.Modele.M_gsbMat;

import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class C_Fenetre extends JFrame implements ActionListener{
    //Panel
    private JPanel panelConnexion;
    private JPanel panelButton;
    //Label
    private JLabel lblLogin;
    private JLabel lblPassword;
    //Jtf
    private JTextField jtfLogin;
    private JPasswordField jtfPassword;
    //Button
    private JButton btnConnexion;
    //Barre de menu
    private JMenuBar menu;
    private JMenuBar menuVis;
    //Item des différents menus

    //Pour la partie Responsable
    private JMenuItem ajouterMateriel;
    private JMenuItem supprimerMateriel;
    private JMenuItem afficherMateriel;
    private JMenuItem rechercherMateriel;
    private JMenuItem btnDeconnexion;
    
    private JMenuItem ajouterVehicule;
    private JMenuItem supprimerVehicule;
    private JMenuItem afficherVehicule;
    private JMenuItem rechercherVehicule;

    //Pour la partie Visiteur
    private JMenuItem emprunterMateriel;
    private JMenuItem emprunterVehicule;
    private JMenuItem suppressionEmpruntMat;
    private JMenuItem suppressionEmpruntVeh;
    private JMenuItem affichageEmpruntMat;
    private JMenuItem affichageEmpruntVeh;

    //Pour la partie Directeur
    private JMenuItem affichageStats;
    private JMenuItem affichageStatsDir;
    
    //Autres attributs
    private Pattern p;
    private Matcher m;
    private String unlogin;    
    
    public C_Fenetre() {
    	this.setTitle("GSB Mat");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 700);
        this.setResizable(true);
        
        //Panel
        panelConnexion = new JPanel();
        panelButton = new JPanel();
        this.panelConnexion.setBackground(Color.pink);
        this.panelButton.setBackground(Color.pink);
        
        //Label et Jtf
        lblLogin = new JLabel("Votre Login : ");
        lblPassword = new JLabel("Votre Mot de passe : ");
        
        jtfLogin = new JTextField("");
        jtfPassword = new JPasswordField ("");

        //Dimension et couleur des champs
        jtfLogin.setPreferredSize(new Dimension(150, 30));
        this.jtfLogin.setBackground(Color.pink);
        jtfPassword.setPreferredSize(new Dimension(150, 30));
        this.jtfPassword.setBackground(Color.pink);
        
        //Ajouts des labels et jtf dans le panels
        panelConnexion.add(lblLogin);
        panelConnexion.add(jtfLogin);
        panelConnexion.add(lblPassword);
        panelConnexion.add(jtfPassword);
        
        //button
        btnConnexion = new JButton ("Valider");
        btnConnexion.addActionListener(this);
        panelButton.add(btnConnexion);
        this.getContentPane().add(panelConnexion, BorderLayout.NORTH);
        this.getContentPane().add(panelButton, BorderLayout.SOUTH);
        
        ImageIcon imgTP = new ImageIcon("./src/gsbMat/gsb.png");
        JLabel imageTP = new JLabel(imgTP, JLabel.CENTER);
        imageTP.setIcon(imgTP);
        this.getContentPane().add(imageTP);

        this.getRootPane().setDefaultButton(btnConnexion);
        this.setVisible(true);
    }
    
    class ActionListe implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(btnDeconnexion)) {
                dispose();
                getContentPane().add(new C_Fenetre());
                getContentPane().revalidate();
                getContentPane().repaint();
            }else if (e.getSource().equals(ajouterMateriel)) {
    		    getContentPane().removeAll();
    		    getContentPane().add(new AjouterMaterielRS().getMonPanelGlobal());
    		    getContentPane().revalidate();
    		    getContentPane().repaint();
    		}else if (e.getSource().equals(supprimerMateriel)) {
    		    getContentPane().removeAll();
    		    getContentPane().add(new SuppressionMaterielRS().getMonPanelGlobal());
    		    getContentPane().revalidate();
    		    getContentPane().repaint();
    		}else if (e.getSource().equals(afficherMateriel)) {
    		    getContentPane().removeAll();
    		    getContentPane().add(new AfficherMateriel(M_gsbMat.recupCtnTblMateriel()).getMonPanelGlobal());
    		    getContentPane().revalidate();
    		    getContentPane().repaint();
    		}else if (e.getSource().equals(rechercherMateriel)) {
                getContentPane().removeAll();
                getContentPane().add(new RechercherMateriel().getMonPanelGlobal());
                getContentPane().revalidate();
                getContentPane().repaint();
            }else if (e.getSource().equals(ajouterVehicule)) {
                 getContentPane().removeAll();
                 getContentPane().add(new AjouterVehiculeRS().getMonPanelGlobal());
                 getContentPane().revalidate();
                 getContentPane().repaint();
            }else if (e.getSource().equals(supprimerVehicule)) {
                getContentPane().removeAll();
                getContentPane().add(new SuppressionVehiculeRS().getMonPanelGlobal());
                getContentPane().revalidate();
                getContentPane().repaint();
            }else if (e.getSource().equals(afficherVehicule)) {
                getContentPane().removeAll();
                getContentPane().add(new AfficherVehicule(M_gsbMat.recupCtnTblVehicule()).getMonPanelGlobal());
                getContentPane().revalidate();
                getContentPane().repaint();
            }else if (e.getSource().equals(rechercherVehicule)) {
                getContentPane().removeAll();
                getContentPane().add(new RechercherVehicule().getMonPanelGlobal());
                getContentPane().revalidate();
                getContentPane().repaint();
            }else if (e.getSource().equals(emprunterMateriel)) {
                getContentPane().removeAll();
                getContentPane().add(new AjouterEmpruntMatV(unlogin).getMonPanelGlobal());
                getContentPane().revalidate();
                getContentPane().repaint();
            }else if (e.getSource().equals(affichageEmpruntMat)) {
            	int idVis = M_gsbMat.rcpIdVis(unlogin);
                getContentPane().removeAll();
                getContentPane().add(new AfficherEmpruntMatV(M_gsbMat.recupCtnTblEmpruntMat(idVis)).getMonPanelGlobal());
                getContentPane().revalidate();
                getContentPane().repaint();
            }else if (e.getSource().equals(affichageEmpruntVeh)) {
            	int idVis = M_gsbMat.rcpIdVis(unlogin);
                getContentPane().removeAll();
                getContentPane().add(new AfficherEmpruntVehV(M_gsbMat.recupCtnTblEmpruntVeh(idVis)).getMonPanelGlobal());
                getContentPane().revalidate();
                getContentPane().repaint();
            }else if (e.getSource().equals(affichageStats)) {
                getContentPane().removeAll();
                getContentPane().add(new AfficherStatsD(M_gsbMat.recupCtnTblStats()).getMonPanelGlobal());
                getContentPane().revalidate();
                getContentPane().repaint();
            }else if (e.getSource().equals(emprunterVehicule)) {
                getContentPane().removeAll();
                getContentPane().add(new AjouterEmpruntVehV(unlogin).getMonPanelGlobal());
                getContentPane().revalidate();
                getContentPane().repaint();
            }else if (e.getSource().equals(affichageStatsDir)) {
                getContentPane().removeAll();
                getContentPane().add(new AfficherStatsDir(M_gsbMat.recupCtnTblStatsEmprunt()).getMonPanelGlobal());
                getContentPane().revalidate();
                getContentPane().repaint();
            }else if (e.getSource().equals(suppressionEmpruntMat)) {
                getContentPane().removeAll();
                getContentPane().add(new SuppressionEmpruntMatV(unlogin).getMonPanelGlobal());
                getContentPane().revalidate();
                getContentPane().repaint();
            }
            else if (e.getSource().equals(suppressionEmpruntVeh)) {
                getContentPane().removeAll();
                getContentPane().add(new SuppressionEmpruntVehV(unlogin).getMonPanelGlobal());
                getContentPane().revalidate();
                getContentPane().repaint();
            }
    	}
    }
    public void actionPerformed ( ActionEvent evenement) {
    	//On vérifie l'appelle du bouton connexion
        if(evenement.getSource() == btnConnexion) {
        	//On récupère le login et le password saisis
            String login = jtfLogin.getText();
            String password = jtfPassword.getText();
            String newLine = System.getProperty("line.separator");	
            JTextArea result = new JTextArea ("Erreur --> Connexion");
            //On vérifie que la connexion fonctionne
            if(M_gsbMat.connexion(login,password)) {
            	//On récupère le type de l'user
                String type = M_gsbMat.getType();
                //Si c'est un responsable on appelle le menu responsable
                if (type.equals("S")) {
                	result = new JTextArea ("Bienvenue Responsable de service " + newLine + "Votre Login : " +  login); 
                	affichageMenuResponsable();
                    panelConnexion.remove(panelButton);
                }
                //Si c'est un directeur on appelle le menu directeur
            	if (type.equals("D")) {
            		result = new JTextArea ("Bienvenue Directeur " + newLine + "Votre Login : " +  login); 
            		affichageMenuDirecteur();
                    panelConnexion.remove(panelButton);
            	}
            	//Si c'est un visiteur on appelle le menu visiteur
        		if (type.equals("V")) {
        			//On récupère le login saisie pour faire des variables de "session"
        			this.unlogin = login;
        			result = new JTextArea ("Bienvenue Visiteur " + newLine + "Votre Login : " +  login); 
            		affichageMenuVisiteur();
                    panelConnexion.remove(panelButton);
        		}
            }
            panelConnexion.removeAll();
            panelConnexion.add(result);
            panelConnexion.revalidate();
            panelConnexion.repaint(); 
        }
    }
    public void affichageMenuResponsable() {
	    // Création de la barre de menu
	    JMenuBar menu = new JMenuBar();

	    // Création des différents menus
	    JMenu menuRes = new JMenu("Menu Matériel");
	    JMenu menuVeh = new JMenu("Menu Véhicule");
	
	
	    // Cr?ation d'?l?ment des menus
	    this.ajouterMateriel = new JMenuItem("Ajouter Materiel");
	    this.afficherMateriel = new JMenuItem("Afficher Materiel");
	    this.rechercherMateriel = new JMenuItem("Rechercher Materiel");
	    this.supprimerMateriel = new JMenuItem("Supprimer Materiel");
	    
	    this.ajouterVehicule = new JMenuItem("Ajouter véhicule");
	    this.afficherVehicule = new JMenuItem("Afficher véhicule");
	    this.rechercherVehicule = new JMenuItem("Rechercher véhicule");
	    this.supprimerVehicule = new JMenuItem("Supprimer véhicule");
	
	    // Ajout de l'élément au menu 
	    menuRes.add(ajouterMateriel);
	    menuRes.add(afficherMateriel);
	    menuRes.add(rechercherMateriel);
	    menuRes.add(supprimerMateriel);
	    
	    menuVeh.add(ajouterVehicule);
	    menuVeh.add(afficherVehicule);
	    menuVeh.add(rechercherVehicule);
	    menuVeh.add(supprimerVehicule);
	    
	    //on ecoute les items du menu
	    this.ajouterMateriel.addActionListener(new ActionListe ());
	    this.supprimerMateriel.addActionListener(new ActionListe ());
	    this.afficherMateriel.addActionListener(new ActionListe ());
	    this.rechercherMateriel.addActionListener(new ActionListe ());


	    this.ajouterVehicule.addActionListener(new ActionListe ());
	    this.afficherVehicule.addActionListener(new ActionListe ());
	    this.rechercherVehicule.addActionListener(new ActionListe ());
	    this.supprimerVehicule.addActionListener(new ActionListe ());


        // Ajout du menu dans la barre de menu
	    menu.add(menuRes);
	    menu.add(menuVeh);

	    // Permet de d?finir le menu utilisé dans la JFrame
	    this.setJMenuBar(menu);
    }
    public void affichageMenuDirecteur() {
        // Cr?ation de la barre de menu
        this.menu = new JMenuBar();
        //this.menu.setBackground(new Color(47,53,66));

        // Cr?ation des différents menus
        JMenu menuRes = new JMenu("Menu Directeur");

        // Cr?ation d'?l?ment des menus
        this.affichageStats = new JMenuItem("Affichage des statistiques N°1");
        this.affichageStatsDir = new JMenuItem("Affichage des statistiques N°2");
        this.btnDeconnexion = new JMenuItem("Déconnexion");
        // Ajout de l'élément au menu
        menuRes.add(affichageStats);
        menuRes.add(affichageStatsDir);

        //on ecoute les items du menu
        this.affichageStats.addActionListener(new ActionListe ());
        this.affichageStatsDir.addActionListener(new ActionListe ());

        // Ajout du menu dans la barre de menu
        menu.add(menuRes);
        // Permet de définir le menu utilisé dans la JFrame
        this.setJMenuBar(menu);
    }	
    public void affichageMenuVisiteur() {
        // Cr?ation de la barre de menu
        JMenuBar menuVis = new JMenuBar();

        // Cr?ation des diff?rents menus
        JMenu menuVisi = new JMenu("Menu Visiteur");


        // Cr?ation d'?l?ment des menus
        this.affichageEmpruntMat = new JMenuItem("Voir les réservations matériel");
        this.affichageEmpruntVeh = new JMenuItem("Voir les réservations véhicule");
        this.emprunterMateriel = new JMenuItem("Emprunter Materiel");
        this.emprunterVehicule = new JMenuItem("Emprunter Véhicule");
        this.suppressionEmpruntMat = new JMenuItem("Supprimer emprunt matériel");
        this.suppressionEmpruntVeh = new JMenuItem("Supprimer emprunt véhicule");

        // Ajout de l'él?ment au menu
        menuVisi.add(affichageEmpruntMat);
        menuVisi.add(affichageEmpruntVeh);
        menuVisi.add(emprunterMateriel);
        menuVisi.add(emprunterVehicule);
        menuVisi.add(suppressionEmpruntMat);
        menuVisi.add(suppressionEmpruntVeh);

        //on ecoute les items du menu
        this.affichageEmpruntMat.addActionListener(new ActionListe());
        this.affichageEmpruntVeh.addActionListener(new ActionListe());
        this.emprunterMateriel.addActionListener(new ActionListe ());
        this.emprunterVehicule.addActionListener(new ActionListe ());
        this.suppressionEmpruntMat.addActionListener(new ActionListe ());
        this.suppressionEmpruntVeh.addActionListener(new ActionListe ());

        // Ajout du menu dans la barre de menu
        menuVis.add(menuVisi);
        // Permet de d?finir le menu utilis? dans la JFrame
        this.setJMenuBar(menuVis);
    }
}