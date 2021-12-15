package VueVisiteur;
/**
 * @author yohann
 * Fenetre Afficher Circuit permettant l'affichage des circuits dans un tableau.
 */
import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

import gsbMat.EmpruntVeh;

import java.util.ArrayList;

public class AfficherEmpruntVehV extends JPanel{
    
    //Attributs privés
    private JPanel panelTitre;
    private JPanel monPanel;
    private JPanel monPanelGlobal;
    private JLabel lblContenuContacts;
    private JTable tableau;
    private JScrollPane scrollPane;
    //On passe en paramètre une collection afin qu'il puisse afficher les circuits
    public AfficherEmpruntVehV(ArrayList<EmpruntVeh> uneListeEmprunt) {
    	//Declaration des panels, des bordures et des couleurs
        this.panelTitre = new JPanel();
        this.monPanel = new JPanel();
        this.monPanelGlobal = new JPanel();
        this.panelTitre.setLayout(new BorderLayout());
        this.monPanel.setLayout(new BorderLayout());
        this.monPanelGlobal.setLayout(new BorderLayout());
        this.panelTitre.setBackground(Color.pink);
        this.monPanel.setBackground(Color.pink);
        this.monPanelGlobal.setBackground(Color.pink);
        //Définition de la taille
        this.setSize(800, 400);
        //Instanciation du tableau qui va contenir les informations
        Object data[][]= new Object[20][20]; 
        int i = 0; 
        //Boucle foreach permettant le parcours de la collection pour l'affichage.
        for (EmpruntVeh unEmprunt : uneListeEmprunt) {
            data[i][0] = unEmprunt.getIdVehicule();
            data[i][1] = unEmprunt.getDateDebut();
            data[i][2] = unEmprunt.getDateFin();
            data[i][3] = unEmprunt.getDuree();
            
            i++;
        }
        String [] title = {"Id véhicule", "Date Debut", "Date Fin", "Duree"}; 
        //On instancie le tableau
        this.tableau = new JTable(data,title);       
        //On définis la taille du tableau
        this.tableau.setPreferredScrollableViewportSize(new Dimension(450, 400)); 

        // Espacement entre les cases
        this.tableau.setRowHeight(30); 
                        
        // Obligé d'add un JScrollPane         
        this.scrollPane = new JScrollPane(this.tableau);          
        this.monPanel.add(this.scrollPane); 
        //On ajoute le tout au panelglobal qui va permettre les switch de panels.
        this.monPanelGlobal.add(panelTitre, BorderLayout.NORTH);
        this.monPanelGlobal.add(monPanel, BorderLayout.CENTER);
        this.setVisible(true);
        
    }
    //Permet de retourner le panelGlobal
    public JPanel getMonPanelGlobal() {
	    return monPanelGlobal;
	  }
}