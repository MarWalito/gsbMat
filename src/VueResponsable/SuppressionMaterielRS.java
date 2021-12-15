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

public class SuppressionMaterielRS extends JPanel implements ActionListener{
	//Panel
	private JPanel panelGlobal;
	private JPanel panelContenu;

	//Label
    private JLabel titre;

	private JLabel lblType; 
	private JLabel affichage;    
    //Button
    private JButton btnValider;
    //JComboBox
    private JComboBox listeMateriel;
	
    public SuppressionMaterielRS() {
		//Panel
		panelGlobal = new JPanel();
		panelContenu = new JPanel();
		panelGlobal.setLayout(new BorderLayout());
		panelGlobal.setLayout(new GridLayout(14, 1));
        
		//Label
		titre = new JLabel("Supprimer un matériel");
		
		panelGlobal.add(titre, BorderLayout.CENTER);
		//Ajout label
		lblType = new JLabel("Quel est le type du matériel ? ");
		panelGlobal.add(lblType, BorderLayout.CENTER);
		//combo Box
        ArrayList<String> listePilote = M_gsbMat.recupListeMateriel();
        String nomPilote[] = new String[M_gsbMat.getNbMateriel()];
        int i = 0; 
        for (String unPilote : listePilote) {
        	nomPilote[i] = unPilote;
            i++;
        }
        listeMateriel = new JComboBox(nomPilote);
        panelGlobal.add(listeMateriel);
        listeMateriel.addActionListener(this);
	
		
		//button
        btnValider = new JButton ("Valider");
		btnValider.addActionListener(this);
		panelGlobal.add(btnValider);
		
		affichage = new JLabel ("");
		panelGlobal.add(affichage);
    }
    //Action perform pour valider la recherche lorsqu'on sélectionne un truc dans la combo box
	public void actionPerformed ( ActionEvent evenement) {
		if(evenement.getSource() == btnValider) {
    		
    		String type = listeMateriel.getSelectedItem().toString();
    		if(M_gsbMat.deleteMateriel(type)) {
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