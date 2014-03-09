package fr.Dilink.src.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import fr.Dilink.src.Config;
import fr.Dilink.src.FrameChangeDirectory;
import fr.Dilink.src.Util;

public class PanelListeImages extends JPanel
{
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	public static DefaultListModel modele;
	public static String TITRE;
	@SuppressWarnings("unused")
	private Font police;
	public static JLabel etiquette;
	@SuppressWarnings("rawtypes")
	public static JList liste;
	private JScrollPane scrolling;
	private Dimension dim;
	Util util = new Util();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PanelListeImages() {
		this.setBackground(new Color(0xBDBDBD));
		// police
		police = new Font("Verdana", 0, 20);
		dim = new Dimension(480, 727);
		// panneau
//		panneau = new JPanel();
//		panneau.setAutoscrolls(true);
		
		// signature
		etiquette = new JLabel();
		etiquette.setText("'" + Config.getProperty("directory") + "'");
		etiquette.setFont(util.fontLight);
		etiquette.setForeground(new Color(0x4A4A4A));
		etiquette.addMouseListener(new EtiquetteMouse());
//		etiquette.setAutoscrolls(true);
		// modele
		modele = new DefaultListModel();
		// liste
		liste = new JList(modele);
		liste.setFont(util.fontBig);
		liste.setAutoscrolls(true);
		liste.setBackground(new Color(0xE1E2E2));
		liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		liste.setCellRenderer(new CellRenderer());
		// scrolling
		scrolling = new JScrollPane(liste);
		scrolling.setPreferredSize(dim);
		scrolling.setAutoscrolls(true);
		
		this.setAutoscrolls(true);
		this.add(etiquette);
		this.add(scrolling);
	}
	@SuppressWarnings("unchecked")
	public static void afficherTexte(String texte) {
		modele.addElement(texte);
	}
}
class EtiquetteMouse extends MouseAdapter {
	@Override
    public void mousePressed(MouseEvent evt) {
        try {
        	new FrameChangeDirectory("Choisissez le dossier").setIconImage(Util.icone);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}