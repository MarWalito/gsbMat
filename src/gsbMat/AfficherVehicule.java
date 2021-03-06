package gsbMat;
/**
 * @author yohann
 * Fenetre Afficher Circuit permettant l'affichage des circuits dans un tableau.
 */
import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
import java.util.ArrayList;

public class AfficherVehicule extends JPanel{
    
    //Attributs priv?s
    private JPanel panelTitre;
    private JPanel monPanel;
    private JPanel monPanelGlobal;
    private JLabel lblContenuContacts;
    private JTable tableau;
    private JScrollPane scrollPane;
    //On passe en param?tre une collection afin qu'il puisse afficher les circuits
    public AfficherVehicule(ArrayList<Vehicule> uneListeVehicule) {
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
        //D?finition de la taille
        this.setSize(800, 400);
        //Instanciation du tableau qui va contenir les informations
        Object data[][]= new Object[20][20]; 
        int i = 0; 
        //Boucle foreach permettant le parcours de la collection pour l'affichage.
        for (Vehicule unVehicule : uneListeVehicule) {
            data[i][0] = unVehicule.getId();
            data[i][1] = unVehicule.getImmat();
            data[i][2] = unVehicule.getModele();
            data[i][3] = unVehicule.getMarque();
            data[i][4] = unVehicule.getNbPlaces();
            
            i++;
        }
        String [] title = {"Id", "Immatriculation", "Modele", "Marque", "Nombres places"}; 
        //On instancie le tableau
        this.tableau = new JTable(data,title);       
        //On d?finis la taille du tableau
        this.tableau.setPreferredScrollableViewportSize(new Dimension(450, 400)); 

        // Espacement entre les cases
        this.tableau.setRowHeight(30); 
                        
        // Oblig? d'add un JScrollPane         
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