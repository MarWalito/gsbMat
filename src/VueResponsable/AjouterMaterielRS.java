package VueResponsable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

import gsbMat.Modele.M_gsbMat;

import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AjouterMaterielRS extends JPanel implements ActionListener{
	//Panel
	private JPanel panelGlobal;
	private JPanel panelContenu;

	//Label
    private JLabel titre;
	private JLabel lblId;
	private JLabel lblLibelle;
	private JLabel lblLargeur;
	private JLabel lblLongueur;
	private JLabel lblType; 
	private JLabel affichage;

    //Jtf
    private JTextField jtfId;
    private JTextField jtfLibelle;
    private JTextField jtfLargeur;
    private JTextField jtfLongueur;
    private JTextField jtfType;
    
    //Button
    private JButton btnValider;
	public AjouterMaterielRS() {
		//Panel
		panelGlobal = new JPanel();
		panelContenu = new JPanel();
		panelGlobal.setLayout(new BorderLayout());
		panelGlobal.setLayout(new GridLayout(14, 1));
        
		//Label
		titre = new JLabel("Ajouter un materiel");
		panelGlobal.add(titre, BorderLayout.CENTER);
		//Ajout label + jtf
		lblId = new JLabel("Quel est l'id du materiel ? ");
		panelGlobal.add(lblId, BorderLayout.CENTER);
		jtfId = new JTextField("");
		panelGlobal.add(jtfId, BorderLayout.CENTER);
		//Ajout label + jtf
		lblLibelle = new JLabel("Quel est le libelle du materiel ? ");
		panelGlobal.add(lblLibelle, BorderLayout.CENTER);
		jtfLibelle = new JTextField("");
		panelGlobal.add(jtfLibelle, BorderLayout.CENTER);
		//Ajout label + jtf
		lblLongueur = new JLabel("Quelle est la largeur ? ");
		panelGlobal.add(lblLongueur, BorderLayout.CENTER);
		jtfLargeur = new JTextField("");
		panelGlobal.add(jtfLargeur, BorderLayout.CENTER);
		//Ajout label + jtf
		lblLongueur = new JLabel("Quelle est la longueur ? ");
		panelGlobal.add(lblLongueur, BorderLayout.CENTER);
		jtfLongueur = new JTextField("");
		panelGlobal.add(jtfLongueur, BorderLayout.CENTER);
		//Ajout label + jtf
		lblType = new JLabel("Quelle est le type ? ");
		panelGlobal.add(lblType, BorderLayout.CENTER);
		jtfType = new JTextField("");
		panelGlobal.add(jtfType, BorderLayout.CENTER);
		
		//button
        btnValider = new JButton ("Valider");
		btnValider.addActionListener(this);
		panelGlobal.add(btnValider);
		
		affichage = new JLabel ("");
		panelGlobal.add(affichage);
    }
	//Action performe pour faire l'insertion lorsque l'on appuie sur le bouton
	public void actionPerformed ( ActionEvent evenement) {
		if(evenement.getSource() == btnValider) {
    		int id = Integer.parseInt(jtfId.getText());
    		String libelle = jtfLibelle.getText();
    		float largeur = Integer.parseInt(jtfLargeur.getText());
    		int longueur = Integer.parseInt(jtfLongueur.getText());
    		String type = jtfType.getText();
    		if(M_gsbMat.addMateriel(id,libelle, largeur,longueur,type)) {
    			panelGlobal.remove(affichage);
    			affichage.setText("Vous avez ajouté du matériel de type " + type);
    			panelGlobal.add(affichage);
        		panelGlobal.revalidate();
        		panelGlobal.repaint();
    		}
    		else {
    			panelGlobal.remove(affichage);
    			affichage.setText("Ajout pas bon");
    			panelGlobal.add(affichage);
        		panelGlobal.revalidate();
        		panelGlobal.repaint(); 
    		}
    	}
    }
	
	public JPanel getMonPanelGlobal() {
	    return panelGlobal;
	}

	
}