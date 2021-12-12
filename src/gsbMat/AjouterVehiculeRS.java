package gsbMat;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

import gsbMat.Modele.M_gsbMat;

import java.awt.event.ActionListener;

public class AjouterVehiculeRS extends JPanel implements ActionListener{
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
	public AjouterVehiculeRS() {
		//Panel
		panelGlobal = new JPanel();
		panelContenu = new JPanel();
		panelGlobal.setLayout(new BorderLayout());
		panelGlobal.setLayout(new GridLayout(14, 1));
        
		//Label
		titre = new JLabel("Ajouter un véhicule");
		
		panelGlobal.add(titre, BorderLayout.CENTER);
		
		lblId = new JLabel("Quel est l'id du véhicule ? ");
		panelGlobal.add(lblId, BorderLayout.CENTER);
		jtfId = new JTextField("");
		panelGlobal.add(jtfId, BorderLayout.CENTER);
		
		lblLibelle = new JLabel("Quel est l'immatriculation du véhicule ?( XX-000-XX) ");
		panelGlobal.add(lblLibelle, BorderLayout.CENTER);
		jtfLibelle = new JTextField("");
		panelGlobal.add(jtfLibelle, BorderLayout.CENTER);
		
		lblLargeur = new JLabel("Quelle est le modèle ? ");
		panelGlobal.add(lblLargeur, BorderLayout.CENTER);
		jtfLargeur = new JTextField("");
		panelGlobal.add(jtfLargeur, BorderLayout.CENTER);
		
		lblLongueur = new JLabel("Quelle est la marque ? ");
		panelGlobal.add(lblLongueur, BorderLayout.CENTER);
		jtfLongueur = new JTextField("");
		panelGlobal.add(jtfLongueur, BorderLayout.CENTER);
		
		lblType = new JLabel("Quelle est le nombre de places ? ");
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
	public void actionPerformed ( ActionEvent evenement) {
		if(evenement.getSource() == btnValider) {
    		int id = Integer.parseInt(jtfId.getText());
    		String immat = jtfLibelle.getText();
    		String modele = jtfLargeur.getText();
    		String marque = jtfLongueur.getText();
    		int nbPlaces = Integer.parseInt(jtfType.getText());
    		if(M_gsbMat.addVehicule(id,immat,modele,marque, nbPlaces)) {
    			panelGlobal.remove(affichage);
    			affichage.setText("Ajout good");
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