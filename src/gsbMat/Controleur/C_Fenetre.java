package gsbMat.Controleur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

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
    //Item des diff?rents menus

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
    private JMenuItem listeReservation;
    private JMenuItem emprunterMateriel;
    private JMenuItem userGestion;
    
    private Pattern p;
    private Matcher m;
    
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

        this.setAlwaysOnTop(true);
        this.getRootPane().setDefaultButton(btnConnexion);
        this.setVisible(true);
    }
    
    class ActionListe implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
            //Panel Appartenant à la partie Responsable
    		if (e.getSource().equals(ajouterMateriel)) {
    		    getContentPane().removeAll();
    		    getContentPane().add(new AjouterMaterielRS().getMonPanelGlobal());
    		    getContentPane().revalidate();
    		    getContentPane().repaint();
    		} else if (e.getSource().equals(supprimerMateriel)) {
    		    getContentPane().removeAll();
    		    getContentPane().add(new SuppressionMaterielRS().getMonPanelGlobal());
    		    getContentPane().revalidate();
    		    getContentPane().repaint();
    		} else if (e.getSource().equals(afficherMateriel)) {
    		    getContentPane().removeAll();
    		    getContentPane().add(new AfficherMateriel(M_gsbMat.recupCtnTblMateriel()).getMonPanelGlobal());
    		    getContentPane().revalidate();
    		    getContentPane().repaint();
    		} else if (e.getSource().equals(rechercherMateriel)) {
                getContentPane().removeAll();
                getContentPane().add(new RechercherMateriel().getMonPanelGlobal());
                getContentPane().revalidate();
                getContentPane().repaint();
            } else if (e.getSource().equals(ajouterVehicule)) {
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
            }
    		/* else if (e.getSource().equals(listeReservation)) {
                getContentPane().removeAll();
                getContentPane().add(new AfficherListeMaterielV().getMonPanelGlobal());
                getContentPane().revalidate();
                getContentPane().repaint();
            }
            */
    	}
    }
    public void actionPerformed ( ActionEvent evenement) {
        if(evenement.getSource() == btnConnexion) {
            String login = jtfLogin.getText();
            String password = jtfPassword.getText();
            String newLine = System.getProperty("line.separator");	
            JTextArea result = new JTextArea ("Erreur --> Connexion");
            if(M_gsbMat.connexion(login,password)) {
                String type = M_gsbMat.getType();	
                if (type.equals("S")) {
                	result = new JTextArea ("Bienvenue Responsable de service " + newLine + "Votre Login : " +  login); 
                	affichageMenuResponsable();
                    panelConnexion.remove(btnConnexion);
                }
            	if (type.equals("D")) {
            		result = new JTextArea ("Bienvenue Directeur " + newLine + "Votre Login : " +  login); 
            		affichageMenuDirecteur();
                    panelConnexion.remove(btnConnexion);
            	}
        		if (type.equals("V")) {
        			result = new JTextArea ("Bienvenue Visiteur " + newLine + "Votre Login : " +  login); 
            		affichageMenuVisiteur();
                    panelConnexion.remove(btnConnexion);
        		}
            }
            panelConnexion.removeAll();
            panelConnexion.add(result);
            panelConnexion.revalidate();
            panelConnexion.repaint(); 
        }
    }
    public void affichageMenuResponsable() {
	    // Cr?ation de la barre de menu
	    JMenuBar menu = new JMenuBar();

	    // Cr?ation des diff?rents menus
	    JMenu menuRes = new JMenu("Menu Matériel");
	    JMenu menuVeh = new JMenu("Menu Véhicule");
	    JMenu menuUser = new JMenu("Menu User");
	
	
	    // Cr?ation d'?l?ment des menus
	    this.ajouterMateriel = new JMenuItem("Ajouter Materiel");
	    this.afficherMateriel = new JMenuItem("Afficher Materiel");
	    this.rechercherMateriel = new JMenuItem("Rechercher Materiel");
	    this.supprimerMateriel = new JMenuItem("Supprimer Materiel");
	    
	    this.ajouterVehicule = new JMenuItem("Ajouter véhicule");
	    this.afficherVehicule = new JMenuItem("Afficher véhicule");
	    this.rechercherVehicule = new JMenuItem("Rechercher véhicule");
	    this.supprimerVehicule = new JMenuItem("Supprimer véhicule");
	    
        this.btnDeconnexion = new JMenuItem("Deconnexion");
        this.userGestion = new JMenuItem("Gestion User");
	
	    // Ajout de l'?l?ment au menu 
	    menuRes.add(ajouterMateriel);
	    menuRes.add(afficherMateriel);
	    menuRes.add(rechercherMateriel);
	    menuRes.add(supprimerMateriel);
	    
	    menuVeh.add(ajouterVehicule);
	    menuVeh.add(afficherVehicule);
	    menuVeh.add(rechercherVehicule);
	    menuVeh.add(supprimerVehicule);
	    
        menuRes.add(btnDeconnexion);
        menuUser.add(userGestion);
	    
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
	    menu.add(menuUser);
	    // Permet de d?finir le menu utilis? dans la JFrame
	    this.setJMenuBar(menu);
    }
    public void affichageMenuDirecteur() {
        // Cr?ation de la barre de menu
        JMenuBar menu = new JMenuBar();

        // Cr?ation des diff?rents menus
        JMenu menuRes = new JMenu("Menu Directeur");
        JMenu menuUser = new JMenu("Menu User");


        // Cr?ation d'?l?ment des menus
        this.ajouterMateriel = new JMenuItem("***");
        this.afficherMateriel = new JMenuItem("***");
        this.rechercherMateriel = new JMenuItem("***");
        this.supprimerMateriel = new JMenuItem("***");
        this.btnDeconnexion = new JMenuItem("Déconnexion");


        this.userGestion = new JMenuItem("Gestion User");

        // Ajout de l'?l?ment au menu 
        menuRes.add(ajouterMateriel);
        menuRes.add(afficherMateriel);
        menuRes.add(rechercherMateriel);
        menuRes.add(supprimerMateriel);
        menuRes.add(btnDeconnexion);
        menuUser.add(userGestion);

        // Ajout du menu dans la barre de menu
        menu.add(menuRes);
        menu.add(menuUser);
        // Permet de d?finir le menu utilis? dans la JFrame
        this.setJMenuBar(menu);
    }	
    public void affichageMenuVisiteur() {
        // Cr?ation de la barre de menu
        JMenuBar menu = new JMenuBar();

        // Cr?ation des diff?rents menus
        JMenu menuRes = new JMenu("Menu Visiteur");
        JMenu menuUser = new JMenu("Menu User");


        // Cr?ation d'?l?ment des menus
        this.listeReservation = new JMenuItem("Voir les réservations");
        this.rechercherMateriel = new JMenuItem("Rechercher du Materiel");
        this.emprunterMateriel = new JMenuItem("Emprunter Materiel");
        
        this.userGestion = new JMenuItem("Gestion User");

        // Ajout de l'él?ment au menu
        menuRes.add(listeReservation);
        menuRes.add(rechercherMateriel);
        menuRes.add(emprunterMateriel);
        menuUser.add(userGestion);

        //on ecoute les items du menu


        // Ajout du menu dans la barre de menu
        menu.add(menuRes);
        menu.add(menuUser);
        // Permet de d?finir le menu utilis? dans la JFrame
        this.setJMenuBar(menu);
    }
}