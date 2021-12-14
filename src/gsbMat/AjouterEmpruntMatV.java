package gsbMat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import gsbMat.Modele.M_gsbMat;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Properties;

public class AjouterEmpruntMatV extends JPanel implements ActionListener{
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
    private JTextField jtfDateDebut;
    private JTextField jtfDateFin;
    private JTextField jtfDuree;
    private JTextField jtfIdVisiteur;
    
    private JTextField jtfLoginVisiteur;
    
    private JComboBox listeMateriel;
    
    private JDatePickerImpl datePicker;
    private JDatePickerImpl datePicker2;
    
    //Button
    private JButton btnValider;
	public AjouterEmpruntMatV(String unlogin) {
		//Panel
		panelGlobal = new JPanel();
		panelContenu = new JPanel();
		panelGlobal.setLayout(new BorderLayout());
		panelGlobal.setLayout(new GridLayout(14, 1));
        
		
		this.jtfLoginVisiteur = new JTextField(); 
		this.jtfLoginVisiteur.setText(unlogin);
		
		//Label
		titre = new JLabel("Ajouter un materiel");
		
		panelGlobal.add(titre, BorderLayout.CENTER);
		
		lblId = new JLabel("Quel est le nom du materiel ? ");
		panelGlobal.add(lblId, BorderLayout.CENTER);
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
		
		lblLibelle = new JLabel("Quel est la date du debut ? ");
		panelGlobal.add(lblLibelle, BorderLayout.CENTER);
		//DatePickerDebut
        SqlDateModel model = new SqlDateModel();
        Properties p = new Properties();
        p.put("text.day", "Day");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl panel = new JDatePanelImpl(model,p);
        this.datePicker = new JDatePickerImpl(panel, new DateLabelFormatter());
        this.datePicker.setMaximumSize(new Dimension(150,30));
        
        panelGlobal.add(datePicker);
		
		lblLongueur = new JLabel("Quelle est la date de fin ? ");
		panelGlobal.add(lblLongueur, BorderLayout.CENTER);
		//DatePickerDebut
        SqlDateModel model2 = new SqlDateModel();
        Properties p2 = new Properties();
        p2.put("text.day", "Day");
        p2.put("text.month", "Month");
        p2.put("text.year", "Year");
        JDatePanelImpl panel2 = new JDatePanelImpl(model2,p2);
        this.datePicker2 = new JDatePickerImpl(panel2, new DateLabelFormatter());
        this.datePicker2.setMaximumSize(new Dimension(150,30));
        
        panelGlobal.add(datePicker2);
		
		lblLongueur = new JLabel("Quelle est la duree ? ");
		panelGlobal.add(lblLongueur, BorderLayout.CENTER);
		jtfDuree = new JTextField("");
		panelGlobal.add(jtfDuree, BorderLayout.CENTER);
		
		//button
        btnValider = new JButton ("Valider");
		btnValider.addActionListener(this);
		panelGlobal.add(btnValider);
		
		affichage = new JLabel ("");
		panelGlobal.add(affichage);
    }
	public void actionPerformed ( ActionEvent evenement) {
		if(evenement.getSource() == btnValider) {
			
			String loginVisiteur = jtfLoginVisiteur.getText();
			int idVisiteur = M_gsbMat.rcpIdVis(loginVisiteur);
			String libelle = (String)listeMateriel.getSelectedItem();
    		int idMat = M_gsbMat.rcpIdMat(libelle);
    		java.sql.Date dateDebut = (java.sql.Date) AjouterEmpruntMatV.this.datePicker.getModel().getValue();
    		java.sql.Date dateFin = (java.sql.Date) AjouterEmpruntMatV.this.datePicker2.getModel().getValue();
    		float duree = Integer.parseInt(jtfDuree.getText());
    		if(M_gsbMat.addEmpruntM(idMat, dateDebut, dateFin,duree,idVisiteur)) {
    			panelGlobal.remove(affichage);
    			affichage.setText("Ajout good");
    			panelGlobal.add(affichage);
        		panelGlobal.revalidate();
        		panelGlobal.repaint();
    		}
    		else {
    			panelGlobal.remove(affichage);
    			affichage.setText("Ajout pas good");
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