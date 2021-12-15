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

public class SuppressionEmpruntVehV extends JPanel implements ActionListener{
	//Panel
	private JPanel panelGlobal;
	private JPanel panelContenu;

	//Label
    private JLabel titre;

	private JLabel lblType; 
	private JLabel affichage;    
    //Button
    private JButton btnValider;
    //JTextField
    private JTextField jtfId;
	
    public SuppressionEmpruntVehV() {
		//Panel
		panelGlobal = new JPanel();
		panelContenu = new JPanel();
		panelGlobal.setLayout(new BorderLayout());
		panelGlobal.setLayout(new GridLayout(14, 1));
        
		//Label
		titre = new JLabel("Supprimer un emprunt véhicule");
		
		panelGlobal.add(titre, BorderLayout.CENTER);
		
		lblType = new JLabel("Quel est l'id du véhicule emprunter ? ");
		panelGlobal.add(lblType, BorderLayout.CENTER);
		jtfId = new JTextField("");
		panelGlobal.add(jtfId, BorderLayout.CENTER);
	
		
		//button
        btnValider = new JButton ("Valider");
		btnValider.addActionListener(this);
		panelGlobal.add(btnValider);
		
		affichage = new JLabel ("");
		panelGlobal.add(affichage);
    }
	public void actionPerformed ( ActionEvent evenement) {
		if(evenement.getSource() == btnValider) {
    		int idVeh = Integer.parseInt(jtfId.getText());
    		if(M_gsbMat.deleteEmpruntVeh(idVeh)) {
    			panelGlobal.remove(affichage);
    			affichage.setText("Suppression good");
    			panelGlobal.add(affichage);
        		panelGlobal.revalidate();
        		panelGlobal.repaint();
    		}
    		else {
    			panelGlobal.remove(affichage);
    			affichage.setText("Suppression pas good");
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