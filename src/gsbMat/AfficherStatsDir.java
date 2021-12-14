package gsbMat;
/**
 * @author yohann
 * Fenetre Afficher Circuit permettant l'affichage des circuits dans un tableau.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;

import javax.swing.*;

import gsbMat.Modele.M_gsbMat;

import java.util.ArrayList;

public class AfficherStatsDir extends JPanel implements ActionListener {

    //Attributs privés
    private JPanel panelTitre;
    private JPanel panelButton;
    private JPanel monPanel;
    private JPanel monPanelGlobal;
    private JButton btnpdf;
    private JLabel lblContenuContacts;
    private JTable tableau;
    private JScrollPane scrollPane;
    //On passe en paramètre une collection afin qu'il puisse afficher les circuits
    public AfficherStatsDir(ArrayList<Stats> uneListeStats) {
        //Declaration des panels, des bordures et des couleurs
        this.panelTitre = new JPanel();
        this.panelButton = new JPanel();
        this.monPanel = new JPanel();
        this.monPanelGlobal = new JPanel();
        this.panelTitre.setLayout(new BorderLayout());
        this.monPanel.setLayout(new BorderLayout());
        this.monPanelGlobal.setLayout(new BorderLayout());
        this.panelTitre.setBackground(Color.pink);
        this.panelButton.setBackground(Color.pink);
        this.monPanel.setBackground(Color.pink);
        this.monPanelGlobal.setBackground(Color.pink);
        
        btnpdf = new JButton ("Valider");
        btnpdf.addActionListener(this);
        panelButton.add(btnpdf);
        
        //Définition de la taille
        this.setSize(800, 400);
        //Instanciation du tableau qui va contenir les informations
        Object data[][]= new Object[20][20];
        int i = 0;
        //Boucle foreach permettant le parcours de la collection pour l'affichage.
        for (Stats uneStats : uneListeStats) {
            data[i][0] = uneStats.getNbEmprunts();
            data[i][1] = uneStats.getUnMateriel().getLibelle();
            i++;
        }
        String [] title = {"Nombre Emprunt", "Libelle Materiel"};
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
        
        panelButton.add(btnpdf);
        
        this.monPanelGlobal.add(panelTitre, BorderLayout.NORTH);
        this.monPanelGlobal.add(monPanel, BorderLayout.CENTER);
        this.monPanelGlobal.add(panelButton, BorderLayout.SOUTH);
        this.setVisible(true);

    }
    //Permet de retourner le panelGlobal
    public JPanel getMonPanelGlobal() {
        return monPanelGlobal;
    }
	@Override
	public void actionPerformed ( ActionEvent evenement) {
        if(evenement.getSource() == btnpdf) {
        	MessageFormat entete = new MessageFormat("Objet triés du plus empruntés au moins empruntés");
        	MessageFormat enbas = new MessageFormat("Page N°{0,number,integer}");

             try {
            	 tableau.print(JTable.PrintMode.NORMAL, entete, enbas );
             }catch(java.awt.print.PrinterException ev) {
            	 System.err.format("Soucis impression", ev.getMessage());
             }
        }
    }
}