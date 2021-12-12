package gsbMat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import gsbMat.Modele.M_gsbMat;

import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AfficherStatsD extends JPanel implements ActionListener{
    //Panel
    private JPanel panelGlobal;
    private JPanel panelContenu;

    //Label
    private JLabel titre;
    private JLabel nbPretsVisiteurs;
    private JLabel nbResponsables;
    private JLabel nbEmprunts;
    private JLabel nbMateriels;
    private JLabel nbVehicules;

    //JComboBox
    private JComboBox listeTypeMateriel;


    //Jtf
    private JTextField jtfnbVisiteurs;
    private JTextField jtfnbResponsables;
    private JTextField jtfnbEmprunts;
    private JTextField jtfnbMateriels;
    private JTextField jtfnbVehicules;

    //Date
    Date today = new Date();
    String sortie;
    DateFormat formatfr= DateFormat.getDateInstance(DateFormat.MONTH_FIELD, new Locale("fr","FR"));

    //Button
    private JButton btnValider;

    public AfficherStatsD() {
        //Panel
        panelGlobal = new JPanel();
        panelContenu = new JPanel();
        panelGlobal.setLayout(new BorderLayout());
        panelGlobal.setLayout(new GridLayout(14, 1));

        //Label
        titre = new JLabel("Affichage des statistiques : " + formatfr.format(today) );

        panelGlobal.add(titre, BorderLayout.CENTER);

        nbPretsVisiteurs = new JLabel("Nombre de prêts pour chaque visiteurs par type de materiel :");
        panelGlobal.add(nbPretsVisiteurs, BorderLayout.CENTER);

        //combo Box
        ArrayList<String> listeTypeMat = M_gsbMat.recupListeTypeMateriel();
        String typeMateriel[] = new String[M_gsbMat.getNbMateriel()];
        int i = 0;
        for (String unTypeMateriel : listeTypeMat) {
            typeMateriel[i] = unTypeMateriel;
            i++;
        }
        listeTypeMateriel = new JComboBox(typeMateriel);
        panelGlobal.add(listeTypeMateriel);
        listeTypeMateriel.addActionListener(this);

        //button
        btnValider = new JButton ("Valider");
        btnValider.addActionListener(this);
        panelGlobal.add(btnValider);

    }
    public void actionPerformed ( ActionEvent evenement) {
        if(evenement.getSource() == btnValider) {
            String libelle = titre.getText();
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