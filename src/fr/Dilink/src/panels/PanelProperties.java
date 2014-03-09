package fr.Dilink.src.panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.Dilink.src.Config;
import fr.Dilink.src.Util;

public class PanelProperties extends JPanel
{
	private static final long serialVersionUID = 1L;
	JTextField fileName = new JTextField();
	JTextField fileDirectory = new JTextField();
	JButton modifyName = new JButton("Renommer");
	JButton modifyDirectory = new JButton("Déplacer");
	JButton copyFile = new JButton("Copier");
	Util util = new Util();

	public PanelProperties() {
		setLayout(null);
//		this.setBackground(new Color(0xBDBDBD));
		this.setBackground(new Color(0x717171));
		PanelListeImages.liste.addMouseListener(mouseListener);
		
		fileName.setSize(397, 86);
		fileName.setLocation(51, 51);
		
		fileDirectory.setSize(397, 86);
		fileDirectory.setLocation(51, 186);
		
		/*
		 * BOUTONS
		 */
		copyFile.setSize(98, 40);
		copyFile.setLocation(51, 307);  // 149
		
		modifyName.setSize(140, 40);
		modifyName.setLocation(169, 307); // 169
		
		modifyDirectory.setSize(121, 40);
		modifyDirectory.setLocation(327, 307); // 178
		/*
		 * FIN DES BOUTONS
		 */
		
		fileName.setFont(util.fontBig);
		fileDirectory.setFont(util.fontBig);
		modifyName.setFont(util.fontLight);
		modifyDirectory.setFont(util.fontLight);
		copyFile.setFont(util.fontLight);

		modifyName.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	Util.rename(fileName.getText());
	        }
	    });
		modifyDirectory.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	            Util.moveFile(fileDirectory.getText());
	        }
	    });
		copyFile.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	            Util.copyFile(fileDirectory.getText());
	        }
	    });
	}
	MouseListener mouseListener = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 1) {
				paint(getGraphics());
			}
		}
	};

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.DARK_GRAY);
		g.drawRect(4, 4, this.getWidth() - 10, this.getHeight() - 10);
		g.drawRect(5, 5, this.getWidth() - 12, this.getHeight() - 12);
		g.drawRect(6, 6, this.getWidth() - 14, this.getHeight() - 14);
		
		if(PanelListeImages.liste.getSelectedValue() != null) {
			g.drawRect(50, 50, this.getWidth() - 100, this.getHeight() - 300); // File Name
			g.drawRect(50, 185, this.getWidth() - 100, this.getHeight() - 300); // File Directory
//			g.drawRect(13, 308, 79, 38); // Copy File
//			g.drawRect(104, 308, 156, 38); // Modify Name
//			g.drawRect(272, 308, 210, 38); // Modify Directory
			fileName.setText(Util.isSelectedValue());
			add(fileName);
			fileDirectory.setText(new File(Config.getProperty("directory") + "/" + PanelListeImages.liste.getSelectedValue().toString()).getAbsolutePath().replace(Util.isSelectedValue(), ""));
			add(fileDirectory);
			add(modifyName);
			add(modifyDirectory);
			add(copyFile);
		}
	}
}