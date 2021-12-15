package VueResponsable;
/**
 * @author yohann
 * Fenetre Afficher Circuit permettant l'affichage des circuits dans un tableau.
 */
import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

import gsbMat.Materiel;

import java.util.ArrayList;

public class AfficherMateriel extends JPanel{
    
    //Attributs privés
    private JPanel panelTitre;
    private JPanel monPanel;
    private JPanel monPanelGlobal;
    private JLabel lblContenuContacts;
    private JTable tableau;
    private JScrollPane scrollPane;
    //On passe en paramètre une collection afin qu'il puisse afficher les circuits
    public AfficherMateriel(ArrayList<Materiel> uneListeMateriel) {
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
        for (Materiel unMateriel : uneListeMateriel) {
            data[i][0] = unMateriel.getId();
            data[i][1] = unMateriel.getLibelle();
            data[i][2] = unMateriel.getLongueur();
            data[i][3] = unMateriel.getLargeur();
            data[i][4] = unMateriel.getType();
            
            i++;
        }
        String [] title = {"Id", "Libelle", "Longueur", "Largeur", "Type"}; 
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