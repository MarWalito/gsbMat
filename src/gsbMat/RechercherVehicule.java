package gsbMat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

import gsbMat.Modele.M_gsbMat;

import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RechercherVehicule extends JPanel implements ActionListener{
	//Panel
	private JPanel panelGlobal;
	private JPanel panelContenu;

	//Label
    private JLabel titre;
	private JLabel lblLibelle;
	private JLabel affichage;

    //Jtf
    private JTextField jtfImmat;
    //Button
    private JButton btnValider;
	public RechercherVehicule() {
		//Panel
		panelGlobal = new JPanel();
		panelContenu = new JPanel();
		panelGlobal.setLayout(new BorderLayout());
		panelGlobal.setLayout(new GridLayout(14, 1));
        
		//Label
		titre = new JLabel("Rechercher un matériel");
		
		panelGlobal.add(titre, BorderLayout.CENTER);
		
		lblLibelle = new JLabel("Quel est l'immatriculation du véhicule ? ");
		panelGlobal.add(lblLibelle, BorderLayout.CENTER);
		jtfImmat = new JTextField("");
		panelGlobal.add(jtfImmat, BorderLayout.CENTER);
		
		//button
        btnValider = new JButton ("Valider");
		btnValider.addActionListener(this);
		panelGlobal.add(btnValider);
		
		affichage = new JLabel ("");
		panelGlobal.add(affichage);
    }
	public void actionPerformed ( ActionEvent evenement) {
		if(evenement.getSource() == btnValider) {
    		String immat = jtfImmat.getText();
    		String newLine = System.getProperty("line.separator");	
            JTextArea result = new JTextArea ("Erreur --> Ajout");
    		if(M_gsbMat.searchVehicule(immat)) {
    			result = new JTextArea (M_gsbMat.getInfoVehicule(immat)); 
    			panelGlobal.add(result);
    			panelGlobal.revalidate();
    			panelGlobal.repaint();
    		}
    		else {
    			result = new JTextArea ("Recherche pas good");
    			panelGlobal.add(result);
    			panelGlobal.revalidate();
    			panelGlobal.repaint(); 
    		}
    	}
    }
	
	public JPanel getMonPanelGlobal() {
	    return panelGlobal;
	}

	
}