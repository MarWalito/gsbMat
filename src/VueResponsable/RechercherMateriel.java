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

public class RechercherMateriel extends JPanel implements ActionListener{
	//Panel
	private JPanel panelGlobal;
	private JPanel panelContenu;

	//Label
    private JLabel titre;
	private JLabel lblLibelle;
	private JLabel affichage;

    //Jtf
    private JTextField jtfLibelle;
    //Button
    private JButton btnValider;
	public RechercherMateriel() {
		//Panel
		panelGlobal = new JPanel();
		panelContenu = new JPanel();
		panelGlobal.setLayout(new BorderLayout());
		panelGlobal.setLayout(new GridLayout(14, 1));
        
		//Label
		titre = new JLabel("Rechercher un matériel");
		
		panelGlobal.add(titre, BorderLayout.CENTER);
		
		lblLibelle = new JLabel("Quel est le libelle du matériel ? ");
		panelGlobal.add(lblLibelle, BorderLayout.CENTER);
		jtfLibelle = new JTextField("");
		panelGlobal.add(jtfLibelle, BorderLayout.CENTER);
		
		//button
        btnValider = new JButton ("Valider");
		btnValider.addActionListener(this);
		panelGlobal.add(btnValider);
		
		affichage = new JLabel ("");
		panelGlobal.add(affichage);
    }
	public void actionPerformed ( ActionEvent evenement) {
		if(evenement.getSource() == btnValider) {
    		String libelle = jtfLibelle.getText();
    		String newLine = System.getProperty("line.separator");	
            JTextArea result = new JTextArea ("Erreur --> Ajout");
    		if(M_gsbMat.searchMateriel(libelle)) {
    			result = new JTextArea (M_gsbMat.getInfoMateriel(libelle)); 
    			panelGlobal.add(result);
    			panelGlobal.revalidate();
    			panelGlobal.repaint();
    		}
    		else {
    			result = new JTextArea ("Ecurie pas la");
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